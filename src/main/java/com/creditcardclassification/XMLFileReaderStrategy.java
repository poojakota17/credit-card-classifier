package com.creditcardclassification;
import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLFileReaderStrategy implements FileFormatStrategy {
    public void readfile(String inputfilename, String outputfilename){
       
        try {
           
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            File inputFile = new File(inputfilename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            String result="";
            NodeList nList = doc.getElementsByTagName("row");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    String str=element.getElementsByTagName("CardNumber") .item(0).getTextContent().toString();
                    //System.out.println(str);
                    result=mastercardHandler.checkCreditCard(str);
                    Element row = document.createElement("row");
                    root.appendChild(row);
                    Element cardNo = document.createElement("CardNumber");
                    cardNo.appendChild(document.createTextNode(str));
                    row.appendChild(cardNo);
                    Element cardtype = document.createElement("CardIssuer");
                    cardtype.appendChild(document.createTextNode(result));
                    row.appendChild(cardtype);

            }
        }
    // } catch (Exception e) {
    //     e.printStackTrace();
    //  }
    //  try {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(outputfilename));
        transformer.transform(domSource, streamResult);
        System.out.println("Output file is saved at "+ outputfilename);
     }
    
     catch (ParserConfigurationException pce) {
        pce.printStackTrace();
    }
    catch (Exception e) {
        e.printStackTrace();
     }
    //  catch (TransformerException tfe) {
    //     tfe.printStackTrace();
    // }

}
}
