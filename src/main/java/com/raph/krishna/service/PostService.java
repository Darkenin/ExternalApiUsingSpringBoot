package com.raph.krishna.service;

import com.raph.krishna.data.PostOffice;
import com.raph.krishna.data.PostOfficeResponse;
import org.springframework.stereotype.Service;


public interface PostService {
    public PostOfficeResponse fetchPostOfficeByCity(String city);
}
