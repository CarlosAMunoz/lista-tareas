package com.carlos.listatareas.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.carlos.listatareas.models.TareaModel;


@Repository
@Transactional
public interface TareaRepository extends CrudRepository<TareaModel, Long>{
    //Acá se puede sobre cargar con maás consultas SQL
}

