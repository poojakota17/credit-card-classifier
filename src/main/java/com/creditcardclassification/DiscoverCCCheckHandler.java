package com.creditcardclassification;

public class DiscoverCCCheckHandler extends Handler {
    public DiscoverCCCheckHandler(Handler nexthandler) {
        super(nexthandler);
    }

    public String checkCreditCard(String cardnumber) {
        if (cardnumber.length() == 16 && cardnumber.charAt(0) == '6' && cardnumber.charAt(1) == '0' && cardnumber.charAt(2) == '1' && cardnumber.charAt(3) == '1') {
            cardCreator = new DiscoverCC();
            card=cardCreator.returncardtype();
            response = "Discover Card";
            // System.out.println("i am a Discover card");
        } else if (nextHandler != null) {
            response = nextHandler.checkCreditCard(cardnumber);
        }
        return response;

    }
}
