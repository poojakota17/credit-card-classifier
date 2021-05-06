package com.creditcardclassification;

public class ErrorCCHandler extends Handler {
    public ErrorCCHandler(Handler nexthandler) {
        super(nexthandler);
    }

    public String checkCreditCard(String cardnumber) {
        //System.out.println("I am an error card");
        response = "Invalid Card";
        return response;
    }

}
