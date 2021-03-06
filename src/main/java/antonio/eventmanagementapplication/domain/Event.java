package antonio.eventmanagementapplication.domain;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String date;
    private String location;

    @ManyToMany
private Set<User> users= new HashSet<>();

    @ManyToMany
    private Set<Meeting>meetings = new HashSet<>();



}
