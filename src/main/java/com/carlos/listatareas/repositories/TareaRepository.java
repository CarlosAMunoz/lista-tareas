package com.carlos.listatareas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.carlos.listatareas.models.TareaModel;


@Repository
public interface TareaRepository extends CrudRepository<TareaModel, Long>{
    
}
