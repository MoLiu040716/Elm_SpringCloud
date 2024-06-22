package ynu.edu.controller;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.DeliveryAddress;
import ynu.edu.service.impl.addAddressServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Resource
    private addAddressServiceImpl addAddressService;

    @PostMapping("/saveAddress")
    public String saveAddress(@RequestBody DeliveryAddress deliveryAddress){
        addAddressService.saveAddress(deliveryAddress);
        return "保存成功";
    }

    @GetMapping("/pushAddress")
    public List<DeliveryAddress> pushAddress(){
        return addAddressService.pushAddress();
    }

    @PostMapping("/editAddress")
    public String editAddress(@RequestBody DeliveryAddress deliveryAddress){
        addAddressService.editAddress(deliveryAddress);
        return "修改成功";
    }
}
