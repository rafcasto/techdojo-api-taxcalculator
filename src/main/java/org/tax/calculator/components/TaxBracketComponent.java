package org.tax.calculator.components;

import org.tax.calculator.models.TaxBracket;

import java.util.List;


public interface TaxBracketComponent
{
    List<TaxBracket> getTaxBrackets();
    TaxBracket findTaxBracketBasedOn(double income);
}
