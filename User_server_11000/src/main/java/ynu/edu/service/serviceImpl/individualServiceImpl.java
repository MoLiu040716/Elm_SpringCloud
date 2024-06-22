package ynu.edu.service.serviceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.edu.entity.User;
import ynu.edu.mapper.UserDao;
import ynu.edu.service.individualService;

@Service
public class individualServiceImpl implements individualService {

    @Resource
    private UserDao userDao;
    @Override
    public void insertImg(User user){
        if (userDao.select(user.getUserId())!=null )
            userDao.updateImg(user);
    }
    @Override
    public String pushImg(User user){
        User user1=userDao.select(user.getUserId());
        return user1.getUserImg();
    }

    @Override
    public void saveIndividual(User user){
        userDao.updateIndividual(user);
    }

    public User pushUser(User user){
        return userDao.select(user.getUserId());
    }
}
