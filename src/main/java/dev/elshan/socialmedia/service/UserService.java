package dev.elshan.socialmedia.service;

import dev.elshan.socialmedia.model.User;

public interface UserService {
    User getUserById(Long userId);
    void addUser(User user );
    void updateUser(Long userId,User user);
    void deleteUser(Long userId);
}
