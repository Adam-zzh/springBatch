package com.sfbest.optimize.batch.model;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TUser implements Serializable {
    private Long id;

    private String userName;

    private String account;

    private String password;

    private Byte userType;

    private String userEmail;

    private String userProfilePhoto;

    private String userPhone;

    private Date createTime;

    private Date loginTime;

    private String rmk;

    private Byte status;

    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", userType=").append(userType);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userProfilePhoto=").append(userProfilePhoto);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", createTime=").append(createTime);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", rmk=").append(rmk);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}