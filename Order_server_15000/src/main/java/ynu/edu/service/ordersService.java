package ynu.edu.service;



import ynu.edu.entity.OrderDetailet;
import ynu.edu.entity.Orders;
import ynu.edu.entity.UnPayOrder;

import java.util.List;

public interface ordersService {
    public void saveOrders(Orders orders);
    public int selectRecentOrder();

    public void updateOrder(Orders orders);

    public List<Orders> selectUnPay();

    public List<Orders> selectPay();

    public void  saveDetalet(OrderDetailet orderDetailet);

    public List<OrderDetailet> selectItem(OrderDetailet orderDetailet);

    public List<UnPayOrder> unPayOrder(Orders orders);
}
