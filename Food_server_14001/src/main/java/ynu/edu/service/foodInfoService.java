package ynu.edu.service;


import ynu.edu.entity.Food;

import java.util.List;

public interface foodInfoService {
    public List<Food> getFoodInfo();

    public Food getFoodById(int Id);
}
