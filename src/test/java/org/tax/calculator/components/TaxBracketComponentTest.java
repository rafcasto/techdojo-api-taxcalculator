package org.tax.calculator.components;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TaxBracketComponentTest {
    @Autowired
    TaxBracketComponent taxBracketComponent;

    @Test
    void getTaxBrackets() {
        Assertions.assertNotNull(taxBracketComponent.getTaxBrackets());
    }

    @Test
    void findTaxBracketBasedOn() {
        double income = 14000;
        double expectedRate = 10.5/100.00;
        Assertions.assertEquals(expectedRate,taxBracketComponent.findTaxBracketBasedOn(income).getTaxRate());
    }

  /*  @Test
    void findTaxBracketBasedOnSecondBracket() {
        double income = 14001.00;
        double expectedRate = 17.50/100.00;
        Assertions.assertEquals(expectedRate,taxBracketComponent.findTaxBracketBasedOn(income).getTaxRate());
    }*/

    @Test
    void findMaxTaxBracketBasedOn() {
        double income = 180001;
        double expectedRate = 39.00/100.00;
        Assertions.assertEquals(expectedRate,taxBracketComponent.findTaxBracketBasedOn(income).getTaxRate());
    }
}