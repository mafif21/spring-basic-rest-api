package muhammadafif.restapi.repository;

import muhammadafif.restapi.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findFirstByToken(String token);
}
