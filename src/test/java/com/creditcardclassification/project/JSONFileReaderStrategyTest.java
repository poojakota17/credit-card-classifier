package com.creditcardclassification.project;

import com.creditcardclassification.Client;
import com.creditcardclassification.FileFormatStrategy;
import com.creditcardclassification.JSONFileReaderStrategy;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JSONFileReaderStrategyTest {
    @Test
    @DisplayName("JSON file input should generate object of class JSONFileReaderStrategy")
    void JSONFileReaderStrategyTest() {
        Client client1 = new Client();
        FileFormatStrategy teststrategy1 = new JSONFileReaderStrategy();
        client1.read("data.json", "outputdata");
        Assert.assertEquals(client1.fileFormatStrategy.getClass(), teststrategy1.getClass());
    }
}
