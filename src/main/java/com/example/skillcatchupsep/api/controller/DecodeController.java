package com.example.skillcatchupsep.api.controller;
import com.example.skillcatchupsep.api.PrefixEntity;
import com.example.skillcatchupsep.api.SseEntity;
import com.example.skillcatchupsep.api.repository.PrefixRepository;
import com.example.skillcatchupsep.api.repository.SseRepository;
import com.example.skillcatchupsep.api.service.PrefixService;
import com.example.skillcatchupsep.api.service.SseService;
import jp.ac.aiit.pbl.QZQSMDecoder;
import jp.ac.aiit.pbl.disaster.Disaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecodeController {
    
    @Autowired
    PrefixService prefixService;
    @Autowired
    SseService sseService;
    
    @Autowired
    PrefixRepository prefixRepository;
    @Autowired
    SseRepository sseRepository;

    @GetMapping("/disaster")
    public Disaster decode(@RequestParam("qzqsmdata") String qzqsm){
        QZQSMDecoder qzqsmDecoder = new QZQSMDecoder();
        return qzqsmDecoder.decode(qzqsm);
    }
    @GetMapping("/prefix")
    public void register(@RequestParam("qzqsmdata") String qzqsm){
        QZQSMDecoder qzqsmDecoder = new QZQSMDecoder();
        Disaster disaster = qzqsmDecoder.decode(qzqsm);
        System.out.println(disaster.getDisasterPrefix().toString());
        prefixRepository.create(new PrefixEntity(disaster.getDisasterPrefix()));
    }
    @GetMapping("/ssenew")
    public void registerSse(@RequestParam("qzqsmdata") String qzqsm){
        QZQSMDecoder qzqsmDecoder = new QZQSMDecoder();
        Disaster disaster = qzqsmDecoder.decode(qzqsm);
        System.out.println(disaster.getDisasterPrefix().toString());
        sseRepository.create(new SseEntity(disaster.getDisasterPrefix(),qzqsm));
    }
}

