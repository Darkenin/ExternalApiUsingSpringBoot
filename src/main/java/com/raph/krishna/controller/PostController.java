package com.raph.krishna.controller;


import com.raph.krishna.data.PostOfficeResponse;
import com.raph.krishna.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostService postService;
//    @RequestMapping(value = "/b", method = RequestMethod.GET,
//            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/b")
    public PostOfficeResponse getPostalByCity(@RequestParam("city") String city){
        PostOfficeResponse postOffice;
          postOffice = postService.fetchPostOfficeByCity(city);
        return postOffice;
    }
}
