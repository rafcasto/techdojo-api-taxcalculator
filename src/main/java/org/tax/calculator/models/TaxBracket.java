package org.tax.calculator.models;

public class TaxBracket
{
    private double taxRate;
    private double minIncomeBracket;

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getMinIncomeBracket() {
        return minIncomeBracket;
    }

    public void setMinIncomeBracket(double minIncomeBracket) {
        this.minIncomeBracket = minIncomeBracket;
    }

    public double getMaxIncomeBracket() {
        return maxIncomeBracket;
    }

    public void setMaxIncomeBracket(double maxIncomeBracket) {
        this.maxIncomeBracket = maxIncomeBracket;
    }

    private double maxIncomeBracket;
}
