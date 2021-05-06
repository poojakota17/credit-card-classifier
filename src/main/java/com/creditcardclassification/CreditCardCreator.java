package com.creditcardclassification;

public abstract class CreditCardCreator {
    public abstract CreditCard createCreditCard();
   
    public CreditCard returncardtype(){
        CreditCard type= createCreditCard();
        type.outputToFile();
        return type;
}
}
