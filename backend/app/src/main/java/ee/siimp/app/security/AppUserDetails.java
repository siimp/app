package ee.siimp.app.security;

import ee.siimp.app.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
class AppUserDetails extends org.springframework.security.core.userdetails.User {

    private Long userId;

    AppUserDetails(User user) {
        super(user.getUsername(), user.getEncryptedPassword(), Collections.emptyList());
        setUserId(user.getId());
    }
}
