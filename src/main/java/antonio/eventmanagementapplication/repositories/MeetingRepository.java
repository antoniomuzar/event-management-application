package antonio.eventmanagementapplication.repositories;

import antonio.eventmanagementapplication.domain.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
