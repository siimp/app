package ee.siimp.app.user;

import ee.siimp.app.client.ClientRepository;
import ee.siimp.app.security.AuthorizationUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        LOG.info("finding all clients for user {}", principal.getName());
        AuthorizationUtils.isSameUser(principal, userId);
        Collection<UserClientDto> result = clientRepository.findAllBy(UserClientDto.class);
        LOG.info("found {} results", result.size());
        return result;
    }


}
