package com.kangkimleekojangcho.akgimi.bank.adapter.in.request;

import com.kangkimleekojangcho.akgimi.bank.domain.Bank;
import lombok.Getter;

@Getter
public class CreateAccountRequest {
    private String AccountType;
    private Bank bank;
}
