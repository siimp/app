package ee.siimp.app.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import ee.siimp.app.client.Client;
import lombok.ToString;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
class UserClientDto {

    Long id;
    Long version;
    String firstName;
    String lastName;
    String userName;

    static UserClientDto of(Client client) {
        return new UserClientDto(client.getId(), client.getVersion(),
                client.getFirstName(), client.getLastName(), client.getUserName());
    }
}
