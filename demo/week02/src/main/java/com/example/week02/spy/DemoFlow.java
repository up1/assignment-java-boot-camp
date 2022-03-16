package com.example.week02.spy;

public class DemoFlow {

    NotiService notiService;

    public DemoFlow(NotiService notiService) {
        this.notiService = notiService;
    }

    public void process() {
        notiService.send();
        notiService.send();
    }
}


class NotiService {
    void send(){
        throw new RuntimeException();
    }
}
