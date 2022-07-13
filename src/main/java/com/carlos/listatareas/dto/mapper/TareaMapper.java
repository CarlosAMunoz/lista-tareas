package com.carlos.listatareas.dto.mapper;
import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.carlos.listatareas.dto.TareaDto;
import com.carlos.listatareas.models.TareaModel;



@Mapper(componentModel = "spring")
public interface TareaMapper {
    TareaMapper MAPPER = Mappers.getMapper(TareaMapper.class);
    
    //Transforma de modelo a un Dto
    TareaDto modelToDto(TareaModel tareaModel);
    
    //Transforma de dtp a un modelo 
    @InheritInverseConfiguration
    TareaModel dtoToModel(TareaDto tareaDto);


    //Método para sar de modelos a Dtos, recibe tareas de tipo Modelo y retorna Tareas de tipo dtos. 
    List<TareaDto> modelToDtos(List<TareaModel> tareas);

}
