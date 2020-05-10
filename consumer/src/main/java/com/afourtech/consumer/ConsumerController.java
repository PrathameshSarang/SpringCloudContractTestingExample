package com.afourtech.consumer;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;


    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/calculate-grade")
    public ConsumerResponse calculateStudentGrade(@RequestBody ConsumerRequest request) throws Exception {
        int sc1 = request.pcb_score;
        int sc2 = request.pcm_score;
        int sc3 = request.pcmit_score;

        // Call to dependent service
        ProducerResponse res = restTemplate.postForObject("http://localhost:8080//max-number", new ProducerRequest(sc1, sc2, sc3), ProducerResponse.class);
        if(StringUtils.isEmpty(res.getMaxNumber()))
            throw new Exception("Did not get a valid response");

        int maxScore = Integer.parseInt(res.getMaxNumber());

        // Logic for deciding grade
        if (maxScore >= 90) {
            return new ConsumerResponse(ConsumerResponse.Grade.O);
        } else if (maxScore >= 70)
            return new ConsumerResponse(ConsumerResponse.Grade.A);
        else
            return new ConsumerResponse(ConsumerResponse.Grade.B);
    }

}
