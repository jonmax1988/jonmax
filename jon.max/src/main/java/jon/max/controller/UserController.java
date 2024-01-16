package jon.max.controller;

import com.alibaba.fastjson2.JSON;
import jon.max.domain.User;
import jon.max.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/jonmax")
@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/queryUserByName/{name}")
    public List<User> queryUserByName(@PathVariable("name") String name) {
        List<User> users = userService.queryUserByName(name);
        return users;
    }

    @GetMapping("/login")
    Map<String, Object> login(@RequestParam("user") String user, @RequestParam("password") String password) {
        User loginResult = userService.login(user, password);
        Map<String, Object> result = new HashMap<>();
        if (Objects.isNull(loginResult)) {
            result.put("code", "00000");
            result.put("data", "登录失败！用户名或密码错误！");
        } else {
            result.put("code", "00001");
            result.put("data", loginResult);
        }
        return result;
    }

    @PostMapping("/queryUsers")
    public List<User> queryUsers(@RequestBody User user) {
        List<User> users = userService.queryUsers(user);
        return users;
    }
}
