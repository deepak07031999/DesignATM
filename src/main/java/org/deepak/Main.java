package org.deepak;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.deepak.dto.*;

@Slf4j
@Data
public class Main {
    public static void main(String[] args) {
        ATM atm = ATM.getATMObject();
        atm.setAtmBalance(1,2,5);

        UserBankAccount bankAccount = new UserBankAccount(3000);

        //create User
        User user = User.builder()
                .card(Card.builder().cardPin(112211).bankAccount(bankAccount).build())
                .bankAccount(bankAccount)
                .build();

        atm.printCurrentATMStatus();
        atm.getCurrentATMState().insertCard(atm, user.getCard());
        atm.getCurrentATMState().authenticatePin(atm, user.getCard(), 112211);
        atm.getCurrentATMState().selectOperation(atm, user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atm.getCurrentATMState().cashWithdrawal(atm, user.getCard(), 2700);
        atm.printCurrentATMStatus();

    }
}