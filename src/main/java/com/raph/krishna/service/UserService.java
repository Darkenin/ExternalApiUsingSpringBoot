package com.raph.krishna.service;

import com.raph.krishna.data.UserDetails;

public interface UserService {
    public UserDetails[] queryUserId(String userId);
}
