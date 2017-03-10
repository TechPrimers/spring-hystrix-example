package com.techprimers.hystrix.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.techprimers.hystrix.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    RestTemplate restTemplate = new RestTemplate();
    @Value("${client.url}")
    private String url;

    @HystrixCommand(groupKey = "fallback",
            commandKey = "fallback",
    fallbackMethod = "hystrixFallBack")
    @GetMapping(value = "/hystrix")
    public List<Users> hystrix() {
        return restTemplate.getForObject(url, List.class);
    }

    @GetMapping(value = "")
    public List<Users> general() {
        return restTemplate.getForObject(url, List.class);
    }

    public List<Users> hystrixFallBack() {
        return Collections.emptyList();
    }


}
