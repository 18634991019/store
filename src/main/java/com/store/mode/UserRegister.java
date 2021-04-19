package com.store.mode;



import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * 作者：MaWeiZe
 * 2021/4/16
 */
@Getter
@Setter
@NoArgsConstructor
public class UserRegister {

    private String phone;

    private String userName;

    private String passWord;

    private String passWordTo;

    private String eMail;

    private Integer identity;


}
