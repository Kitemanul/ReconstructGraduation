//package Service.UserManagementService;
//
//import Dao.BaseDao;
//import Dao.User.UserMapper;
//import POJO.User;
//import Util.MyBatisUtil;
//import org.apache.ibatis.session.SqlSession;
//
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CheckRegisterServiceImpl implements CheckRegisterService
//{
//
//    @Override
//    public User getUnRegisterUser(String username) {
//        SqlSession sqlSession= MyBatisUtil.getSqlSession();
//        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
//        User user=null;
//        try{
//
//            user=userMapper.getUser(username);
//            if(user.getPass()==0)
//            {
//                return user;
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally {
//            sqlSession.close();
//        }
//        return null;
//
//    }
//
//    @Override
//    public List<User> getAllUnRegisterUser() {
//        List<User> res=new ArrayList<>();
//        SqlSession sqlSession= MyBatisUtil.getSqlSession();
//
//        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
//
//        try {
//
//            List<User> temp=userMapper.SelectAllUser();
//
//            for(User user:temp)
//            {
//                if(user.getPass()==0)
//                {
//                    res.add(user);
//                }
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        finally {
//            sqlSession.close();
//        }
//
//        return res;
//    }
//
//    @Override
//    public int Check(String username) {
//        int res=0;
//        SqlSession sqlSession= MyBatisUtil.getSqlSession();
//        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
//
//        res=userMapper.UpdatePass(username);
//        sqlSession.close();
//
//        return res;
//    }
//}
