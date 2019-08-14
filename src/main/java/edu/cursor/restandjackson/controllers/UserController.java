package edu.cursor.restandjackson.controllers;

import edu.cursor.restandjackson.models.User;
import edu.cursor.restandjackson.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService = new UserService();

    @ResponseBody
    @GetMapping(value = "/user")
    public User showInfo() {
        userService.setHomework(userService.getUser1());
        return userService.userInfo("example@gmail.com");
    }

    @ResponseBody
    @PostMapping(value = "/write")
    public HttpStatus writeUserInfo(@RequestBody User user) {
        return userService.writeUserInfo(user);
    }
}
