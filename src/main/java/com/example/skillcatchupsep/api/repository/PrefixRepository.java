package com.example.skillcatchupsep.api.repository;

import com.example.skillcatchupsep.api.PrefixEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Dao
@ConfigAutowireable
public interface PrefixRepository {

    @Select
    public PrefixEntity findById(Integer prefixId);
    
    @Select
    public List<PrefixEntity> findAll();
    
    @Select
    public List<PrefixEntity> findTop30();

    @Insert
    @Transactional
    public int create(PrefixEntity entity);
}