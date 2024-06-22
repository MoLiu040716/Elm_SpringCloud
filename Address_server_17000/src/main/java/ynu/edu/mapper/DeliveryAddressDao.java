package ynu.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import ynu.edu.entity.DeliveryAddress;

@Mapper
public interface DeliveryAddressDao extends BaseMapper<DeliveryAddress> {
    @Update("update delivery_address set contactName=#{contactName},contactTel=#{contactTel},address=#{address},contactSex=#{contactSex} where daId=#{daId}")
    public void editAddress(DeliveryAddress deliveryAddress);
}
