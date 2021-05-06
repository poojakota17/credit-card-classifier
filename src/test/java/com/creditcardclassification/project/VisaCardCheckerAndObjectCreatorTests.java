package com.creditcardclassification.project;

import com.creditcardclassification.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VisaCardCheckerAndObjectCreatorTests {

    @ParameterizedTest
    @DisplayName("Should return  card type and create object of class Visa card")
    @ValueSource(strings={"4120000000000","4120000000000000","4324560000000"})
    void visaCardCheckerAndObjectCreatorTests(String input){
        String result="";
        Handler visacardHandler= new VisaCCCheckHandler(null);
        result=visacardHandler.checkCreditCard(input);
        Visa visa=new Visa();
        Assertions.assertEquals("Visa Card",result, "Error");
        Assertions.assertEquals(visa.getClass(),visacardHandler.cardCreator.returncardtype().getClass());
    }

}
