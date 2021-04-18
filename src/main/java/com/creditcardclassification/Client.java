package com.creditcardclassification;
import java.io.*;
public class Client {
   //CreditCardCreator cardCreator;
    public static final String delimiter = ",";
    public  void read(String csvFile) {
       try {
          File file = new File(csvFile);
          FileReader fr = new FileReader(file);
          BufferedReader br = new BufferedReader(fr);
          String line = "";
          String[] tempArr={};
          while((line = br.readLine()) != null) {
             tempArr = line.split(delimiter);
             System.out.println(tempArr[0]);
             String str=tempArr[0];
             if(tempArr[0].length()<=19){
               if(str.length()==16 && str.charAt(0)=='5' && str.charAt(1)>='1' && str.charAt(1)<='5')
                  System.out.println("i am a Master card");
                  else if((str.length()==13 || str.length()==16) && str.charAt(0)=='4')
                  System.out.println("i am a Visa card");
                  else if(str.length()==17 && str.charAt(0)=='3' &&(str.charAt(1)=='4'|| str.charAt(1)=='7'))
                  System.out.println("i am an American Express card");
                  else if(str.length()==16 && str.charAt(0)=='6'&& str.charAt(1)=='0' && str.charAt(2)=='1'&& str.charAt(3)=='1')
                  System.out.println("i am a Discover card");
               
             }
             else
             {
               System.out.println("i am error");
               //CreditCardCreator cardCreator=null;
             }
            //  for(String tempStr : tempArr) {
              
            //    // System.out.print(tempStr + " ");
            //  }
             System.out.println();
          }
         
          br.close();
          } catch(IOException ioe) {
             ioe.printStackTrace();
          }
          //cardCreator.returncardtype();
    }
   
}
