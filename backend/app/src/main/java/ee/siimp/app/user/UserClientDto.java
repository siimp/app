package ee.siimp.app.user;

import lombok.Value;

@Value
class UserClientDto {

    Long id;
    String firstName;
    String lastName;
    String userName;
}
