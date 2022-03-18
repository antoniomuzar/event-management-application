package antonio.eventmanagementapplication.repositories;

import antonio.eventmanagementapplication.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
