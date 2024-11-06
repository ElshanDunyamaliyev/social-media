package dev.elshan.socialmedia.service.impl;

import dev.elshan.socialmedia.dto.request.UserCreateRequest;
import dev.elshan.socialmedia.model.User;
import dev.elshan.socialmedia.repository.UserRepository;
import dev.elshan.socialmedia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
//    @Transactional
    public User getUserById(Long userId) {
        var user = repository.findById(userId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"No user found with this id"));
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void addUser(UserCreateRequest request) {
        var user = User
                .builder()
                .username(request.getUsername())
                .about(request.getAbout())
                .profilePicture(request.getProfilePicture())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
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
