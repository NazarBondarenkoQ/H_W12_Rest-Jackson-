package edu.cursor.restandjackson.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService = new UserService();

    @GetMapping(value = "/user")
    public User showInfo() {
        userService.setHomework(userService.getUser1());
        return userService.userInfo("example@gmail.com");
    }

    @GetMapping(value = "/write")
    public HttpStatus writeUserInfo() {
        return userService.writeUserInfo("Andy", "Larkin", "example@gmail.com");
    }
}
