package com.carlos.listatareas.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TareaDto {

    private Long id;
    private String title; 
    private String description;
    private String date;
}

