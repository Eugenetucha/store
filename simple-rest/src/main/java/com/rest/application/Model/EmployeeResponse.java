package com.rest.application.Model;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeResponse {
    Long id;
    String name;
    String lastname;
    String patronymic;
    Date birthdate;

}
