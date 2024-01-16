package jon.max.mapper;

import jon.max.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryUserByName(String name);

    User login(String user,String password);

    List<User> queryUsers(User user);
}
