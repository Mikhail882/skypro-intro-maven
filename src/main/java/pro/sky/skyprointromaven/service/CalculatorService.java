package pro.sky.skyprointromaven.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprointromaven.exception.DivideByZeroException;

@Service
public class CalculatorService {

    public String greetings(){
        return "Добро пожаловать в калькулятор";
    }
    public Integer plus(Integer a, Integer b){
        return a + b;
    }

    public Integer minus(Integer a, Integer b){
        return a - b;
    }

    public Integer multiply(Integer a, Integer b){
        return a * b;
    }

    public Number devide(Integer a, Integer b) {
        if (b == 0) {
            throw new DivideByZeroException("Делить на 0 нельзя!");
        }
        return a.doubleValue() / b;
    }
}
