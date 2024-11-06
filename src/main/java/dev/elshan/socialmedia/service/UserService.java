package dev.elshan.socialmedia.service;

import dev.elshan.socialmedia.dto.request.UserCreateRequest;
import dev.elshan.socialmedia.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long userId);
    List<User> getAllUsers();
    void addUser(UserCreateRequest request);
    void updateUser(Long userId,User user);
    void deleteUser(Long userId);
}
