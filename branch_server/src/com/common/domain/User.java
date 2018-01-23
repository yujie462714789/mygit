package com.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "user_tab")
public class User
{
    private Long userId;
    private String userName;
    private String userAccount;
    private String password;
    
    @Id
    @GeneratedValue(generator="user_id") //自动生成ID
    @GenericGenerator(name="user_id",strategy="increment")
    @Column(name="user_id", length=36)
    public Long getUserId()
    {
        return userId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
    @Column(name="user_name", length=40)
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    @Column(name="user_account", length=40)
    public String getUserAccount()
    {
        return userAccount;
    }
    public void setUserAccount(String userAccount)
    {
        this.userAccount = userAccount;
    }
    @Column(name="password", length=40)
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    
}
