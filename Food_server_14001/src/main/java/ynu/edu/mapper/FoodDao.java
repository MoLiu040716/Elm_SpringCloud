package ynu.edu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ynu.edu.entity.Food;

@Mapper
public interface FoodDao extends BaseMapper<Food> {
    @Select("select * from food where foodId = #{id}")
    public Food selectByFoodId(int id);


}
