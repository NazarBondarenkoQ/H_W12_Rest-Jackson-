package edu.cursor.restandjackson.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Builder
@Data
public class User {
    private String name;
    private String surname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastLoginDate;
    @JsonIgnore
    private int accessId;
    private String email;
    private Map<String, Boolean> homework;

}
