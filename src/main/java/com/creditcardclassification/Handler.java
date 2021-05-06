package com.creditcardclassification;

public abstract class Handler {
    public CreditCardCreator cardCreator;
    public CreditCard card;
    protected Handler nextHandler;
    public String response="";
    public Handler(){

    }
     public  Handler(Handler handler){
        this.nextHandler=handler;
    }

    public void setnexthandler(Handler nexthandler){
        this.nextHandler=nexthandler;
    }
    public abstract String checkCreditCard(String cardnumber);
}

