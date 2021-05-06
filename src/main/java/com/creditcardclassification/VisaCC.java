package com.creditcardclassification;

public class VisaCC extends CreditCardCreator {
    public CreditCard createCreditCard() {
        return new Visa();
    }

}
