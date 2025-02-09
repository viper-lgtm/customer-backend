package cz.martinvedra.backend.impl.repo;

import cz.martinvedra.backend.impl.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for {@link CustomerEntity}
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("select c from CustomerEntity c where lower(c.email) like lower(concat('%', :email, '%'))")
    List<CustomerEntity> findByEmailContaining(String email);

    Optional<CustomerEntity> findByUsername(String username);
}
