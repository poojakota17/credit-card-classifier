package com.creditcardclassification.project;

import com.creditcardclassification.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DiscoverCardCheckerAndObjectCreatorTests {

    @DisplayName("Should return  card type and create object of class Discover")
    @ParameterizedTest
    @ValueSource(strings = {"6011000000000000","6011340000000000","6011000000000067"})
    public void DiscoverCardCheckerAndObjectCreatorTest(String input) {
        String result = "";
        //Handler visacardHandler = new VisaCCCheckHandler(null);
        Handler discoverhandler = new DiscoverCCCheckHandler(null);
        result = discoverhandler.checkCreditCard(input);
        Discover discover = new Discover();
        Assertions.assertEquals("Discover Card",result);
        Assertions.assertEquals(discover.getClass(),discoverhandler.cardCreator.returncardtype().getClass());
    }

}
