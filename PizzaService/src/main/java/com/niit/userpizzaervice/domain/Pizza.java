package com.niit.userpizzaervice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Pizza {
    @Id
    private int pizzaId;
    private String pizzaName;
    private String pizzaSize;
    private double prize;
    private int items;


}