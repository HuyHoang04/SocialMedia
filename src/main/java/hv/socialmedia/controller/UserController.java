package hv.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import hv.socialmedia.SocialmediaApplication;
import hv.socialmedia.dto.request.UserCreateDTO;
import hv.socialmedia.dto.request.UserUpdateDTO;
import hv.socialmedia.dto.response.UserResponseDTO;
import hv.socialmedia.service.UserSevice;

@RestController
@RequestMapping("/users")
public class UserController {
    private final SocialmediaApplication socialmediaApplication;

    @Autowired
    private UserSevice userService;

    UserController(SocialmediaApplication socialmediaApplication) {
        this.socialmediaApplication = socialmediaApplication;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO request) {
        UserResponseDTO response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO request) {
        UserResponseDTO response = userService.updateUser(id, request);
        return ResponseEntity.ok(response);
    }
}
