package ynu.edu.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class User {
    private String userId;
    private String passWord;
    private String oldPwd;
    private String userName;
    private String userSex;
    private String userImg;
    private String userPhone;
    private String status;
}
