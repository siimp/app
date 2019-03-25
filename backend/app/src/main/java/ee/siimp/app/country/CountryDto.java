package ee.siimp.app.country;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
class CountryDto {
    Long id;
    String name;
}
