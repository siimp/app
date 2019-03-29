package ee.siimp.app.security;

import lombok.experimental.UtilityClass;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Principal;

@UtilityClass
public class AuthorizationUtils {

    public static void isSameUser(Principal principal, Long userId) {
        AppUserDetails appUserDetails = getAppUserDetails(principal);
        if (appUserDetails != null) {
            if (userId != null && userId.equals(appUserDetails.getUserId())) {
                return;
            }
            throw new UserNotSameException(String.format("authenticated user %d is not same as %d",
                    appUserDetails.getUserId(), userId));
        }

        throw new UserNotSameException("users are not the same");
    }

    public static AppUserDetails getAppUserDetails(Principal principal) {
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
            if (token.getPrincipal() instanceof AppUserDetails) {
                return (AppUserDetails) token.getPrincipal();
            }
        }
        return null;
    }
}
