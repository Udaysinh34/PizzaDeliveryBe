package com.niit.userpizzaervice.proxy;

import com.niit.userpizzaervice.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-authentication-service",url = "localhost:8086")
public interface UserProxy {

    @PostMapping("/user")
    ResponseEntity<?> proxyUser(@RequestBody User user);
}
