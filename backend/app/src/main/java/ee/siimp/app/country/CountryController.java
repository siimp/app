package ee.siimp.app.country;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.Collection;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final CountryRepository countryRepository;

    @GetMapping
    public Collection<CountryDto> findAll() {
        LOG.info("finding all countries");
        Collection<CountryDto> result = countryRepository.findAllBy(CountryDto.class);
        LOG.info("found {} results", result.size());
        return result;
    }
}
