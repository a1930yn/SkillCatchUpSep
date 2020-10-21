package com.example.skillcatchupsep.api.controller;

import com.example.skillcatchupsep.api.PrefixEntity;
import com.example.skillcatchupsep.api.SseEntity;
import com.example.skillcatchupsep.api.repository.PrefixRepository;
import com.example.skillcatchupsep.api.repository.SseRepository;
import com.example.skillcatchupsep.api.service.PrefixService;
import com.example.skillcatchupsep.api.service.SseService;
import jp.ac.aiit.pbl.QZQSMDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Date;
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
                emitter.send("/sse" + " @ " + qzqsmDecoder.decode(SseValues.get(1).getOriginaldata()));
                List <SseEntity> temp = sseService.deleteAll();

                // we could send more events
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return emitter;
    }
}
