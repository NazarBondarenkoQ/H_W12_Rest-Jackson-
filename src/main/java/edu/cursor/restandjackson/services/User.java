package edu.cursor.restandjackson.services;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
class User {
    private String name;
    private String surname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastLoginDate;
    @JsonIgnore
    private int accessId;
    private String email;
    private Map<String, Boolean> homework;

    User(String name, String surname, LocalDate lastLoginDate, int accessId, String email) {
        this.name = name;
        this.surname = surname;
        this.lastLoginDate = lastLoginDate;
        this.accessId = accessId;
        this.email = email;
    }
}
