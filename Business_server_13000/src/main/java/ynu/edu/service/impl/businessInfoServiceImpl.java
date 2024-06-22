package ynu.edu.service.impl;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.edu.entity.Business;
import ynu.edu.mapper.BusinessDao;
import ynu.edu.service.businessInfoService;

import java.util.List;

@Service
public class businessInfoServiceImpl implements businessInfoService {
    @Resource
    private BusinessDao businessDao;

    @Override
    public List<Business> selectBusinessInfo(){
        return businessDao.selectList(null);
    }
}
