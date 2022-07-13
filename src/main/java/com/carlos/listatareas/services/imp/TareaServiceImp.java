package com.carlos.listatareas.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.listatareas.dto.TareaDto;
import com.carlos.listatareas.dto.mapper.TareaMapper;
import com.carlos.listatareas.models.TareaModel;
import com.carlos.listatareas.repositories.TareaRepository;
import com.carlos.listatareas.services.ITareaService;

@Service
public class TareaServiceImp implements ITareaService{

    @Autowired
    TareaRepository tareaRepository;
    @Autowired
    TareaMapper tareasMapper;

    @Override
    public List<TareaDto> ListarTareas() {
        //Instanciamos un ArrayLisy de tipo Dto 
        List<TareaDto> tareaDtos = new ArrayList<>();
        //Guardamos en una variable tipo entidad, la respuesta de buscar todos desde el repository 
        List<TareaModel> tareas = (List<TareaModel>) tareaRepository.findAll();
        //Con mapper, pasamos el valor de tipo entidad a tipo Dto para retornar esa respuesta al cliente.
        tareaDtos = tareasMapper.modelToDtos(tareas);
        //Regresa ya transformado
        return tareaDtos;
    }

    @Override
    public TareaDto BuscarTarea(Long Id) {
        TareaDto tareaDto = new TareaDto();
        //Buscarmos si tiene un Id con el valor que solicitamos para cargárselo al Dto
        if(tareaRepository.findById(Id).isPresent()){
            tareaDto = tareasMapper.modelToDto(tareaRepository.findById(Id).get());
        }
        return tareaDto;
    }


    @Override
    public TareaDto GuardarTarea(TareaDto tareaDto) {
        

        return null;
    }

    @Override
    public void eliminarTarea() {
        
        
    }
    
}
