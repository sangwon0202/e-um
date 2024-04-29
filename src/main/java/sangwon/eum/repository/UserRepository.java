package sangwon.eum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sangwon.eum.repository.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
