package ynu.edu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ynu.edu.entity.Food;

import java.util.List;

@FeignClient("food-server")
public interface ServiceFoodService {
    @PostMapping("/food/getFood")
    public List<Food> getFood(@RequestBody int[] foodIdList);

    @PostMapping("/food/pushFood")
    public Food pushFood(@RequestBody Food food);
}
