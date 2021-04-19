package com.creditcardclassification;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

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

class JSONFileReaderStrategy implements FileFormatStrategy{
    public void readfile(String filename){
        JSONParser parser = new JSONParser();
      try {
         Object obj = parser.parse(new FileReader(filename));
         JSONArray jsonObject = (JSONArray)obj;
         
        Iterator iterator = jsonObject.iterator();
        while (iterator.hasNext()) {
           //System.out.println(iterator.next());
          // System.out.println(((JSONObject)iterator.next()).get("CardNumber").toString());
           String str=((JSONObject)iterator.next()).get("CardNumber").toString();
           mastercardHandler.checkCreditCard(str);
        }
     } catch(Exception e) {
        e.printStackTrace();
     }
    }
}

class XMLFileReaderStrategy implements FileFormatStrategy{
    public void readfile(String filename){
        try {
            File inputFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("row");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    String str=element.getElementsByTagName("CardNumber") .item(0).getTextContent().toString();
                    System.out.println(str);
                    mastercardHandler.checkCreditCard(str);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
     }
    }
}