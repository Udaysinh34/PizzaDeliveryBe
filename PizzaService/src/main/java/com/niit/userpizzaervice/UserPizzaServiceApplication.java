package com.niit.userpizzaervice;


import com.niit.userpizzaervice.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class UserPizzaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserPizzaServiceApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean jwtFilter()
//	{
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new JwtFilter());
//		filterRegistrationBean.addUrlPatterns("/user/*");
//		return filterRegistrationBean;
//
//	}

}
