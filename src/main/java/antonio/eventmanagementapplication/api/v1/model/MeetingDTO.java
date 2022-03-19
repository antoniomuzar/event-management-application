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
public class MeetingDTO {

    @ApiModelProperty(required = true)
    private String name;

    @ApiModelProperty(required = true)
    private String description;

    @JsonProperty("meeting_url")
    private String meetingUrl;

   private String time;

    private Set<UserDTO> meetingAtendee=new HashSet<>();



}
