package com.carlos.listatareas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.listatareas.dto.TareaDto;
import com.carlos.listatareas.services.ITareaService;

@RestController
public class TareaController {
    
    Object response;

    @Autowired
    ITareaService tareaService;

    @GetMapping(path = "tareas")
    public Object buscarTodos(){
        response = tareaService.listarTareas();
        return response; 
    }

    @GetMapping(path = "tareasporid/{id}")
    public Object buscarPorId(@PathVariable("id") long id){
        response = tareaService.buscarTarea(id);
        return response;
    }

    @PostMapping(path = "nuevo")
    public Object guardar(@RequestBody TareaDto tareaDto){
        response = tareaService.guardarTarea(tareaDto);
        return response;
    }

    @DeleteMapping(path = "eliminar/{id}")
    public void eliminar(@PathVariable("id") long id){
        tareaService.eliminarTarea(id);
        
    }
}
