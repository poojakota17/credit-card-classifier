package com.creditcardclassification.project;

import com.creditcardclassification.Client;
import com.creditcardclassification.FileFormatStrategy;
import com.creditcardclassification.JSONFileReaderStrategy;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class JSONFileReaderStrategyTests {
    @Test
    @DisplayName("JSON output string comparison for json file type ")
    void JSONFileReaderStrategyTest() {
        JSONFileReaderStrategy jsonFileReaderStrategy=new JSONFileReaderStrategy();
       jsonFileReaderStrategy.readfile("data.json","outputdata");
        assertEquals(jsonFileReaderStrategy.jsonString, "[{\"CardNumber\":\"5410000000000000\",\"CardIssuer\":\"Master card\"},{\"CardNumber\":\"4120000000000\",\"CardIssuer\":\"Visa Card\"},{\"CardNumber\":\"341000000000000\",\"CardIssuer\":\"Invalid Card\"},{\"CardNumber\":\"6011000000000000\",\"CardIssuer\":\"Discover Card\"}]");
    }
}
