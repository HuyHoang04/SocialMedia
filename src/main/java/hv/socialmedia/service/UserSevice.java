package hv.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hv.socialmedia.dto.request.UserCreateDTO;
import hv.socialmedia.dto.request.UserUpdateDTO;
import hv.socialmedia.dto.response.UserResponseDTO;
import hv.socialmedia.entity.User;
import hv.socialmedia.mapper.UserMapper;
import hv.socialmedia.repository.UserRepository;

@Service
public class UserSevice {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO createUser(UserCreateDTO request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        User user = userMapper.toUser(request);  
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public UserResponseDTO updateUser(Long id, UserUpdateDTO request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user, request);
        User updateUser = userRepository.save(user);
        return userMapper.toUserResponse(updateUser);
    }
}
