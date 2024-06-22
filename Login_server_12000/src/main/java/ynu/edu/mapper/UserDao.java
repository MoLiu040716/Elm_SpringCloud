package ynu.edu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ynu.edu.entity.User;

@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("select * from user where userId=${userId} and passWord=${passWord}")
    public User selectUser(@Param("userId") String userId,@Param("passWord") String passWord);

    @Select("select * from user where userId=${userId} ")
    public User select(String userId);

    @Select("select userImg from user where userId=#{userId}")
    public String selectImg(User user);

    @Update("update user set userImg=#{userImg} where userId=#{userId}")
    public void updateImg(User user);

    @Update("update user set userName=#{userName}, userPhone=#{userPhone} where userId=#{userId}")
    public void updateIndividual(User user);
}
