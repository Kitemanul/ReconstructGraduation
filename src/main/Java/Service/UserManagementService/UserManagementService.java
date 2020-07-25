package Service.UserManagementService;

import POJO.User;

import java.util.List;

public interface UserManagementService {

    public List<User> SearchaUsers(User user);

    public int InsertUser(User user);

    public int UpdateUser(User user,String username);

    public int DeleteUser(String username);
}
