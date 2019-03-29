package ee.siimp.app.client;

import ee.siimp.app.country.CountryRepository;
import ee.siimp.app.user.User;
import ee.siimp.app.user.UserClientForm;
import ee.siimp.app.user.UserClientUpdateForm;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.lang.invoke.MethodHandles;

@Service
@RequiredArgsConstructor
public class ClientService {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ClientRepository clientRepository;

    private final CountryRepository countryRepository;

    private final EntityManager entityManager;

    public Client update(Client client, UserClientUpdateForm updateForm) {
        LOG.info("updating client {} with data {}", client.getId(), updateForm);

        updateClientFromForm(client, updateForm);
        client.setVersion(updateForm.getVersion());
        return clientRepository.save(client);
    }

    public Client save(Long userId, UserClientForm userClientForm) {
        LOG.info("creating new client with data {}", userClientForm);
        Client client = new Client();
        updateClientFromForm(client, userClientForm);
        client.setUser(entityManager.getReference(User.class, userId));
        return clientRepository.save(client);
    }

    private void updateClientFromForm(Client client, UserClientForm form) {
        client.setAddress(form.getAddress());
        client.setCountry(countryRepository.getOne(form.getCountry()));
        client.setEmail(form.getEmail());
        client.setFirstName(form.getFirstName());
        client.setLastName(form.getLastName());
        client.setUsername(form.getUsername());
    }
}
