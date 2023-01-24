package com.raph.krishna.controller;

import com.raph.krishna.data.UserDetails;
import com.raph.krishna.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/u")
public class UserController {

    @Autowired
    UserServiceImpl userService;
//    @RequestMapping(value = "/b", method = RequestMethod.GET,
//            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/b")
    public UserDetails[]  queryParam(@RequestParam String userId){
        System.out.println("Start of query for user for id : "+ userId);
       UserDetails[] userDetails = userService.queryUserId(userId);
        System.out.println("Size is " + userDetails.length);
        System.out.println("End of query");
        return userDetails;
    }
}
