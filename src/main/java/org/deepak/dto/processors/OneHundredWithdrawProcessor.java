package org.deepak.dto.processors;

import org.deepak.dto.ATM;

public class OneHundredWithdrawProcessor extends  CashWithdrawProcessor{
    public OneHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public synchronized void withdraw(ATM atm, int remainingAmount){
        int required =  remainingAmount/100;
        int balance = remainingAmount%100;
        int availableNotes = atm.getNoOfOneHundredNotes();

        if(required <= availableNotes) {
            atm.deductOneHundredNotes(required);
        }
        else {
            balance = balance + (required - availableNotes) * 100;
            atm.deductOneHundredNotes(availableNotes);
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }

    }
}
