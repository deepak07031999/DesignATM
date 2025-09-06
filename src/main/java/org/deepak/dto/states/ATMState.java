package org.deepak.dto.states;

import lombok.extern.slf4j.Slf4j;
import org.deepak.dto.ATM;
import org.deepak.dto.Card;
import org.deepak.dto.TransactionType;

@Slf4j
public class ATMState {
    public void insertCard(ATM atm, Card card) {
        log.error("Invalid operation: Cannot insert card in current ATM state");
    }

    public void authenticatePin(ATM atm, Card card, int pin){
        log.error("Invalid operation: Cannot authenticate PIN in current ATM state");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        log.error("Invalid operation: Cannot select operation in current ATM state");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount){
        log.error("Invalid operation: Cannot perform cash withdrawal in current ATM state");
    }

    public void displayBalance(ATM atm, Card card){
        log.error("Invalid operation: Cannot display balance in current ATM state");
    }

    public void returnCard(){
        log.error("Invalid operation: Cannot return card in current ATM state");
    }

    public void exit(ATM atm){
        log.error("Invalid operation: Cannot exit in current ATM state");
    }

}
