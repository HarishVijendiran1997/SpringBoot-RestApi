package com.harish.app.rest.ApiController;

import com.harish.app.rest.Exceptions.UserNotFoundException;
import com.harish.app.rest.Models.User;
import com.harish.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Hello World";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping(value = "/users")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping(value = "/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userRepo.findById(id).map(existingUser -> {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setAge(user.getAge());
            existingUser.setOccupation(user.getOccupation());
            return userRepo.save(existingUser);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return userRepo.findById(id).map(user -> {
            userRepo.delete(user);
            return ResponseEntity.ok().body("User with ID" + id + "deleted successfully");
        }).orElseThrow(() -> new UserNotFoundException(id));
    }
}
