package ee.siimp.app.user;

import ee.siimp.app.client.Client;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Getter
@Setter
@ToString
public class UserClientUpdateForm extends UserClientForm {

    @NotNull
    private Long version;

    static Optional<UserClientUpdateForm> ofOptional(Optional<Client> clientOptional) {
        UserClientUpdateForm form = null;
        if (clientOptional.isPresent()) {
            form = new UserClientUpdateForm();
            Client client = clientOptional.get();
            form.setVersion(client.getVersion());
            form.setAddress(client.getAddress());
            form.setCountry(client.getCountry().getId());
            form.setEmail(client.getEmail());
            form.setFirstName(client.getFirstName());
            form.setLastName(client.getLastName());
            form.setUsername(client.getUsername());
        }

        return Optional.ofNullable(form);
    }
}
