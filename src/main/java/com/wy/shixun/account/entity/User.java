package com.wy.shixun.account.entity;

import lombok.Data;
import com.wy.shixun.common.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="account_user")
public class User extends AbstractEntity {
    private String userName;
    private String password;


    public User(int id, LocalDateTime createTime, LocalDateTime updateTime, String userName, String password){
        super(id,createTime,updateTime);
        this.userName = userName;
        this.password = password;
    }

    public User() {

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
