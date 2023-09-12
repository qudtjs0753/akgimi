package com.kangkimleekojangcho.akgimi.bank.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne
    //@JoinColumn(name = "user_id")
    //private User user;

    private AccountType accountType;

    private String bank;

    private String accountNumber;

    private Long balance;

    private String password;

    private Boolean isDeleted;

    private Boolean isRegisteredPassword;

}
