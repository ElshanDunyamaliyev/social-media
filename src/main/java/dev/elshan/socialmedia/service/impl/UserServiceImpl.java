package dev.elshan.socialmedia.service.impl;

import dev.elshan.socialmedia.model.User;
import dev.elshan.socialmedia.repository.UserRepository;
import dev.elshan.socialmedia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;


    @Override
    public User getUserById(Long userId) {
        return repository.findById(userId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"No user found with this id"));
    }

    @Override
    public void addUser(User user) {
        repository.save(user);
    }

    @Override
    public void updateUser(Long userId, User user) {
        var foundedUser = getUserById(userId);
        foundedUser.setAbout(user.getAbout());
        foundedUser.setProfilePicture(user.getProfilePicture());
        foundedUser.setUsername(user.getUsername());
        repository.save(foundedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }
}
