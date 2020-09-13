package com.example.skillcatchupsep.api.controller;
import jp.ac.aiit.pbl.QZQSMDecoder;
import jp.ac.aiit.pbl.disaster.Disaster;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecodeController {
    @GetMapping("/disaster")
    public Disaster decode(@RequestParam("qzqsmdata") String qzqsm){
        QZQSMDecoder qzqsmDecoder = new QZQSMDecoder();
        return qzqsmDecoder.decode(qzqsm);
    }
}
