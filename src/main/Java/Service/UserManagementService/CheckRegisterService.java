package Service.UserManagementService;

import POJO.User;

import java.sql.Connection;
import java.util.List;

public interface CheckRegisterService {

    public int Check(String username);

    public List<User> getAllUnRegisterUser(User user);

   // public User getUnRegisterUser(String username);
}
