package org.tax.calculator.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tax.calculator.components.TaxCalculatorComponent;
import org.tax.calculator.models.CalculateTaxRequest;
import org.tax.calculator.models.CalculateTaxResponse;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TaxCalculatorController
{
    @Autowired
    TaxCalculatorComponent taxCalculatorComponent;

    @PostMapping ("/calculateTax")
    CalculateTaxResponse calculateTax(@RequestBody CalculateTaxRequest request){
        return taxCalculatorComponent.calculateTax(request);
    }
}
