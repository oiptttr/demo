package com.shirodemo.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
    private int id;
    private String name;
    private String password;
    private String perms;
}
