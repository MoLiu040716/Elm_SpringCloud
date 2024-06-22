package ynu.edu.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.Food;
import ynu.edu.entity.OrderDetailet;
import ynu.edu.entity.Orders;
import ynu.edu.entity.UnPayOrder;
import ynu.edu.feign.ServiceFoodService;
import ynu.edu.service.impl.ordersServiceImpl;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private ServiceFoodService serviceFoodService;
    @Resource
    private ordersServiceImpl ordersService;


    @PostMapping("/getFood")
    @RateLimiter(name = "rate1" , fallbackMethod = "fallbackMethod3")
    public List<Food> getFood(@RequestBody int[] foodIdList){
        return serviceFoodService.getFood(foodIdList);
    }
    
    @PostMapping("/saveOrder")
    @SentinelResource(value = "businessId", blockHandler = "handleException")
    public int saveOrder(@RequestBody Orders orders){
        ordersService.saveOrders(orders);
        return ordersService.selectRecentOrder();
    }

    @PostMapping("/payOrder")
    @Retry(name= "retry1", fallbackMethod = "fallbackMethod1")
    public String payOrder(@RequestBody Orders orders){
        ordersService.updateOrder(orders);
        return "更新成功";
    }
    @GetMapping("/pushUnPayOrder")
    public List<Orders> pushUnPayOrder(){
        return ordersService.selectUnPay();
    }

    @GetMapping("/pushPayOreder")
    @Retry(name = "retry1", fallbackMethod =  "fallbackMethod" )
    public List<Orders> pushPayOrder(){
        return ordersService.selectPay();
    }

    @PostMapping("/saveDetailet")
    public void saveDetailet(@RequestBody OrderDetailet orderDetailet){
        ordersService.saveDetalet(orderDetailet);
    }

    @PostMapping("/pushUnPayItem")
    public List<OrderDetailet> pushUnPayItem(@RequestBody OrderDetailet orderDetailet){
        return ordersService.selectItem(orderDetailet);
    }

    @PostMapping("/pushFood")
    public Food pushFood(@RequestBody Food food){
        return serviceFoodService.pushFood(food);
    }

    @PostMapping("/unPayOrder")
    public List<UnPayOrder> unPayOrder(@RequestBody Orders orders){
        System.out.println(ordersService.unPayOrder(orders));
        return ordersService.unPayOrder(orders);
    }

    public List<Orders> fallbackMethod(Exception e){
        System.out.println("付款服务拥挤，开启重试");
        return null;
    }
    public String fallbackMethod1(Orders orders,Exception e){
        String message = "付款服务拥挤，开启重试";
        System.out.println(message);
        return message;
    }
    public int fallbackMethod2(Orders orders,Exception e){
        String message = "保存订单服务拥挤，开启重试";
        System.out.println(message);
        return 0;
    }
    public List<Food> fallbackMethod3(int[] foodIdList,Exception e){
        String message = "获取食品服务被限流";
        System.out.println(message);
        return null;
    }
    public String handleException(Orders orders, BlockException ex) {
        System.out.println("参数热点限制");
        return "Blocked by Sentinel: " + ex.getClass().getSimpleName();
    }
    @PostConstruct
    public void initParamFlowRules() {
        ParamFlowRule rule = new ParamFlowRule("businessId")
                .setParamIdx(0)
                .setCount(10)
                .setParamFlowItemList(Collections.singletonList(
                        new ParamFlowItem().setObject("10002").setClassType(String.class.getName()).setCount(5)
                ));
        ParamFlowRuleManager.loadRules(Collections.singletonList(rule));
    }
}
