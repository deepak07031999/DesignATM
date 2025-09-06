package org.deepak.dto.states;

import lombok.extern.slf4j.Slf4j;
import org.deepak.dto.ATM;
import org.deepak.dto.Card;
import org.deepak.dto.TransactionType;

@Slf4j
public class SelectOperationState extends ATMState {
    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        switch (txnType) {

            case CASH_WITHDRAWAL:
                atm.setCurrentATMState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atm.setCurrentATMState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Option");
                exit(atm);
            }
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

    private void showOperations(){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }

}
