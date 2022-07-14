package com.carlos.listatareas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
