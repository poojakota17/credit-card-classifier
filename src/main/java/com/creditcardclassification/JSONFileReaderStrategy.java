package com.creditcardclassification;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import com.google.gson.Gson;
import java.util.List;



public class JSONFileReaderStrategy implements FileFormatStrategy {
    public String jsonString;
    public void readfile(String inputfilename, String outputfilename){
        JSONParser parser = new JSONParser();
        //JSONObject jsonwriteObject = new JSONObject();

        String result="";
        Gson gson = new Gson();
        List cardList = new ArrayList<>();
      try {
         Object obj = parser.parse(new FileReader(inputfilename));
         JSONArray jsonObject = (JSONArray)obj;
         //jsonwriteObject.put("CardNumber","CardIssuer");
        Iterator iterator = jsonObject.iterator();
        while (iterator.hasNext()) {
           //System.out.println(iterator.next());
          // System.out.println(((JSONObject)iterator.next()).get("CardNumber").toString());
           String str=((JSONObject)iterator.next()).get("CardNumber").toString();
          
           result=mastercardHandler.checkCreditCard(str);
            cardList.add(new JsonCardClass(str,result));
          
        }
        
     } catch(Exception e) {
        e.printStackTrace();
     }
     
     try {
         jsonString = gson.toJson(cardList);
       // System.out.println(jsonString);
        outputfilename=outputfilename.concat(".json");
        FileWriter file = new FileWriter(outputfilename);
        file.write(jsonString);
        file.close();
        System.out.println("Output file is saved at "+ outputfilename);
     } catch (IOException e) {
       
        e.printStackTrace();
     }
    }
}
