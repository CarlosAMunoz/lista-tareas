package com.carlos.listatareas.services;

import java.util.List;
import com.carlos.listatareas.dto.TareaDto;


public interface ITareaService {
    List<TareaDto> listarTareas();
    TareaDto buscarTarea(Long Id);
    TareaDto guardarTarea(TareaDto tareaDto);
    void eliminarTarea(Long Id);
}
