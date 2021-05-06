package com.creditcardclassification.project;

import com.creditcardclassification.ErrorCCHandler;
import com.creditcardclassification.Handler;
import com.creditcardclassification.Visa;
import com.creditcardclassification.VisaCCCheckHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InvalidCreditCardCheckerTests {
    @DisplayName("Should return invalid card type")
    @ParameterizedTest
    @ValueSource(strings= {" ","341000000000000","abc"})
    void InvalidCardCheckerTests(String input){
        String result="";
        Handler errorcarddHandler= new ErrorCCHandler(null);
        result=errorcarddHandler.checkCreditCard(input);
        Assertions.assertEquals("Invalid Card",result, "Error");

    }

}
