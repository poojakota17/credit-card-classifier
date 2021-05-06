package com.creditcardclassification.project;

import com.creditcardclassification.AmEx;
import com.creditcardclassification.AmexCCCheckHandler;
import com.creditcardclassification.Handler;
import com.creditcardclassification.VisaCCCheckHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

public class AmExCardCheckerAndObjectCreatorTests {

    @DisplayName("Should return  card type and create object of class AmEx")
    @ParameterizedTest
    @ValueSource(strings = {"37828224631000545","34828224631000545","37677224631000545"})
    public void amExCardCheckerAndObjectCreatorTest(String input) {
        String result = "";
        Handler amexcardhandler = new AmexCCCheckHandler(null);
        result = amexcardhandler.checkCreditCard(input);
        AmEx amEx = new AmEx();
        Assertions.assertEquals("American Express Card",result);
        Assertions.assertEquals(amEx.getClass(),amexcardhandler.cardCreator.returncardtype().getClass());
    }

}
