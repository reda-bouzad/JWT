package maroc.reda.jwt.controller;

import jakarta.annotation.PostConstruct;
import maroc.reda.jwt.entity.User;
import maroc.reda.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRolesAndUsers() {
        userService.initRolesAndUser();
    }

    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping("/forAdmin")
    public String forAdmin() {
        return "this url is only accessible to admin";
    }

    @GetMapping("/forUser")
    public String forUser(){
        return "this url is only accessible to user";
    }


}
