package com.example.skillcatchupsep.api.repository;

import com.example.skillcatchupsep.api.PrefixEntity;
import com.example.skillcatchupsep.api.SseEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Dao
@ConfigAutowireable
public interface SseRepository {
    @Select
    public List<SseEntity> findAll();

    @Select
    public List<SseEntity> deleteAll();

    @Insert
    @Transactional
    public int create(SseEntity entity);
}
