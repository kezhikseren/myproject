package com.myproject.myproject.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonDTO {
    String last_name;
    String first_name;
    int age;
}
