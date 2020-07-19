package Service.UserManagementService;

import POJO.User;

import java.sql.Connection;
import java.util.List;

public interface CheckRegisterService {

    public boolean Check(User user);

    public List<User> getAllUnRegisterUser();

    public User getUnRegisterUser(String username);
}
