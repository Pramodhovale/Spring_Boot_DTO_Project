package com.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import jdk.jfr.Enabled;
import lombok.Data;

@Data
@Entity

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String accountName;
    private String accountNumber;
    private String accountEmail;
    private String accountPassword;
    private Long accountBalance;

}
