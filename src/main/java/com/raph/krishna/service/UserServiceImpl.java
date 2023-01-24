package com.raph.krishna.service;

import com.raph.krishna.data.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;
    @Override
    public UserDetails[] queryUserId(String userId) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        UriComponentsBuilder builder =UriComponentsBuilder.fromHttpUrl(url);
        builder.queryParam("userId", userId).build();
        ResponseEntity<UserDetails[]> userDetailsRes = restTemplate.getForEntity(builder.toUriString(), UserDetails[].class);
        System.out.println("Status code is : "+ userDetailsRes.getStatusCode());
        System.out.println("ResponseBody is "+ userDetailsRes.getBody());

        UserDetails[] userDetails = userDetailsRes.getBody();
        System.out.println("End of queryForUser : "+userId);
        return userDetails;
    }
}
