package com.creditcardclassification;

public abstract class Handler {
    CreditCardCreator cardCreator;
    protected Handler nextHandler;
    String response="";
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

class MasterCCCheckHandler extends Handler{

    public MasterCCCheckHandler(Handler nexthandler){
        super(nexthandler);
    }
    public String checkCreditCard(String cardnumber){
        if(cardnumber.length()==16 && cardnumber.charAt(0)=='5' && cardnumber.charAt(1)>='1' && cardnumber.charAt(1)<='5')
                 {   cardCreator= new MasterCC();
                     cardCreator.returncardtype();
                     response="Master card";
                    //System.out.println("i am a Master card");
                  
                }
                    else if(nextHandler!=null)
                    {
                       response= nextHandler.checkCreditCard(cardnumber);
                    
                   }
                   return response;
    }
}

class VisaCCCheckHandler extends Handler{
    public VisaCCCheckHandler(Handler nexthandler){
        super(nexthandler);
    }
    public String checkCreditCard(String cardnumber){
        if((cardnumber.length()==13 ||cardnumber.length()==16) && cardnumber.charAt(0)=='4')
                  {  cardCreator=new VisaCC();
                     cardCreator.returncardtype();
                     response="Visa Card";
                     //System.out.println("i am a Visa card");
                     
                     
                    }
                    else if(nextHandler!=null)
                    {
                        response=nextHandler.checkCreditCard(cardnumber);
                    }
                    return response;
                    
    }
}

class AmexCCCheckHandler extends Handler{
    public AmexCCCheckHandler(Handler nexthandler){
        super(nexthandler);
    }

    public String checkCreditCard(String cardnumber){
        if(cardnumber.length()==17 && cardnumber.charAt(0)=='3' &&(cardnumber.charAt(1)=='4'|| cardnumber.charAt(1)=='7'))
                  {  cardCreator=new AmExCC();
                     cardCreator.returncardtype();
                     response="American Express Card";
                     //System.out.println("i am an American Express card");
                    }
                    else if(nextHandler!=null)
                    {
                        response = nextHandler.checkCreditCard(cardnumber);
                    }
                    return response;

    }
}

class DiscoverCCCheckHandler extends Handler{
    public DiscoverCCCheckHandler(Handler nexthandler){
        super(nexthandler);
    }
    public String checkCreditCard(String cardnumber){
        if(cardnumber.length()==16 && cardnumber.charAt(0)=='6'&& cardnumber.charAt(1)=='0' &&cardnumber.charAt(2)=='1'&& cardnumber.charAt(3)=='1')
                 {   cardCreator= new DiscoverCC();
                     cardCreator.returncardtype();
                     response="Discover Card";
                   // System.out.println("i am a Discover card");
                }
                else if(nextHandler!=null)
                {
                    response = nextHandler.checkCreditCard(cardnumber);
                }
                return response;

    }
}

class ErrorCCHandler extends Handler{
    public ErrorCCHandler(Handler nexthandler){
        super(nexthandler);
    }
    public String checkCreditCard(String cardnumber){
        //System.out.println("I am an error card");
        response="Invalid Card";
        return response;
    }
   
}