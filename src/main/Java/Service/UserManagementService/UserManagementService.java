package Service.UserManagementService;

import POJO.User;

import java.util.List;

public interface UserManagementService {

    public List<User> SearchaAllUser();

    public User SearchUser(String username);

    public List<User> SearchaUsersByRight(int right);

    public User SearchaUsersByRightUsername(String username,int permission);

    public int InsertUser(User user);

    public int UpdateUser(User user,String username);

    public int DeleteUser(String username);
}
