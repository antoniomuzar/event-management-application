package antonio.eventmanagementapplication.domain;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String time;

    @OneToMany
    private Set<User> meetingAtendee=new HashSet<>();
}
