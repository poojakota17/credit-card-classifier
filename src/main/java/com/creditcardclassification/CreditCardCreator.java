package com.creditcardclassification;

public abstract class CreditCardCreator {
    public abstract CreditCard createCreditCard();
   
    public void returncardtype(){
        CreditCard type= createCreditCard();
        type.outputToFile();
}
}
class VisaCC extends CreditCardCreator{
    public CreditCard createCreditCard(){
        return new Visa();
    }

}
 class MasterCC extends CreditCardCreator{
    public CreditCard createCreditCard(){
        return new Master();
    }

}
 class AmExCC extends CreditCardCreator{
    public CreditCard createCreditCard(){
        return new AmEx();
    }

}
 class DiscoverCC extends CreditCardCreator{
    public CreditCard createCreditCard(){
        return new Discover();
    }

}