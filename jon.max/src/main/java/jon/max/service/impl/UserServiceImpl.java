package jon.max.service.impl;

import jon.max.domain.User;
import jon.max.mapper.UserMapper;
import jon.max.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserMapper userMapper;

    @Override
    public List<User> queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public List<User> queryUsers(User user) {
        return userMapper.queryUsers(user);
    }

    @Override
    public User login(String user, String password) {
        return userMapper.login(user, password);
    }
}
