package com.niit.userpizzaervice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Document
public class User {
    @Id
    private String email;
    private String userName;
    private String password;
    private String phoneNumber;
    private List<Pizza> cartList;

}
