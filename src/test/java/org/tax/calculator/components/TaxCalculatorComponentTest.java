package org.tax.calculator.components;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tax.calculator.models.CalculateTaxRequest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TaxCalculatorComponentTest {

    @Autowired
    TaxCalculatorComponent taxCalculatorComponent;


    @Test
    void calculateTax() {
        double income = 14000;
        double expectedTax =income *(10.5/100.00) ;
        Assertions.assertEquals(expectedTax,taxCalculatorComponent.calculateTax(new CalculateTaxRequest(){{
            setIncome(income);
        }}).getOwningTax());

        Assertions.assertEquals(10.5,taxCalculatorComponent.calculateTax(new CalculateTaxRequest(){{
            setIncome(income);
        }}).getTaxRate());
    }
}