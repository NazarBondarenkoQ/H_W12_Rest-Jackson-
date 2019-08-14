package edu.cursor.restandjackson.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cursor.restandjackson.models.User;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
@Service
public class UserService implements IUserService {
    private static final String FILE_PATH = "target/info.json";
    private User user1 = User.builder().name("Andy")
            .surname("Larkin")
            .lastLoginDate(LocalDate.of(2019, 11, 25))
            .accessId(12345)
            .email("example@gmail.com")
            .build();

    private User user2 = User.builder().name("Rick")
            .surname("Sanchez")
            .lastLoginDate(LocalDate.of(2019, 10, 22))
            .accessId(10123)
            .email("testemail@gmail.com")
            .build();

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
    public HttpStatus writeUserInfo(User user) {
        user = user2;
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(FILE_PATH), user);
            return HttpStatus.CREATED;
        } catch (IOException e) {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
