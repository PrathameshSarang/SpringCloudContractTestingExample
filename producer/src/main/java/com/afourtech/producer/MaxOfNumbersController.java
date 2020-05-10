package com.afourtech.producer;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MaxOfNumbersController {

    private final ProducerService service;

     public MaxOfNumbersController(ProducerService service) {
        this.service = service;
    }

    @PostMapping("/max-number")
    public ProducerResponse calculateMaxOfNumbers(@RequestBody final ProducerRequest req){
         return service.calculateMaxOfNumbers(req.getNumber1(),req.getNumber2(), req.getNumber3());
    }

    @GetMapping("/max-number")
    public @ResponseBody String provideInfoAboutAPI(){
        return "<HTML><body><h3> Use this API to get maximum of 3 numbers.</h3><br> Request body example: {\n" +
                "                \"number_one\" : 1,\n" +
                "                \"number_two\" : 2,\n" +
                "                \"number_three\" : 3\n" +
                "            } " +
                "<br> Response body example: {\n" +
                "                \"maxNumber\" : \"3\" \n" +
                "            }";
    }

}
