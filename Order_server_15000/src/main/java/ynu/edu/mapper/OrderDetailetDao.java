package ynu.edu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ynu.edu.entity.OrderDetailet;

import java.util.List;

@Mapper
public interface OrderDetailetDao extends BaseMapper<OrderDetailet> {

    @Select("select * from order_detailet where orderId = #{orderId}")
    public List<OrderDetailet> selectItem(OrderDetailet orderDetailet);
}
