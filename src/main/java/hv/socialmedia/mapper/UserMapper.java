package hv.socialmedia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import hv.socialmedia.dto.request.UserCreateDTO;
import hv.socialmedia.dto.request.UserUpdateDTO;
import hv.socialmedia.dto.response.UserResponseDTO;
import hv.socialmedia.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateDTO request);
    UserResponseDTO toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateDTO request);
}
