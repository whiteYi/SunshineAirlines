package com.wtbu.springbootsunshineairlines.Controller;


import com.wtbu.springbootsunshineairlines.Service.UserService;
import com.wtbu.springbootsunshineairlines.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/userList")
    public Object userlist(@RequestParam("name") String name, @RequestParam("roleId") int roleId, @RequestParam("startPage") int page, @RequestParam("pageSize") int pageSize){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("roleId", roleId);
        map.put("page", page*pageSize);
        map.put("pageSize", pageSize);
        Result result = userService.userlist(map);
        return result;
    };

    @RequestMapping("/login")
    public Object getEmailandPassword(@RequestParam("email") String email,@RequestParam("password") String password){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);
        map.put("password", password);
        Result result = userService.getEmailandPassword(map);
        return result;
    };

    @RequestMapping("/addUser")
    public Object addUser(@RequestParam("email") String email,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
                          @RequestParam("gender") String gender,@RequestParam("dateOfBirth") String dateOfBirth,@RequestParam("phone") String phone,
                          @RequestParam("photo") String photo,@RequestParam("address") String address,@RequestParam("roleId") int roleId){
        HashMap<String , Object> users = new HashMap<String , Object>();
        users.put("email",email);
        users.put("firstName",firstName);
        users.put("lastName",lastName);
        users.put("dateOfBirth",dateOfBirth);
        users.put("gender",gender);
        users.put("phone",phone);
        users.put("photo",photo);
        users.put("address",address);
        users.put("roleId",roleId);
        String password = email.substring(0,email.indexOf("@")).toString();
        if(password.length()>6) {
            password = password.substring(0,6);
            users.put("password", password);
        }else {
            users.put("password", password);
        }

        Result result = userService.addUser(users);
        return result;
    };



    @RequestMapping("/updateUser")
    public Object updateUser(@RequestParam("email") String email,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
                             @RequestParam("gender") String gender,@RequestParam("dateOfBirth") String dateOfBirth,@RequestParam("phone") String phone,
                             @RequestParam("photo") String photo,@RequestParam("address") String address,@RequestParam("roleId") int roleId,@RequestParam("userId") int userId){
        HashMap<String , Object> users = new HashMap<String , Object>();
        users.put("email",email);
        users.put("firstName",firstName);
        users.put("lastName",lastName);
        users.put("dateOfBirth",dateOfBirth);
        users.put("gender",gender);
        users.put("phone",phone);
        users.put("photo",photo);
        users.put("address",address);
        users.put("roleId",roleId);
        users.put("userId",userId);
        Result result = userService.updateUser(users);
        return result;
    };



    @RequestMapping("/getUserInfo")
    public Object getUserInfo(@RequestParam("userId") int userId){
        Result result = userService.getUserInfo(userId);
        return result;

    };
}
