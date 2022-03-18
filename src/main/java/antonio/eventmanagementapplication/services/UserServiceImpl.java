package antonio.eventmanagementapplication.services;

import antonio.eventmanagementapplication.api.v1.mapper.UserMapper;
import antonio.eventmanagementapplication.api.v1.model.UserDTO;
import antonio.eventmanagementapplication.controllers.v1.UserController;
import antonio.eventmanagementapplication.domain.User;
import antonio.eventmanagementapplication.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;


    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(user ->{
                    UserDTO userDTO = userMapper.userToUserDTO(user);
                    userDTO.setUserUrl(getUserUrl(user.getId()));
                    return userDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::userToUserDTO)
                .map(userDTO -> {
                    userDTO.setUserUrl(getUserUrl(id));
                    return userDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        return saveAndReturnDTO(userMapper.userDtoToUser(userDTO));
    }

    private UserDTO saveAndReturnDTO(User user){
        User savedUser=userRepository.save(user);

        UserDTO returnDto= userMapper.userToUserDTO(savedUser);

        returnDto.setUserUrl(getUserUrl(savedUser.getId()));

        return returnDto;
    }


    @Override
    public UserDTO saveUserByDTO(Long id, UserDTO userDTO) {

        User user = userMapper.userDtoToUser(userDTO);
        user.setId(id);

        return saveAndReturnDTO(user);
    }

    @Override
    public UserDTO patchUser(Long id, UserDTO userDTO) {
        return userRepository.findById(id).map(user -> {

            if(userDTO.getFirstName() != null){
                user.setFirstName(userDTO.getFirstName());
            }

            if(userDTO.getLastName() != null){
                user.setLastName(userDTO.getLastName());
            }

            UserDTO returnDto = userMapper.userToUserDTO(userRepository.save(user));

            returnDto.setUserUrl(getUserUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
    }


    private String getUserUrl(Long id){
        return UserController.BASE_URL + "/" + id;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);

    }
}
