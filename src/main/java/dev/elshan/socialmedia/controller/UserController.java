package dev.elshan.socialmedia.controller;

import dev.elshan.socialmedia.dto.request.UserCreateRequest;
import dev.elshan.socialmedia.model.User;
import dev.elshan.socialmedia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody UserCreateRequest request){
        service.addUser(request);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,@RequestBody User user){
        service.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
}
