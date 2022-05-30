package com.mycompany.propertymanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") //class level mapping  of url to a controller class
public class CalculatorController {

     //http://localhost:8080/api/v1/calculator/add
     //http://localhost:8080/api/v1/calculator/add?num1=3.4&num2=3.7
     // http://localhost:8080/api/v1/calculator/add/99?num1=4.4&num2=3.7
    @GetMapping("/add/{num3}") //method level mapping of an url to controller function
    public Double add (@RequestParam("num1") Double num1, @RequestParam("num2") Double num2,
                       @PathVariable("num3") Double num3){
        return num1+num2+num3;

    }
    @GetMapping("/sub/{num111}/{num2}") //Map the values of url to java variables by path variable method
    public Double substract(@PathVariable("num111") Double num1, @PathVariable("num2") Double num2){
        Double result =null ;
        if(num1>num2){
            result = num1 - num2;
        }else{
            result = num2 - num1;
        }
        return result;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }

}
