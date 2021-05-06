package com.creditcardclassification;

public class AmexCCCheckHandler extends Handler {
    public AmexCCCheckHandler(Handler nexthandler) {
        super(nexthandler);
    }

    public String checkCreditCard(String cardnumber) {
        if (cardnumber.length() == 17 && cardnumber.charAt(0) == '3' && (cardnumber.charAt(1) == '4' || cardnumber.charAt(1) == '7')) {
            cardCreator = new AmExCC();
            card=cardCreator.returncardtype();
            response = "American Express Card";
            //System.out.println("i am an American Express card");
        } else if (nextHandler != null) {
            response = nextHandler.checkCreditCard(cardnumber);
        }
        return response;

    }
}
