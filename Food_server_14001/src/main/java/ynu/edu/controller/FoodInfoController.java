package ynu.edu.controller;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.Food;
import ynu.edu.service.impl.foodInfoServiceImpl;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/food")
public class FoodInfoController {
    @Resource
    private foodInfoServiceImpl foodInfoService;

    @GetMapping("/foodInfo")
    public List<Food> pushFoodInfo(){
        return foodInfoService.getFoodInfo();
    }

    @PostMapping("/getFood")
    public List<Food> getFood(@RequestBody int[] foodIdList){
        List <Food> result = new ArrayList<>();
        for (int i=0; i<foodIdList.length;i++){
            if (foodInfoService.getFoodById(foodIdList[i])!=null){
                result.add(foodInfoService.getFoodById(foodIdList[i]));
            }
        }
        return result;
    }

    @PostMapping("/pushFood")
    public Food pushFood(@RequestBody Food food){
        int i = food.getFoodId();
        return foodInfoService.getFoodById(i);
    }
}
