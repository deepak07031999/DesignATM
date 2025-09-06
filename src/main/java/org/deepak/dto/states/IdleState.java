package org.deepak.dto.states;

import lombok.extern.slf4j.Slf4j;
import org.deepak.dto.ATM;
import org.deepak.dto.Card;

@Slf4j
public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        log.info("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }

}
