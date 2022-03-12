package com.wtbu.springbootsunshineairlines.Service;

import com.wtbu.springbootsunshineairlines.pojo.Result;

import java.util.HashMap;

public interface UserService {

    Result userlist(HashMap<String, Object> map);

    Result getEmailandPassword(HashMap<String, Object> map);

    Result addUser(HashMap<String, Object> users);

    Result updateUser(HashMap<String, Object> users);

    Result getUserInfo(int userId);
}
