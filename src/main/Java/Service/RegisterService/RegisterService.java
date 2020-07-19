package Service.RegisterService;

import POJO.User;

import java.sql.Connection;

public interface RegisterService {

    public int Register(User user);
    public User getUser(String username);
}
