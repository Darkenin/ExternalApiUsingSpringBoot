package com.raph.krishna.service;

import com.raph.krishna.data.PostOffice;
import com.raph.krishna.data.PostOfficeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public PostOfficeResponse fetchPostOfficeByCity(String city) {
        String url = "https://api.postalpincode.in/postoffice/{city}";
        url = url.replace("{city}", city );
        System.out.println("url path is "+url);
        ResponseEntity<PostOfficeResponse[]> responseEntity = restTemplate.getForEntity(url, PostOfficeResponse[].class);
        System.out.println("Response status is : "+ responseEntity.getStatusCode());
        PostOfficeResponse[] postOfficeResponse=  responseEntity.getBody();
        for(PostOfficeResponse postOfficeResponse1: postOfficeResponse){
         List<PostOffice> postOffices = postOfficeResponse1.getPostOffice();
         for (PostOffice post : postOffices){
             System.out.println(post.getName() + "**** "+post.getPinCode());
         }
        }
        return postOfficeResponse[0];
    }
}
