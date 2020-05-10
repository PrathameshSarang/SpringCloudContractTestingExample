package com.afourtech.producer;

public class ProducerResponse {
    private int max_Number;

    public ProducerResponse() {

    }

    public ProducerResponse(int max_Number) {
        this.max_Number = max_Number;
    }

    public int getMax_Number() {
        return max_Number;
    }

    public void setMax_Number(int max_Number) {

        this.max_Number = max_Number;
    }
}
