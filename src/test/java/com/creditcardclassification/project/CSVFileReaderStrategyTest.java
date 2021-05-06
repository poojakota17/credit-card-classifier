package com.creditcardclassification.project;

import com.creditcardclassification.CSVFileReaderStrategy;
import com.creditcardclassification.Client;
import com.creditcardclassification.FileFormatStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CSVFileReaderStrategyTest {
    @Test
    @DisplayName("CSV file input should generate object of class CSVFileReaderStrategy")
    void CsvFileReaderStrategyTest() {
        Client client=new Client();
        FileFormatStrategy teststrategy=new CSVFileReaderStrategy();
        //StrategyContext sgc=new StrategyContext();
        client.read("data.csv","outputdata");
        assertEquals(client.fileFormatStrategy.getClass(),teststrategy.getClass());

    }

}
