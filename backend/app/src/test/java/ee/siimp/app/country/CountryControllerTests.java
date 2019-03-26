package ee.siimp.app.country;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CountryController.class)
public class CountryControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CountryRepository countryRepository;

    @MockBean
    private BCryptPasswordEncoder passwordEncoder;

    @MockBean
    private DaoAuthenticationProvider daoAuthenticationProvider;

    @WithMockUser("test_user")
    @Test
    public void shouldReturnAllCountries() throws Exception {
        CountryDto country = new CountryDto(1L, "country");
        given(countryRepository.findAllBy(eq(CountryDto.class)))
                .willReturn(Collections.singletonList(country));

        mvc.perform(get("/country")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(country.getName())));
    }
}
