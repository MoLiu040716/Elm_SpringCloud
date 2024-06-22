package ynu.edu.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.edu.entity.User;
import ynu.edu.mapper.UserDao;
import ynu.edu.service.registerService;

@Service
public class registerServiceImpl implements registerService {
    @Resource
    private UserDao userDao;

    @Override
    public void insertUser(User user){
        userDao.insert(user);
    }

    @Override
    public User selectUser(String id){
       return userDao.select(id);
    }
}
