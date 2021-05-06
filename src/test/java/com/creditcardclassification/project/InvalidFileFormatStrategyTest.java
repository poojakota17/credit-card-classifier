package com.creditcardclassification.project;

import com.creditcardclassification.Client;
import com.creditcardclassification.FileFormatStrategy;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InvalidFileFormatStrategyTest {

    @Test
    @DisplayName("Invalid file input should generate null object ")
    void InvalidFileReaderStrategyTest() {
        Client client1 = new Client();
        FileFormatStrategy teststrategy1 =null;
        client1.read("data.txt", "outputdata");
        Assert.assertSame(client1.fileFormatStrategy, null);
    }
}
