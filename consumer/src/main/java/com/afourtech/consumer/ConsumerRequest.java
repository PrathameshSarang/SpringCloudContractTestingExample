package com.afourtech.consumer;

public class ConsumerRequest {

    int pcb_score;
    int pcm_score;
    int pcmit_score;

    public ConsumerRequest(){}

    public ConsumerRequest(int pcb_score, int pcm_score, int pcmit_score){
        this.pcb_score = pcb_score;
        this.pcm_score = pcm_score;
        this.pcmit_score = pcmit_score;
    }

    public int getPcb_score() {
        return pcb_score;
    }

    public void setPcb_score(int pcb_score) {
        this.pcb_score = pcb_score;
    }

    public int getPcm_score() {
        return pcm_score;
    }

    public void setPcm_score(int pcm_score) {
        this.pcm_score = pcm_score;
    }

    public int getPcmit_score() {
        return pcmit_score;
    }

    public void setPcmit_score(int pcmit_score) {
        this.pcmit_score = pcmit_score;
    }

}
