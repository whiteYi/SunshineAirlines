package com.wtbu.springbootsunshineairlines.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.wtbu.springbootsunshineairlines.Dao.UserDao;
import com.wtbu.springbootsunshineairlines.Service.UserService;
import com.wtbu.springbootsunshineairlines.pojo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Result userlist(HashMap<String, Object> map) {
        Result result = new Result("fail", null);
        List<HashMap<String, Object>> list = userDao.userlist(map);
        if (list != null && list.size() > 0) {
            result.setFlag("success");
            result.setData(list);
        }

        return result;
    }

    @Override
    public Result getEmailandPassword(HashMap<String, Object> map) {
        Result result = new Result("fail", null);

        List<HashMap<String, Object>> one = userDao.getEmail(map);

        if (one!= null && one.size() > 0) {
            List<HashMap<String, Object>> list = userDao.getEmailandPassword(map);
            if (list != null && list.size() > 0) {
                result.setFlag("success");
                result.setData(list);
            }
            else {
                result.setData("密码错误");
            }
        }
        else {
            result.setData("邮箱不存在");
        }

        return result;
    }

    @Override
    public Result addUser(HashMap<String, Object> users) {
        Result result = new Result("fail", null);
        List<HashMap<String, Object>> one = userDao.getEmail(users);

        if (one!= null && one.size() > 0) {
            result.setData("邮箱重复");
        }
        else {
            userDao.addUser(users);
            result.setFlag("seccess");
        }

        return result;
    }

    @Override
    public Result updateUser(HashMap<String, Object> users) {
        Result result = new Result("fail", null);

        List<HashMap<String, Object>> a = userDao.getUserByUserId(users);
        if (a!= null && a.size() > 0) {
            List<HashMap<String, Object>> one = userDao.getEmailByUserId(users);
            if (one!= null && one.size() > 0) {
                result.setData("邮箱重复");
            }
            else {
                userDao.updateUser(users);
                result.setFlag("seccess");
            }
        }
        else {
            result.setData("用户信息不存在");
        }
        return result;
    }

    @Override
    public Result getUserInfo(int userId) {
        Result result = new Result("fail", null);
        List<HashMap<String, Object>> list = userDao.getUserInfo(userId);
        if (list!= null && list.size() > 0) {
            result.setFlag("seccess");
            result.setData(list);
        }
        else{
            result.setData("用户信息不存在");
        }

        return result;
    }

}
