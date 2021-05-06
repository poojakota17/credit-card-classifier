package com.creditcardclassification;

public class MasterCC extends CreditCardCreator {
    public CreditCard createCreditCard() {
        return new Master();
    }

}
