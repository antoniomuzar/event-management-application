package antonio.eventmanagementapplication.api.services;

import antonio.eventmanagementapplication.api.v1.mapper.UserMapper;
import antonio.eventmanagementapplication.api.v1.model.UserDTO;
import antonio.eventmanagementapplication.domain.User;
import antonio.eventmanagementapplication.repositories.UserRepository;
import antonio.eventmanagementapplication.services.UserService;
import antonio.eventmanagementapplication.services.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


public class UserServiceImplIT {

    @Mock
    UserRepository userRepository;

    UserMapper userMapper= UserMapper.INSTANCE;

    UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        userService = new UserServiceImpl(userMapper, userRepository);
    }

    @Test
    public void getAllUsers() throws Exception {

        User user1 = new User();
        user1.setId(1l);
        user1.setFirstName("Alex");
        user1.setLastName("Winatz");

        User user2 = new User();
        user2.setId(2l);
        user2.setFirstName("Mickaela");
        user2.setLastName("Schiff");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));


        List<UserDTO> userDTOS = userService.getAllUsers();


        assertEquals(2, userDTOS.size());

    }
    @Test
    public void getUserById() throws Exception {


        User user1 = new User();
        user1.setId(1l);
        user1.setFirstName("Ivan");
        user1.setLastName("Horvat");

        when(userRepository.findById(anyLong())).thenReturn(Optional.ofNullable(user1));


        UserDTO userDTO = userService.getUserById(1L);

        assertEquals("Ivan", userDTO.getFirstName());
    }
    
    @Test
    public void createNewUser() throws Exception {


        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Bob");


        User savedUser = new User();
        savedUser.setFirstName(userDTO.getFirstName());
        savedUser.setLastName(userDTO.getLastName());
        savedUser.setId(1l);

        when(userRepository.save(any(User.class))).thenReturn(savedUser);


        UserDTO savedDto = userService.createNewUser(userDTO);


        Assert.assertEquals(userDTO.getFirstName(), savedDto.getFirstName());
        Assert.assertEquals("/api/v1/users/1", savedDto.getUserUrl());
    }

    @Test
    public void saveUserByDTO() throws Exception {


        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Marko");

        User savedUser = new User();
        savedUser.setFirstName(userDTO.getFirstName());
        savedUser.setLastName(userDTO.getLastName());
        savedUser.setId(1L);

        when(userRepository.save(any(User.class))).thenReturn(savedUser);


        UserDTO savedDto = userService.saveUserByDTO(1L, userDTO);


        assertEquals(userDTO.getFirstName(), savedDto.getFirstName());
        assertEquals("/api/v1/users/1", savedDto.getUserUrl());
    }

    @Test
    public void deleteUserById() throws Exception {

        Long id = 1L;

        userRepository.deleteById(id);

        verify(userRepository, times(1)).deleteById(anyLong());
    }
}
