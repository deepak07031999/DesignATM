package org.deepak.dto.states;

import lombok.extern.slf4j.Slf4j;
import org.deepak.dto.ATM;
import org.deepak.dto.Card;

@Slf4j
public class CheckBalanceState extends ATMState {

    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Your Balance is: " + card.getBankBalance());
        exit(atm);
    }


    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentATMState(new IdleState());
        log.info("Exit happens");
    }

    @Override
    public void returnCard(){
        log.info("Please collect your card");
    }
}
