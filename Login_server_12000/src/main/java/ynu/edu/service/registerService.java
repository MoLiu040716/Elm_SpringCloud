package ynu.edu.service;


import ynu.edu.entity.User;

public interface registerService {
    public void insertUser(User user);
    public User selectUser(String id);
}
