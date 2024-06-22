package ynu.edu.entity;

import lombok.Data;

@Data
public class UnPayOrder {
    private String foodImg;
    private String foodName;
    private Double foodPrice;
    private int quantity;
    private double orderTotal;
}
