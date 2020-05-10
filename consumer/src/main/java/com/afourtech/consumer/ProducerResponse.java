package com.afourtech.consumer;

public class ProducerResponse {

    public void setMaxNumber(String maxNumber) {
        this.maxNumber = maxNumber;
    }

    private String maxNumber;

    public ProducerResponse(){}
    public ProducerResponse(String maxNumber) {
        this.maxNumber = maxNumber;
    }

    public String getMaxNumber() {
        return maxNumber;
    }
}
