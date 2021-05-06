package com.creditcardclassification.project;

import com.creditcardclassification.CSVFileReaderStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVFileReaderStrategyTests {
    @Test
    @DisplayName(" CSV output string list c should be equal to output string list")
    void CSVFileReaderStrategyTest(){
        CSVFileReaderStrategy csvFileReaderStrategy=new CSVFileReaderStrategy();
        List<String[]> expected=new ArrayList<String[]>();
        csvFileReaderStrategy.readfile("data.csv","output");
        expected.add(new String[]{"CardNumber","CardIssuer"});
        expected.add(new String[]{"5410000000000000", "Master card"});
        expected.add(new String[]{"4120000000000", "Visa Card"});
        expected.add(new String[]{"341000000000000", "Invalid Card"});
        expected.add(new String[]{"6011000000000000", "Discover Card"});
        Object[] arrExpected = expected.toArray();
        Object[] arrActual=csvFileReaderStrategy.data.toArray();
        assertArrayEquals(arrExpected,arrActual);


    }
}
