package ee.siimp.app.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    <T> Collection<T> findAllByUserId(Long userId, Class<T> type);

    Optional<Client> findByIdAndUserId(Long id, Long userId);

}
