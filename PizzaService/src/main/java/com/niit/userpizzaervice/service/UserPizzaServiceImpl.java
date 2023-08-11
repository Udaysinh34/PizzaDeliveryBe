package com.niit.userpizzaervice.service;


import com.niit.userpizzaervice.domain.Pizza;
import com.niit.userpizzaervice.domain.User;
import com.niit.userpizzaervice.exception.PizzaAlreadyExistsException;
import com.niit.userpizzaervice.exception.PizzaNotFoundException;
import com.niit.userpizzaervice.exception.UserAlreadyExistsException;
import com.niit.userpizzaervice.proxy.UserProxy;
import com.niit.userpizzaervice.repository.UserPizzaRepository;
import com.niit.userpizzaervice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
@Service
public class UserPizzaServiceImpl implements UserPizzaService {
    private UserPizzaRepository userPizzaRepository;
    private UserRepository userRepository;
    private UserProxy proxy;

    @Autowired
    public UserPizzaServiceImpl(UserPizzaRepository userPizzaRepository,UserRepository userRepository, UserProxy proxy) {
        this.userPizzaRepository = userPizzaRepository;
        this.userRepository = userRepository;
        this.proxy = proxy;
    }


    @Override
    public Pizza savePizzaDetails(Pizza pizza) throws PizzaAlreadyExistsException {

        return userPizzaRepository.save(pizza);
    }

    @Override
    public boolean addToCart(String currentEmail,int pizzaId){
        User user = userRepository.findByEmail(currentEmail);
        List<Pizza> cartList = user.getCartList();
        List<Pizza> pizzaDetailsList = userPizzaRepository.findAll();
        Iterator<Pizza> iterator = pizzaDetailsList.listIterator();
        while (iterator.hasNext()) {
            Pizza i = iterator.next();
            if (i.getPizzaId() == pizzaId) {
                cartList.add(i);

                user.setCartList(cartList);
                userRepository.save(user);
                return true;

            }

        }
        return false;
    }

    @Override
    public List<Pizza> getAllPizza() throws PizzaNotFoundException {
        List<Pizza> pizzaDetailsList = userPizzaRepository.findAll();
        return pizzaDetailsList;
    }
    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        proxy.proxyUser(user);
        return userRepository.save(user);
    }
}
