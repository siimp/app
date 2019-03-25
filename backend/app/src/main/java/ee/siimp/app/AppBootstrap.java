package ee.siimp.app;

import ee.siimp.app.client.Client;
import ee.siimp.app.client.ClientRepository;
import ee.siimp.app.country.Country;
import ee.siimp.app.country.CountryRepository;
import ee.siimp.app.user.User;
import ee.siimp.app.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AppBootstrap implements InitializingBean {

    private final UserRepository userRepository;

    private final CountryRepository countryRepository;

    private final ClientRepository clientRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void afterPropertiesSet() {
        createCountries();

        User user1 = User.builder()
                .username("test")
                .encryptedPassword(passwordEncoder.encode("test"))
                .build();
        user1 = userRepository.save(user1);
        createUser1Clients(user1);

        User user2 = User.builder()
                .username("other")
                .encryptedPassword(passwordEncoder.encode("other"))
                .build();
        user2 = userRepository.save(user2);
        createUser2Clients(user2);

    }

    private void createUser2Clients(User user) {
        List<Country> countries = countryRepository.findAll();

        Client client1 = Client.builder()
                .address("other client 1 address")
                .country(countries.get(2))
                .email("otherclient1@email.com")
                .firstName("otherclient1")
                .lastName("otherclient1last")
                .userName("other_client1_username")
                .user(user)
                .build();
        clientRepository.save(client1);
    }

    private void createUser1Clients(User user) {
        List<Country> countries = countryRepository.findAll();

        Client client1 = Client.builder()
                .address("client 1 address")
                .country(countries.get(0))
                .email("client1@email.com")
                .firstName("client1")
                .lastName("client1last")
                .userName("client1_username")
                .user(user)
                .build();
        clientRepository.save(client1);

        Client client2 = Client.builder()
                .address("client 2 address")
                .country(countries.get(1))
                .email("client2@email.com")
                .firstName("client2")
                .lastName("client2last")
                .userName("client2_username")
                .user(user)
                .build();
        clientRepository.save(client2);
    }

    private void createCountries() {
        countryRepository.save(new Country("Eesti"));
        countryRepository.save(new Country("Läti"));
        countryRepository.save(new Country("Leedu"));
    }
}
