package com.akgs.interview.kristalai.usermanagement.service;

import com.akgs.interview.kristalai.usermanagement.model.User;
import com.akgs.interview.kristalai.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/user")
    public Iterable<User> getUsers(@RequestParam(name = "username", required = false) String username){
        List<User> users = new ArrayList<>();
        if(username == null)
            users.addAll((Collection<? extends User>) userRepository.findAll());
        else {
            User byUsername = userRepository.findByUsername(username);
            if (byUsername!=null)
                users.add(byUsername);
        }
        return users;
    }

    @PostMapping(path = "/user")
    public void addUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(name = "email") String email,
                        @RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname") String lastName,
                        @RequestParam(name = "dob") Date dob){
        userRepository.save(new User(username, password, email, firstName, lastName, dob));
    }
}
