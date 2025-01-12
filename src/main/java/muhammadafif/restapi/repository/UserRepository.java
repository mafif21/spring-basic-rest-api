package muhammadafif.restapi.repository;

import muhammadafif.restapi.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
