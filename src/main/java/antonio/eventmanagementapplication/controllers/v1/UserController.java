package antonio.eventmanagementapplication.controllers.v1;
import antonio.eventmanagementapplication.api.v1.model.UserDTO;
import antonio.eventmanagementapplication.api.v1.model.UserListDTO;
import antonio.eventmanagementapplication.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value="List of Users")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO getListOfUsers(){
        return new UserListDTO(userService.getAllUsers());
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createNewUser(@RequestBody UserDTO userDTO){
        return userService.createNewUser(userDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.saveUserByDTO(id, userDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO patchUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.patchUser(id, userDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}