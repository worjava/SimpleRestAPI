package com.sterhov.rest.service;

import com.sterhov.rest.models.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommunicationImpl implements Communication {
private  RestTemplate restTemplate ;
private final  String URL ="http://localhost:8080/user/50";


    public CommunicationImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> showAllUsers() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<User>>() {
                        });
   return responseEntity.getBody(); }

    public User getUser(int id) {
            User user = restTemplate.getForObject(URL +"/"+ id, User.class);
        return user;
    }

    public void saveUser(User user) {
if(user.getId() ==0){
    ResponseEntity<String> response =
            restTemplate.postForEntity(URL,user, String.class);
    System.out.println("User is add BD");
    System.out.println(response.getBody());
}
else {
    restTemplate.put(URL,user);
    System.out.println("User update is ID " + user.getId());
}

    }

    public void deleteUser(int id) {
restTemplate.delete(URL+"/"+id);
        System.out.println("DELETE");
    }
}
