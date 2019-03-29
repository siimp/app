package ee.siimp.app.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
class UserDto {
    Long id;
    String username;
}
