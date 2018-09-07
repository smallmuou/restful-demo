package xyz.smallmuou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.smallmuou.dao.UserMapper;
import xyz.smallmuou.entity.User;

import java.util.List;

/**
 * Created by smou on 7/9/2018.
 */
@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id) {
       return userMapper.getUserById(id);
    }

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public int add(User user) {
        return userMapper.add(user);
    }

    public int update(Integer id, User user) {
        return userMapper.update(id, user);
    }

    public int delete(Integer id) {
        return userMapper.delete(id);
    }

}
