package com.niit.userauthenticationservice.security;



import com.niit.userauthenticationservice.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);//token and message -> the return type can be String also
}
