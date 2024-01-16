package jon.max.service;

import jon.max.domain.User;

import java.util.List;

public interface IUserService {
     List<User> queryUserByName(String name);

     User login(String user,String password);

     List<User> queryUsers(User user);
}
