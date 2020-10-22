package com.example.skillcatchupsep.api.service;
import com.example.skillcatchupsep.api.SseEntity;
import com.example.skillcatchupsep.api.repository.SseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class SseService {

        @Autowired
        SseRepository sseRepository;


        public List<SseEntity> findAll(){
            return sseRepository.findAll();
        }

        public void deleteAll(){
            sseRepository.deleteAll();
        }

        public void create(SseEntity sseEntity){
            sseRepository.create(sseEntity);
        }
    }