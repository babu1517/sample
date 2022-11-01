package com.ezen.jpa.Repository;

import com.ezen.jpa.Entity.MyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface

MyRepository extends CrudRepository<MyEntity,Long> {
    @Override
    ArrayList<MyEntity> findAll();

}
