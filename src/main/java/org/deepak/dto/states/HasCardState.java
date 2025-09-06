package org.deepak.dto.states;

import lombok.extern.slf4j.Slf4j;
import org.deepak.dto.ATM;
import org.deepak.dto.Card;

@Slf4j
public class HasCardState extends ATMState {

    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isCorrectPinEntered = card.isCorrectPINEntered(pin);
        if(isCorrectPinEntered) {
            atm.setCurrentATMState(new SelectOperationState());
        } else {
            log.error("Invalid PIN Number Entered");
            exit(atm);
        }
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
