package edu.cursor.restandjackson.services;

import edu.cursor.restandjackson.models.User;
import org.springframework.http.HttpStatus;

import java.util.Map;

public interface IUserService {
    Map<String,Boolean> setHomework (User user);
    User userInfo(String email);
    HttpStatus writeUserInfo(User user);
}
