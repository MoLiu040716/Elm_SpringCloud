package ynu.edu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ynu.edu.entity.Orders;
import ynu.edu.entity.UnPayOrder;

import java.util.List;

@Mapper
public interface OrdersDao extends BaseMapper<Orders> {
    @Select("select * from orders order by orderId DESC limit 1")
    public Orders selectRecentOrder();

    @Update("update orders set orderState=1 where orderId = #{orderId}")
    public void updateOrderState(Orders orders);

    @Select("select * from orders where orderState=0")
    public List<Orders> selectUnPay();
    @Select("select * from orders where orderState=1")
    public List<Orders> selectPay();

    @Select("SELECT food.foodImg, food.foodName, food.foodPrice, order_detailet.quantity, orders.orderTotal  FROM food JOIN order_detailet ON food.foodId = order_detailet.foodId JOIN orders ON orders.orderId = order_detailet.orderId WHERE orders.orderId = #{orderId}")
    public List<UnPayOrder> unPayOrder(Orders orders);
}
