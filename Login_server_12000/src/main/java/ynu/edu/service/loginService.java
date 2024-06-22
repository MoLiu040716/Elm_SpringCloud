package ynu.edu.service;


import ynu.edu.entity.User;

public interface loginService {
    public User login(String userId, String passWord);
}
