package com.creditcardclassification;

public class VisaCCCheckHandler extends Handler {
    public VisaCCCheckHandler(Handler nexthandler) {
        super(nexthandler);
    }

    public String checkCreditCard(String cardnumber) {
        if ((cardnumber.length() == 13 || cardnumber.length() == 16) && cardnumber.charAt(0) == '4') {
            cardCreator = new VisaCC();
            card=cardCreator.returncardtype();
            response = "Visa Card";
            //System.out.println("i am a Visa card");


        } else if (nextHandler != null) {
            response = nextHandler.checkCreditCard(cardnumber);
        }
        return response;

    }
}
