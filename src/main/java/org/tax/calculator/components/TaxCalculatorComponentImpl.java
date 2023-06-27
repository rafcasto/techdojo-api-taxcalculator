package org.tax.calculator.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tax.calculator.controllers.exceptions.BadRequestException;
import org.tax.calculator.models.CalculateTaxRequest;
import org.tax.calculator.models.CalculateTaxResponse;
import org.tax.calculator.models.TaxBracket;

@Component
public class TaxCalculatorComponentImpl implements TaxCalculatorComponent{

    @Autowired
    TaxBracketComponent taxBracketComponent;
    @Override
    public CalculateTaxResponse calculateTax(CalculateTaxRequest request) {
        TaxBracket bracket = taxBracketComponent.findTaxBracketBasedOn(request.getIncome());
        if(request.getIncome() <=0 ){
            throw new BadRequestException("Income needs to be a positive number and greater than 0");
        }
        return new CalculateTaxResponse(){{
            setOwningTax(round(request.getIncome()*bracket.getTaxRate()));
            setTaxRate(bracket.getTaxRate()*100);
        }};
    }

    private double round(double taxToPay)
    {
        return  Math.round(taxToPay * 100.0) / 100.0;
    }
}
