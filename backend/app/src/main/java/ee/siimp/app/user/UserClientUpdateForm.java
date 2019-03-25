package ee.siimp.app.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class UserClientUpdateForm extends UserClientForm {

    @NotNull
    private Long version;
}
