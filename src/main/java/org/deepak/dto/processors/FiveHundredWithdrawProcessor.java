package org.deepak.dto.processors;

import org.deepak.dto.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public synchronized void withdraw(ATM atm, int remainingAmount){
        int required =  remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        }
        else if(required > atm.getNoOfFiveHundredNotes()) {
            balance = balance + (required-atm.getNoOfFiveHundredNotes()) * 500;
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }

    }
}
