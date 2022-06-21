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
    public String plus(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        if(Objects.isNull(a) || Objects.isNull(b)) {
            return "Не правильно переданы параметры!";
        }
        return buildString(a,b, calculatorService.plus(a,b), "+");
    }


    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        if(Objects.isNull(a)||Objects.isNull(b)){
            return "Не правильно переданы параметры!";
        }
        return buildString(a,b, calculatorService.minus(a,b), "-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        if(Objects.isNull(a)||Objects.isNull(b)){
            return "Не правильно переданы параметры!";
        }return buildString(a, b, calculatorService.multiply(a, b), "*");
    }

    @GetMapping("/devide")
    public String devide(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        if(Objects.isNull(a)||Objects.isNull(b)){
            return "Не правильно переданы параметры!";
        }if (b == 0) {
            return "На ноль делить нельзя!";
        }
        return buildString(a, b, calculatorService.devide(a,b), "/");
        }

        private String buildString(float a, float b, float result, String operation){
        return String.format("%.1f %s %.1f = %.1f", a, operation, b, result);
        }

    }


