package ee.siimp.app.country;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CountryRepository extends JpaRepository<Country, Long> {

    <T> Collection<T> findAllBy(Class<T> type);

}
