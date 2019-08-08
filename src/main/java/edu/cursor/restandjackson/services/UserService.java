package edu.cursor.restandjackson.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Data
@Service
public class UserService implements IUserService {
    private static final String FILE_PATH = "target/info.json";
    private User user1 = new User("Andy", "Larkin", LocalDate.of(2019, 11, 25),
            12345, "example@gmail.com");
    private User user2 = new User("Rick", "Sanches", LocalDate.of(2019, 10, 22),
            10123, "testemail@gmail.com,");
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, Boolean> setHomework(User user) {
        Map<String, Boolean> homework = new HashMap<>();
        homework.put("Interfaces", Boolean.TRUE);
        homework.put("Lambdas and Streams", Boolean.TRUE);
        homework.put("Arrays", Boolean.TRUE);
        user.setHomework(homework);
        return user.getHomework();
    }

    @Override
    public User userInfo(String email) {
        if (user1.getEmail().equals(email)) {
            return user1;
        } else if (user2.getEmail().equals(email)) {
            return user2;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public HttpStatus writeUserInfo(String name, String surname, String email) {
        if (name.equals(user1.getName()) &&
                surname.equals(user1.getSurname()) &&
                email.equals(user1.getEmail())) {
            user1.setAccessId(new Random().nextInt(1000) + 1);
            try {
                objectMapper.writeValue(new FileOutputStream(FILE_PATH), user1);
                return HttpStatus.OK;
            } catch (NotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        } else if (name.equals(user2.getName()) &&
                surname.equals(user2.getSurname()) &&
                email.equals(user2.getEmail())) {
            user2.setAccessId(new Random().nextInt(1000) + 1);
            try {
                objectMapper.writeValue(new FileOutputStream(FILE_PATH), user2);
                return HttpStatus.OK;
            } catch (NotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new NotFoundException();
        }
        return HttpStatus.NOT_FOUND;
    }
}
