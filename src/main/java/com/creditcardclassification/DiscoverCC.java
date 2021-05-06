package com.creditcardclassification;

public class DiscoverCC extends CreditCardCreator {
    public CreditCard createCreditCard() {
        return new Discover();
    }

}
