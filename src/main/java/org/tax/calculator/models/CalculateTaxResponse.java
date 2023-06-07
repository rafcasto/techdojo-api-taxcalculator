package org.tax.calculator.models;

public class CalculateTaxResponse
{
    public double getOwningTax() {
        return owningTax;
    }

    public void setOwningTax(double owningTax) {
        this.owningTax = owningTax;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    private double owningTax;
    private double taxRate;
}
