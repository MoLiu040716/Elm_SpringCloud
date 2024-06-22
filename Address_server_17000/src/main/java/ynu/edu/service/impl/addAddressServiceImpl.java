package ynu.edu.service.impl;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.edu.entity.DeliveryAddress;
import ynu.edu.mapper.DeliveryAddressDao;
import ynu.edu.service.addAddressService;

import java.util.List;

@Service
public class addAddressServiceImpl implements addAddressService {
    @Resource
    private DeliveryAddressDao deliveryAddressDao;
    @Override
    public void saveAddress(DeliveryAddress deliveryAddress){
        deliveryAddressDao.insert(deliveryAddress);
    }

    @Override
    public List<DeliveryAddress> pushAddress(){
        return deliveryAddressDao.selectList(null);
    }

    @Override
    public void editAddress(DeliveryAddress deliveryAddress){
        deliveryAddressDao.editAddress(deliveryAddress);
    }
}
