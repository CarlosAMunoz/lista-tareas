package com.carlos.listatareas.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tarea")
public class TareaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;
    @Column(nullable = false)
    private String Title; 
    @Column(nullable = false)
    private String Description;
    private String Date;
}
