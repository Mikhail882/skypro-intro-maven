package pro.sky.skyprointromaven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprointromaven.service.CalculatorService;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return calculatorService.greetings();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2", required = false) Integer b) {
        if(Objects.isNull(a) || Objects.isNull(b)) {
            return "Оба параметра должны быть переданы!";
        }
        return buildString(a,b, calculatorService.plus(a, b), "+");
    }


    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a,
                        @RequestParam(value = "num2", required = false) Integer b) {
        if(Objects.isNull(a)||Objects.isNull(b)){
            return "Оба параметра должны быть переданы!";
        }
        return buildString(a,b, calculatorService.minus(a, b), "-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a,
                           @RequestParam(value = "num2", required = false) Integer b) {
        if(Objects.isNull(a)||Objects.isNull(b)){
            return "Оба параметра должны быть переданы!";
        }return buildString(a, b, calculatorService.multiply(a, b), "*");
    }

    @GetMapping("/devide")
    public String devide(@RequestParam(value = "num1", required = false) Integer a,
                         @RequestParam(value = "num2", required = false) Integer b) {
        if(Objects.isNull(a)||Objects.isNull(b)){
            return "Оба параметра должны быть переданы!";
        }
        return buildString(a, b, (int) calculatorService.devide(a, b), "/");
        }

        private String buildString(Integer a, Integer b, Integer result, String operation){
        return String.format("%s %s %s = %s", a, operation, b, result);
        }

    }


