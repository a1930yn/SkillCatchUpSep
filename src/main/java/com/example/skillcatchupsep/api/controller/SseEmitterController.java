package com.example.skillcatchupsep.api.controller;

import com.example.skillcatchupsep.api.SseEntity;
import com.example.skillcatchupsep.api.repository.SseRepository;
import com.example.skillcatchupsep.api.service.SseService;
import jp.ac.aiit.pbl.QZQSMDecoder;
import jp.ac.aiit.pbl.disaster.Disaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class SseEmitterController {
    private ExecutorService nonBlockingService = Executors
            .newCachedThreadPool();

    @Autowired
    SseService sseService;

    @Autowired
    SseRepository sseRepository;

    @GetMapping("/sse")
    public SseEmitter handleSse() {
        SseEmitter emitter = new SseEmitter();
        nonBlockingService.execute(() -> {
            try {
                QZQSMDecoder qzqsmDecoder = new QZQSMDecoder();
                List<SseEntity> SseValues = sseService.findAll();
                List<Disaster> disasters = new ArrayList<>();
                if((SseValues.size() !=0 )) {
                    for(int i=0; i < SseValues.size();i++){
                        disasters.add(qzqsmDecoder.decode(SseValues.get(i).getOriginaldata()));
                    }
                    System.out.println("SSevalues:" + SseValues.size());
                    System.out.println(disasters);
                    emitter.send(disasters);
                    //sseService.deleteAll();
                }
                // we could send more events
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return emitter;
    }
}