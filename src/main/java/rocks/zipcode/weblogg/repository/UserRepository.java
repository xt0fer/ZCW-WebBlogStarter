package rocks.zipcode.weblogg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rocks.zipcode.weblogg.model.User;

@Repository
@Transactional // do you  need this for mysql??
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
    User findByUsername(String username);
}