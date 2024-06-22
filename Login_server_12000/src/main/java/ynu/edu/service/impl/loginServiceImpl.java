package ynu.edu.service.impl;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.edu.entity.User;
import ynu.edu.mapper.UserDao;
import ynu.edu.service.loginService;

@Service
public class loginServiceImpl implements loginService {
    @Resource
    private UserDao userDao;
    @Override
    public User login(String userId, String passWord){
        return userDao.selectUser(userId,passWord);
    }
}
