package ee.siimp.app.client;

import ee.siimp.app.country.CountryRepository;
import ee.siimp.app.user.UserClientUpdateForm;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
@RequiredArgsConstructor
public class ClientService {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ClientRepository clientRepository;

    private final CountryRepository countryRepository;

    public Client update(Client client, UserClientUpdateForm updateForm) {
        LOG.info("updating client {}", client);

        client.setAddress(updateForm.getAddress());
        client.setCountry(countryRepository.getOne(updateForm.getCountry()));
        client.setEmail(updateForm.getEmail());
        client.setFirstName(updateForm.getFirstName());
        client.setLastName(updateForm.getLastName());
        client.setUserName(updateForm.getUserName());
        client.setVersion(updateForm.getVersion());
        return clientRepository.save(client);
    }
}
