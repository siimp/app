package ee.siimp.app.security;

import lombok.experimental.UtilityClass;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Principal;

@UtilityClass
public class AuthorizationUtils {

    public static void isSameUser(Principal principal, Long userId) {
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
            if (token.getPrincipal() instanceof AppUserDetails) {
                AppUserDetails appUserDetails = (AppUserDetails) token.getPrincipal();
                if (userId != null && userId.equals(appUserDetails.getUserId())) {
                    return;
                }
                throw new UserNotSameException(String.format("authenticated user %d is not same as %d",
                        appUserDetails.getUserId(), userId));
            }
        }

        throw new UserNotSameException("users are not the same");
    }

}
