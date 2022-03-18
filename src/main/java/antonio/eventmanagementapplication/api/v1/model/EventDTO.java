package antonio.eventmanagementapplication.api.v1.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    @ApiModelProperty(required = true)
    private String name;

    @ApiModelProperty(required = true)
    private String description;

    @JsonProperty("event_url")
    private String eventUrl;

    @ApiModelProperty(required = true)
    private String date;

    private String location;

    private Set<UserDTO> users=new HashSet<>();

}
