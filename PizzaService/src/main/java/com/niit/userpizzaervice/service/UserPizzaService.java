package com.niit.userpizzaervice.service;

import com.niit.userpizzaervice.domain.Pizza;
import com.niit.userpizzaervice.domain.User;
import com.niit.userpizzaervice.exception.PizzaAlreadyExistsException;
import com.niit.userpizzaervice.exception.PizzaNotFoundException;
import com.niit.userpizzaervice.exception.UserAlreadyExistsException;

import java.util.List;

public interface UserPizzaService {

    Pizza savePizzaDetails(Pizza pizza) throws PizzaAlreadyExistsException;

    boolean addToCart(String currentEmail,int pizzaId);

    List<Pizza> getAllPizza() throws PizzaNotFoundException;
    User registerUser(User user) throws UserAlreadyExistsException;


}
