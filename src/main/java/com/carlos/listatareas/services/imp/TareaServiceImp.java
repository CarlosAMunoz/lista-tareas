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
    TareaMapper tareaMapper;

    @Override
    public List<TareaDto> listarTareas() {
        //Instanciamos un ArrayLisy de tipo Dto 
        List<TareaDto> tareaDtos = new ArrayList<>();
        //Guardamos en una variable tipo entidad, la respuesta de buscar todos desde el repository 
        List<TareaModel> tareas = (List<TareaModel>) tareaRepository.findAll();
        //Con mapper, pasamos el valor de tipo entidad a tipo Dto para retornar esa respuesta al cliente.
        tareaDtos = tareaMapper.modelToDtos(tareas);
        //Regresa ya transformado
        return tareaDtos;
    }

    @Override
    public TareaDto buscarTarea(Long Id) {
        TareaDto tareaDto = new TareaDto();
        //Buscarmos si tiene un Id con el valor que solicitamos para cargárselo al Dto
        if(tareaRepository.findById(Id).isPresent()){
            tareaDto = tareaMapper.modelToDto(tareaRepository.findById(Id).get());
        }else{
            // TO DO
            // throw new NoDataFoundException();
        }
        return tareaDto;
    }


    //El método recibe una tarea en formato Dto y guarda o edita
    @Override
    public TareaDto guardarTarea(TareaDto tareaDto) {
        //Realizamos una condicional para saber si trae un id diferente a 0 (cero quiere decir que será uno nuevo)
        if (tareaDto.getId() == 0) {
            TareaModel tarea = new TareaModel();
            //Guardamos lo que recibimos del Dto y lo transformamos a antidad. 
            tarea = tareaMapper.dtoToModel(tareaDto);

            //Este es el lugar exacto en donde con ayuda del método save de neustro Repository le enviamos a la base de datos el objeto en tipo entidad. 
            tarea = tareaRepository.save(tarea);
            tareaDto = tareaMapper.modelToDto(tarea);


        //En caso de que el campo Id sea diferente de 0, entonces vamos a editar un registro ya existente. 
        }else{
            //Acá no se instancia un nuevo objeto de tipo tarea.
            //Lo que hacemos es buscar por Id con ayuda de nuestro repository guardar ese objeto encontrado en nuestra variable de tipo modelo. 
            TareaModel tarea = tareaRepository.findById(tareaDto.getId()).get();

            tarea = tareaMapper.dtoToModel(tareaDto);
            tarea = tareaRepository.save(tarea);
            tareaDto = tareaMapper.modelToDto(tarea);
        }
        return tareaDto;
    }

    @Override
    public void eliminarTarea(Long Id) {
        tareaRepository.deleteById(Id);
    }
    
}
