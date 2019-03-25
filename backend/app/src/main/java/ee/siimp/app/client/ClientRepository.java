package ee.siimp.app.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ClientRepository extends JpaRepository<Client, Long> {

    <T> Collection<T> findAllBy(Class<T> type);
}
