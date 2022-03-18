package antonio.eventmanagementapplication.domain;

import antonio.eventmanagementapplication.api.v1.model.EventDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String company;
    private String userEmail;
    private String userUrl;


}
