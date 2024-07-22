package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private int id;
    private String name;
    private String LastName;
    private String phone;
    private int age;
    private String country;
}
