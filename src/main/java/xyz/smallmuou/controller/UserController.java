package xyz.smallmuou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.smallmuou.entity.ResponseResult;
import xyz.smallmuou.entity.User;
import xyz.smallmuou.service.UserService;

import java.util.List;

/**
 * Created by smou on 7/9/2018.
 */
@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseResult> getUserById(@PathVariable(value = "id") Integer id) {
        ResponseResult result = new ResponseResult();

        try {
            User user = userService.getUserById(id);
            if (user != null) {
                result.setStatus(200);
                result.setResult(user);
            } else {
                result.setStatus(404);
                result.setResult("no found");
            }
        } catch (Exception e) {
            result.setStatus(400);
            result.setResult(e.getClass().getName() + ":" + e.getMessage());
        }

        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseResult> getUserList() {
        ResponseResult result = new ResponseResult();

        try {
            List<User> list = userService.getUserList();
            result.setStatus(200);
            result.setResult(list);
        } catch (Exception e) {
            result.setStatus(400);
            result.setResult(e.getClass().getName() + ":" + e.getMessage());
        }

        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseResult> add(@RequestBody User user) {
        ResponseResult result = new ResponseResult();

        try {
            int ret = userService.add(user);
            if (ret < 0) {
                result.setStatus(400);
                result.setResult("add fail");
            } else {
                result.setStatus(200);
                result.setResult(ret);
            }
        } catch (Exception e) {
            result.setStatus(400);
            result.setResult(e.getClass().getName() + ":" + e.getMessage());
        }

        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseResult> update(@PathVariable("id") Integer id, @RequestBody User user) {
        ResponseResult result = new ResponseResult();

        try {
            int ret = userService.update(id, user);
            if (ret < 0) {
                result.setStatus(400);
                result.setResult("update fail");
            } else {
                result.setStatus(200);
                result.setResult(ret);
            }
        } catch (Exception e) {
            result.setStatus(400);
            result.setResult(e.getClass().getName() + ":" + e.getMessage());
        }

        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseResult> update(@PathVariable("id") Integer id) {
        ResponseResult result = new ResponseResult();

        try {
            int ret = userService.delete(id);
            if (ret < 0) {
                result.setStatus(400);
                result.setResult("update fail");
            } else {
                result.setStatus(200);
                result.setResult(ret);
            }
        } catch (Exception e) {
            result.setStatus(400);
            result.setResult(e.getClass().getName() + ":" + e.getMessage());
        }

        return ResponseEntity.ok(result);
    }

}
