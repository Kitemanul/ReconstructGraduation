package Service.RegisterService;


import Dao.User.UserMapper;
import POJO.User;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;


@Service
public class RegisterServeceImpl implements RegisterService {

    @Autowired
    UserMapper userMapper;


    @Override
    public int Register(User user) {

        return userMapper.InsertUser(user);

    }




}
