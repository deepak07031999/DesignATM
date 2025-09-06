package org.deepak.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Card {

    private long cardNumber;
    private int cvv;
    private LocalDate expiryDate;
    private String holderName;
    private int cardPin;
    private UserBankAccount bankAccount;

    public boolean isCorrectPINEntered(int pin) {
        return pin == cardPin;
    }
    public int getBankBalance(){
        if (bankAccount == null) {
            throw new IllegalStateException("Bank account not linked to card");
        }
        return bankAccount.balance;
    }

    public void deductBankBalance(int amount){
        if (bankAccount == null) {
            throw new IllegalStateException("Bank account not linked to card");
        }
        bankAccount.withdrawalBalance(amount);
    }


}
