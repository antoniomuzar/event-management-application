package antonio.eventmanagementapplication.api.v1.mapper;

import antonio.eventmanagementapplication.api.v1.model.UserDTO;
import antonio.eventmanagementapplication.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDtoToUser(UserDTO userDTO);

}
