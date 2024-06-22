package ynu.edu.service.impl;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.edu.entity.Food;
import ynu.edu.mapper.FoodDao;
import ynu.edu.service.foodInfoService;

import java.util.List;

@Service
public class foodInfoServiceImpl implements foodInfoService {
    @Resource
    private FoodDao foodDao;

    @Override
    public List<Food> getFoodInfo(){
        return foodDao.selectList(null);
    }

    @Override
    public Food getFoodById(int Id){
        return foodDao.selectByFoodId(Id);
    }
}
