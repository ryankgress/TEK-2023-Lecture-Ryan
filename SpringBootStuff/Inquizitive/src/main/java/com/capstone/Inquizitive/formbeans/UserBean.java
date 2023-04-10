package com.capstone.Inquizitive.formbeans;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserBean {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String profilePic;

}
