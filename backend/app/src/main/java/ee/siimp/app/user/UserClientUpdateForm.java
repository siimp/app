package ee.siimp.app.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserClientUpdateForm extends UserClientForm {

    @NotNull
    private Long id;

    @NotNull
    private Long version;
}
