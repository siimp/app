package ee.siimp.app.user;

import lombok.Value;

@Value
class UserClientDto {

    Long id;
    Long version;
    String firstName;
    String lastName;
    String userName;
}
