package com.creditcardclassification;

public class MasterCCCheckHandler extends Handler {

    public MasterCCCheckHandler(Handler nexthandler) {
        super(nexthandler);
    }

    public String checkCreditCard(String cardnumber) {
        if (cardnumber.length() == 16 && cardnumber.charAt(0) == '5' && cardnumber.charAt(1) >= '1' && cardnumber.charAt(1) <= '5') {
            cardCreator = new MasterCC();
            card=cardCreator.returncardtype();
            response = "Master card";
            //System.out.println("i am a Master card");

        } else if (nextHandler != null) {
            response = nextHandler.checkCreditCard(cardnumber);

        }
        return response;
    }
}
