package ee.siimp.app.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.security.Principal;

@RestController
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/user")
    public Principal user(Principal principal) {
        LOG.info("returning user info for user {}", principal.getName());
        return principal;
    }


}
