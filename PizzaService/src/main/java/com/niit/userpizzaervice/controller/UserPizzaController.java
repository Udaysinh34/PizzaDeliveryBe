package com.niit.userpizzaervice.controller;

import com.niit.userpizzaervice.domain.Pizza;
import com.niit.userpizzaervice.domain.User;
import com.niit.userpizzaervice.exception.PizzaAlreadyExistsException;
import com.niit.userpizzaervice.exception.PizzaNotFoundException;
import com.niit.userpizzaervice.exception.UserAlreadyExistsException;
import com.niit.userpizzaervice.service.UserPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
//@RequestMapping("api/v2")
@CrossOrigin(origins = "http://localhost:4200")
public class UserPizzaController {

    @Autowired
    private UserPizzaService userPizzaService;

    private ResponseEntity<?> responseEntity;

    String email;

    @Autowired
    public UserPizzaController(UserPizzaService userPizzaService ) {
        this.userPizzaService = userPizzaService;

    }

    @PostMapping("/save")
    public ResponseEntity<?> savePizza(@RequestBody Pizza pizza) throws PizzaAlreadyExistsException
    {
        try{
            responseEntity=new ResponseEntity<>(userPizzaService.savePizzaDetails(pizza), HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity=new ResponseEntity<>("Try again later",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/add-to-cart/{email}/{pizzaId}")
    public ResponseEntity<?> addPizzaToCart(@PathVariable String email, @PathVariable int pizzaId)

    {

        try{
            responseEntity=new ResponseEntity<>(userPizzaService.addToCart(email,pizzaId), HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity=new ResponseEntity<>("Try again later",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }



    @GetMapping("/getPizza")
    public ResponseEntity<?> getPizza() throws PizzaNotFoundException
    {
        try{
            responseEntity=new ResponseEntity<>(userPizzaService.getAllPizza(), HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity=new ResponseEntity<>("Try again later",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
    try {
        user.setCartList(new ArrayList<Pizza>());
        responseEntity =  new ResponseEntity<>(userPizzaService.registerUser(user), HttpStatus.CREATED);
    }
    catch(UserAlreadyExistsException e)
    {
        throw new UserAlreadyExistsException();
    }
    return responseEntity;
    }

}

