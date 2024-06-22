package ynu.edu.service;



import ynu.edu.entity.DeliveryAddress;

import java.util.List;

public interface addAddressService {
    public void saveAddress(DeliveryAddress deliveryAddress);
    public List<DeliveryAddress> pushAddress();

    public void editAddress(DeliveryAddress deliveryAddress);
}
