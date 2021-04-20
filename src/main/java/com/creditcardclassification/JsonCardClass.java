package com.creditcardclassification;

public class JsonCardClass {
    String CardNumber;
    String CardIssuer;
    JsonCardClass(){

    }
    JsonCardClass(String cardnumber, String cardissuer){
        this.CardNumber=cardnumber;
        this.CardIssuer=cardissuer;
    }
}
