package com.creditcardclassification;
import java.io.*;

public interface FileFormatStrategy {
    Handler errorcardHandler= new ErrorCCHandler(null);
    Handler discovercardHandler=new DiscoverCCCheckHandler(errorcardHandler);
    Handler amexcardHandler= new AmexCCCheckHandler(discovercardHandler);
    Handler visacardHandler= new VisaCCCheckHandler(amexcardHandler);
    Handler mastercardHandler= new MasterCCCheckHandler(visacardHandler);
    public  void readfile(String filename);
}

class CSVFileReaderStrategy implements FileFormatStrategy{
    public static final String delimiter = ",";
    public void readfile(String filename){
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr={};
            while((line = br.readLine()) != null) {
               tempArr = line.split(delimiter);
               System.out.println(tempArr[0]);
               String str=tempArr[0];
               mastercardHandler.checkCreditCard(str);
            }
         
            br.close();
            } catch(IOException ioe) {
               ioe.printStackTrace();
            }
    }
}