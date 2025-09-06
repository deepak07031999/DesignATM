package org.deepak.dto;

import lombok.Data;
import org.deepak.dto.states.ATMState;
import org.deepak.dto.states.IdleState;

@Data
public class ATM {

    private static ATM atmObject = new ATM();

    ATMState currentATMState;

    private int atmBalance;
    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfOneHundredNotes;

    public static ATM getATMObject() {
        atmObject.setCurrentATMState(new IdleState());
        return atmObject;
    }
    public void deductTwoThousandNotes(int number) {
        if (number <= 0 || number > noOfTwoThousandNotes) {
            throw new IllegalArgumentException("Invalid deduction amount");
        }
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        if (number <= 0 || number > noOfFiveHundredNotes) {
            throw new IllegalArgumentException("Invalid deduction amount");
        }
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        if (number <= 0 || number > noOfOneHundredNotes) {
            throw new IllegalArgumentException("Invalid deduction amount");
        }
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }


    public void setAtmBalance(int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
        this.atmBalance = noOfOneHundredNotes *100 + noOfFiveHundredNotes*500+ noOfTwoThousandNotes*2000;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }
    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }


}
