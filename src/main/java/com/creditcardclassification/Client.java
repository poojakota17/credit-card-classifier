package com.creditcardclassification;
//import java.io.*;


public class Client {
   
    StrategyContext strategy=new StrategyContext();
    public FileFormatStrategy fileFormatStrategy;
   public void read(String inputfilename,String outputfilename){
      if(inputfilename.substring(inputfilename.lastIndexOf(".") + 1).equalsIgnoreCase("csv"))
      {
       fileFormatStrategy= strategy.setStrategy(new CSVFileReaderStrategy());
        strategy.executeStrategy(inputfilename,outputfilename);
      }
      else if(inputfilename.substring(inputfilename.lastIndexOf(".") + 1).equalsIgnoreCase("json")){
        fileFormatStrategy= strategy.setStrategy(new JSONFileReaderStrategy());
        strategy.executeStrategy(inputfilename,outputfilename);
           
        
      }
      else if(inputfilename.substring(inputfilename.lastIndexOf(".") + 1).equalsIgnoreCase("xml")){
        fileFormatStrategy= strategy.setStrategy(new XMLFileReaderStrategy());
        strategy.executeStrategy(inputfilename,outputfilename);
      }
      else {
          fileFormatStrategy=null;
         System.out.println("File format not supported, please provide a file with csv,json or xml extensions");
      }
   }
  

}
