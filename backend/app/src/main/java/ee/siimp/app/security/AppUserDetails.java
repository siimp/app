package ee.siimp.app.security;

import ee.siimp.app.user.User;

import java.util.Collections;

public class AppUserDetails extends org.springframework.security.core.userdetails.User {

    public AppUserDetails(User user) {
        super(user.getUsername(), user.getEncryptedPassword(), Collections.emptyList());
    }
}
