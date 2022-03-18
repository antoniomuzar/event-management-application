package antonio.eventmanagementapplication.api.v1.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @ApiModelProperty(required = true)
    private String firstName;

    @ApiModelProperty(required = true)
    private String lastName;

    @ApiModelProperty(required = true)
    private String company;

    @ApiModelProperty(required = true)
    private String userEmail;

    @JsonProperty("user_url")
    private String userUrl;

}
