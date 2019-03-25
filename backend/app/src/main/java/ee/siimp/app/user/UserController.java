package ee.siimp.app.user;

import ee.siimp.app.client.ClientRepository;
import ee.siimp.app.security.AuthorizationUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ClientRepository clientRepository;

    @GetMapping
    public Principal user(Principal principal) {
        LOG.info("returning user info for user {}", principal.getName());
        return principal;
    }

    @GetMapping("/{id:\\d+}/client")
    public Collection<UserClientDto> findAll(Principal principal, @PathVariable("id") Long userId) {
        AuthorizationUtils.isSameUser(principal, userId);
        LOG.info("finding all clients for user {}", userId);
        Collection<UserClientDto> result = clientRepository.findAllBy(UserClientDto.class);
        LOG.info("found {} results", result.size());
        return result;
    }


    @PostMapping("/{id:\\d+}/client")
    public UserClientDto addClient(Principal principal, @PathVariable("id") Long userId,
                                   @RequestBody @Valid UserClientForm userClientForm) {
        AuthorizationUtils.isSameUser(principal, userId);
        LOG.info("adding new client for user {}", userId);
        return null;
    }

    @PostMapping("/{id:\\d+}/client//{clientId:\\d+}")
    public UserClientDto updateClient(Principal principal, @PathVariable("id") Long userId,
                                      @PathVariable("clientId") Long clientId,
                                      @RequestBody @Valid UserClientUpdateForm userClientUpdateForm) {
        AuthorizationUtils.isSameUser(principal, userId);
        LOG.info("updating client {} new client for user {}", clientId, userId);
        return null;
    }


}
