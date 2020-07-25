package Service.UserManagementService;


import Dao.User.UserMapper;
import POJO.User;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CheckRegisterServiceImpl implements CheckRegisterService
{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUnRegisterUser(User user) {
        List<User> res=new ArrayList<>();
        List<User> temp=userMapper.getUsers(user);
        for(User u:temp)
        {
            if(u.getPass()==0)
            {
                res.add(u);
            }
        }
        return res;
    }

    @Override
    public int Check(String username) {
        return userMapper.UpdatePass(username);
    }
}
