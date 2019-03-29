package ee.siimp.app.user;

import ee.siimp.app.client.Client;
import ee.siimp.app.client.ClientRepository;
import ee.siimp.app.client.ClientService;
import ee.siimp.app.common.utils.EntityUtils;
import ee.siimp.app.security.AppUserDetails;
import ee.siimp.app.security.AuthorizationUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ClientRepository clientRepository;

    private final ClientService clientService;

    @GetMapping
    public UserDto currentUser(Principal principal) {
        LOG.info("returning user info for user {}", principal.getName());
        AppUserDetails appUserDetails = AuthorizationUtils.getAppUserDetails(principal);
        LOG.info("found user {}", appUserDetails.getUsername());
        return new UserDto(appUserDetails.getUserId(), appUserDetails.getUsername());
    }

    @GetMapping("/{id:\\d+}/client")
    public Collection<UserClientDto> findAll(Principal principal, @PathVariable("id") Long userId) {
        AuthorizationUtils.isSameUser(principal, userId);
        LOG.info("finding all clients for user {}", userId);
        Collection<UserClientDto> result = clientRepository.findAllByUserId(userId, UserClientDto.class);
        LOG.info("found {} results", result.size());
        return result;
    }

    @PostMapping("/{id:\\d+}/client")
    public ResponseEntity<UserClientDto> addClient(Principal principal, @PathVariable("id") Long userId,
                                                   @RequestBody @Valid UserClientForm userClientForm) {
        AuthorizationUtils.isSameUser(principal, userId);
        LOG.info("adding new client for user {}", userId);
        Client client = clientService.save(userId, userClientForm);
        LOG.info("adding new client succeeded, new client id is {}", client.getId());
        return ResponseEntity.ok(UserClientDto.of(client));
    }

    @GetMapping("/{id:\\d+}/client/{clientId:\\d+}")
    public ResponseEntity<UserClientUpdateForm> getClient(Principal principal, @PathVariable("id") Long userId,
                                                   @PathVariable("clientId") Long clientId) {
        AuthorizationUtils.isSameUser(principal, userId);
        LOG.info("getting client info for user {}", userId);

        Optional<Client> userClientOptional =
                clientRepository.findByIdAndUserId(clientId, userId);
        if (userClientOptional.isPresent()) {
            LOG.info("found client {}", userClientOptional.get());
        } else {
            LOG.error("no client found with id {}", clientId);
        }

        return ResponseEntity.of(UserClientUpdateForm.ofOptional(userClientOptional));
    }

    @PutMapping("/{id:\\d+}/client/{clientId:\\d+}")
    public ResponseEntity<UserClientDto> updateClient(Principal principal, @PathVariable("id") Long userId,
                                                      @PathVariable("clientId") Long clientId,
                                                      @RequestBody @Valid UserClientUpdateForm userClientUpdateForm) {
        AuthorizationUtils.isSameUser(principal, userId);
        LOG.info("updating client id={}", clientId);


        Optional<Client> userClientOptional = clientRepository.findByIdAndUserId(clientId, userId);
        if (!userClientOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        } else if (!EntityUtils.isSameVersion(userClientOptional.get(), userClientUpdateForm.getVersion())) {
            LOG.error("client was updated loaded version was {} current version is {}",
                    userClientUpdateForm.getVersion(), userClientOptional.get().getVersion());
            return ResponseEntity.badRequest().build();
        }

        Client client = clientService.update(userClientOptional.get(), userClientUpdateForm);
        LOG.info("update succeeded");
        return ResponseEntity.ok(UserClientDto.of(client));
    }


}
