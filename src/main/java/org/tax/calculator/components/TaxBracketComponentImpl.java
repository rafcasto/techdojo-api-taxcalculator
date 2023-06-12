package org.tax.calculator.components;

import org.springframework.stereotype.Component;
import org.tax.calculator.models.TaxBracket;

import java.util.ArrayList;
import java.util.List;
@Component
public class TaxBracketComponentImpl implements TaxBracketComponent{

    private List<TaxBracket> taxBrackets;
    public TaxBracketComponentImpl(){
        initTaxBrackets();
    }

    @Override
    public List<TaxBracket> getTaxBrackets() {
        return taxBrackets;
    }

    @Override
    public TaxBracket findTaxBracketBasedOn(double income) {
        TaxBracket bracket = this.taxBrackets.stream().
                filter(taxBracket -> isTaxBracketMatch(taxBracket,income)
                        ).findFirst().orElse(null);

        return bracket;
    }

    private boolean isTaxBracketMatch(TaxBracket taxBracket,double income){
        if(taxBracket.getMaxIncomeBracket() < taxBracket.getMinIncomeBracket()){
            return income >= taxBracket.getMinIncomeBracket();
        }
       return (income >= taxBracket.getMinIncomeBracket() && income <= taxBracket.getMaxIncomeBracket());
       // return (income >= taxBracket.getMaxIncomeBracket() && income <= taxBracket.getMaxIncomeBracket());
    }

    private void initTaxBrackets(){
        this.taxBrackets = new ArrayList<TaxBracket>();
        taxBrackets.add(new TaxBracket(){{
            setMinIncomeBracket(0.0);
            setMaxIncomeBracket(14000.00);
            setTaxRate(10.5/100.00);
        }});
        taxBrackets.add(new TaxBracket(){{
            setMinIncomeBracket(14001.00);
            setMaxIncomeBracket(48000.00);
            setTaxRate(17.50/100.00);
        }});
        taxBrackets.add(new TaxBracket(){{
            setMinIncomeBracket(48001.00);
            setMaxIncomeBracket(70000.00);
            setTaxRate(30.00/100.00);
        }});
        taxBrackets.add(new TaxBracket(){{
            setMinIncomeBracket(70001.00);
            setMaxIncomeBracket(180000.00);
            setTaxRate(33.00/100.00);
        }});
        taxBrackets.add(new TaxBracket(){{
            setMinIncomeBracket(180001.00);
            setTaxRate(39.00/100.00);
        }});
    }
}
