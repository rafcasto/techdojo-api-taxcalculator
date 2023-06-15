package org.tax.calculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tax.calculator.components.TaxBracketComponent;
import org.tax.calculator.controllers.exceptions.BadRequestException;
import org.tax.calculator.models.TaxBracket;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaxBracketController
{
    @Autowired
    private TaxBracketComponent taxBracketComponent;


    @GetMapping("/taxBrackets")
    List<TaxBracket> getAllTaxBrackets(){
        return taxBracketComponent.getTaxBrackets();
    }

    @GetMapping("/taxBrackets/{income}")
    TaxBracket findBracket(@PathVariable double income){
        if(income < 0){
            throw new BadRequestException("Income most be positive value");
        }
        return taxBracketComponent.findTaxBracketBasedOn(income);
    }
}
