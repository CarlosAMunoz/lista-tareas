package com.carlos.listatareas.services;

import java.util.List;
import com.carlos.listatareas.dto.TareaDto;


public interface ITareaService {
    List<TareaDto> ListarTareas();
    TareaDto BuscarTarea(Long Id);
    TareaDto GuardarTarea(TareaDto tareaDto);
    void eliminarTarea();
}
