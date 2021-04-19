package com.creditcardclassification;
//import java.io.*;

public class Client {
   
   StrategyContext strategy=new StrategyContext();
   public void read(String filename){
      if(filename=="data.csv")
      {
        strategy.setStrategy(new CSVFileReaderStrategy());
        strategy.executeStrategy("data.csv");
      }
      else if(filename=="jsondata.json"){
         strategy.setStrategy(new JSONFileReaderStrategy());
        strategy.executeStrategy("jsondata.json");
      }
      else if(filename=="xmldata.xml"){
         strategy.setStrategy(new XMLFileReaderStrategy());
        strategy.executeStrategy("xmldata.xml");
      }
   }
  

}
