package com.creditcardclassification.project;

import com.creditcardclassification.XMLFileReaderStrategy;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import org.custommonkey.xmlunit.XMLTestCase;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

public class XMLFileReaderStrategyTests {
    @Test
    @DisplayName("XML output file  compared to generated xml output file should be true ")
    void XMLFileReaderStrategyTest() throws IOException, SAXException, ParserConfigurationException {
        File File1 = new File("outputdata.xml");
        XMLFileReaderStrategy xmlFileReaderStrategy = new XMLFileReaderStrategy();
        xmlFileReaderStrategy.readfile("data.xml", "testdata");
        File File2 = new File("testdata.xml");
        XMLUnit.setIgnoreWhitespace(true);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse("outputdata.xml");
        doc.getDocumentElement().normalize();
        DocumentBuilderFactory dbFactorytest = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuildertest = dbFactorytest.newDocumentBuilder();
        Document doctest = dBuildertest.parse("testdata.xml");
        doctest.getDocumentElement().normalize();

        assertXMLEqual(doc,doctest);
    }
}
