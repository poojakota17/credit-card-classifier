package com.creditcardclassification;
import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;
import java.util.List;


public class CSVFileReaderStrategy implements FileFormatStrategy{
    public static final String delimiter = ",";
    public List<String[]> data = new ArrayList<String[]>();
    
    String result="";
    public void readfile(String inputfilename, String outputfilename){
        try {
            //data.add(new String[] {"CardNumber","CardIssuer"});
            File file = new File(inputfilename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr={};
            while((line = br.readLine()) != null) {
               tempArr = line.split(delimiter);
              // System.out.println(tempArr[0]);
               String str=tempArr[0];
              result= mastercardHandler.checkCreditCard(str);
              if(str.equalsIgnoreCase("CardNumber"))
              data.add(new String[]{str,"CardIssuer"});
              else
              data.add(new String[]{str,result});
            }
         
            br.close();
            } catch(IOException ioe) {
               ioe.printStackTrace();
            }
           // C:/Users/Checkout/javaproject/project/
           outputfilename=outputfilename.concat(".csv");
            File outputfile = new File(outputfilename);
        for (String[] arr : data) {
            System.out.println(Arrays.toString(arr));
        }
            try {
               
                FileWriter outputfile1 = new FileWriter(outputfile);
                CSVWriter writer = new CSVWriter(outputfile1);
                writer.writeAll(data);
                System.out.println("Output file is saved at "+ outputfilename);
                writer.close();
            }
            catch (IOException e) {
                
                e.printStackTrace();
            }
  
          
    }
    
}
