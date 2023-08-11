package com.niit.userauthenticationservice.repository;


import com.niit.userauthenticationservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
User findByEmailAndPassword(String email, String password);
}
