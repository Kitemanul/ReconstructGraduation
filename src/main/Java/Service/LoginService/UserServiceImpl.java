package Service.LoginService;


import Dao.User.UserMapper;
import POJO.User;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


import java.sql.Connection;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User LoginUser(String username) {

        return userMapper.getUserbyName(username);
    }


}
