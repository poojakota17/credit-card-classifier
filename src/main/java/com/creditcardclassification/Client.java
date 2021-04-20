package com.creditcardclassification;
//import java.io.*;


public class Client {
   
   StrategyContext strategy=new StrategyContext();
   public void read(String inputfilename,String outputfilename){
      if(inputfilename.substring(inputfilename.lastIndexOf(".") + 1).equalsIgnoreCase("csv"))
      {
        strategy.setStrategy(new CSVFileReaderStrategy());
        strategy.executeStrategy(inputfilename,outputfilename);
      }
      else if(inputfilename.substring(inputfilename.lastIndexOf(".") + 1).equalsIgnoreCase("json")){
         strategy.setStrategy(new JSONFileReaderStrategy());
        strategy.executeStrategy(inputfilename,outputfilename);
           
        
      }
      else if(inputfilename.substring(inputfilename.lastIndexOf(".") + 1).equalsIgnoreCase("xml")){
         strategy.setStrategy(new XMLFileReaderStrategy());
        strategy.executeStrategy(inputfilename,outputfilename);
      }
      else {
         System.out.println("File format not supported");
      }
   }
  

}
