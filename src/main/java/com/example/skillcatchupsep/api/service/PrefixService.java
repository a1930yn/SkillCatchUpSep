package com.example.skillcatchupsep.api.service;

import com.example.skillcatchupsep.api.PrefixEntity;
import com.example.skillcatchupsep.api.repository.PrefixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrefixService {

    @Autowired
    PrefixRepository prefixRepository;


    public List<PrefixEntity> findAll(){
        return prefixRepository.findAll();
    }

    public List<PrefixEntity> findTop30(){
        return prefixRepository.findTop30();
    }

    public void create(PrefixEntity prefixEntity){
        prefixRepository.create(prefixEntity);
    }
}
