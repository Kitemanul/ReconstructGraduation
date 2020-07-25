package Service.UserManagementService;

import Dao.User.UserMapper;
import POJO.User;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> SearchaUsers(User user) {
        return userMapper.getUsers(user);
    }

    @Override
    public int UpdateUser(User user,String username) {

        return userMapper.UpdateUser(user,username);
    }

    @Override
    public int DeleteUser(String username) {

        return userMapper.DeleteUserbyUsername(username);
    }

    @Override
    public int InsertUser(User user) {

       return userMapper.InsertUser(user);

    }
}
