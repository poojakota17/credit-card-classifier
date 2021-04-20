package com.creditcardclassification;


public interface FileFormatStrategy {
    Handler errorcardHandler= new ErrorCCHandler(null);
    Handler discovercardHandler=new DiscoverCCCheckHandler(errorcardHandler);
    Handler amexcardHandler= new AmexCCCheckHandler(discovercardHandler);
    Handler visacardHandler= new VisaCCCheckHandler(amexcardHandler);
    Handler mastercardHandler= new MasterCCCheckHandler(visacardHandler);
    public  void readfile(String inputfilename, String outputfilename);
}





    