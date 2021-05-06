package com.creditcardclassification.project;

import com.creditcardclassification.Client;
import com.creditcardclassification.FileFormatStrategy;
import com.creditcardclassification.XMLFileReaderStrategy;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class XMLFileReaderStrategyTest {
    @Test
    @DisplayName("XML file input should generate object of class XMLFileReaderStrategy")
    void XMLFileReaderStrategyTests() {
        Client client1 = new Client();
        FileFormatStrategy teststrategy1 = new XMLFileReaderStrategy();
        client1.read("data.xml", "outputdata");
        Assert.assertEquals(client1.fileFormatStrategy.getClass(), teststrategy1.getClass());
    }

}
