package com.afourtech.producer;

import org.springframework.stereotype.Component;

@Component
public class ProducerService {

    public ProducerResponse calculateMaxOfNumbers(int num1, int num2, int num3) {
        int maxNumber = -1;
        if (num1 >= num2 && num1 >= num3)
            maxNumber = num1;
        else if (num2 >= num1 && num2 >= num3)
            maxNumber = num2;
        else
            maxNumber = num3;
        return new ProducerResponse(maxNumber);
    }
}
