package org.tax.calculator.components;

import org.tax.calculator.models.CalculateTaxRequest;
import org.tax.calculator.models.CalculateTaxResponse;

public interface TaxCalculatorComponent
{
    CalculateTaxResponse calculateTax(CalculateTaxRequest request);
}
