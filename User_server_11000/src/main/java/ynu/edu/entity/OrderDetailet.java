package ynu.edu.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderDetailet {

    private Integer odId;
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;
}
