package com.wtbu.springbootsunshineairlines.Dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserDao {

    List<HashMap<String, Object>> userlist(HashMap<String, Object> map);

    List<HashMap<String, Object>> getEmail(HashMap<String, Object> map);

    List<HashMap<String, Object>> getEmailandPassword(HashMap<String, Object> map);

    void addUser(HashMap<String, Object> users);

    List<HashMap<String, Object>> getUserByUserId(HashMap<String, Object> users);

    List<HashMap<String, Object>> getEmailByUserId(HashMap<String, Object> users);

    void updateUser(HashMap<String, Object> users);

    List<HashMap<String, Object>> getUserInfo(int userId);
}
