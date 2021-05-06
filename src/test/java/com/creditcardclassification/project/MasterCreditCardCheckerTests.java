package com.creditcardclassification.project;

import com.creditcardclassification.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class MasterCreditCardCheckerTests {
    @DisplayName("Should return  card type and create object of class Mastercard")
    @ParameterizedTest
   @ValueSource(strings={"5410000000000000","5310000000000000","5510000000000000"})
    void MasterCreditCardCheckHandlerTest(String input){
        String result="";
        Handler mastercardHandler= new MasterCCCheckHandler(null);
        result=mastercardHandler.checkCreditCard(input);
        Master master=new Master();
        Assertions.assertEquals("Master card",result, "Error");
        Assertions.assertEquals(master.getClass(),mastercardHandler.cardCreator.returncardtype().getClass());
    }
}
