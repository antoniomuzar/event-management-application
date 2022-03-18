package antonio.eventmanagementapplication.repositories;

import antonio.eventmanagementapplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
