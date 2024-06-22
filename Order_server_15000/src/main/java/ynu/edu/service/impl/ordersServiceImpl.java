package ynu.edu.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.edu.entity.OrderDetailet;
import ynu.edu.entity.Orders;
import ynu.edu.entity.UnPayOrder;
import ynu.edu.mapper.OrderDetailetDao;
import ynu.edu.mapper.OrdersDao;
import ynu.edu.service.ordersService;

import java.util.List;

@Service
public class ordersServiceImpl implements ordersService {
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private OrderDetailetDao orderDetailetDao;
    @Override
    public void saveOrders(Orders orders){
        ordersDao.insert(orders);
    }

    @Override
    public int selectRecentOrder(){
        Orders orders = new Orders();
        orders=ordersDao.selectRecentOrder();
        return orders.getOrderId();
    }

    @Override
    public void updateOrder(Orders orders){
        ordersDao.updateOrderState(orders);
    }

    @Override
    public List<Orders> selectUnPay(){
        return ordersDao.selectUnPay();
    }

    @Override
    public List<Orders> selectPay(){
        return ordersDao.selectPay();
    }

    @Override
    public void  saveDetalet(OrderDetailet orderDetailet){
        if (orderDetailet.getQuantity()!=0)
            orderDetailetDao.insert(orderDetailet);
    }
    @Override
    public List<OrderDetailet> selectItem(OrderDetailet orderDetailet){
        return orderDetailetDao.selectItem(orderDetailet);
    }
    @Override
    public List<UnPayOrder> unPayOrder(Orders orders){
        return ordersDao.unPayOrder(orders);
    }
}
