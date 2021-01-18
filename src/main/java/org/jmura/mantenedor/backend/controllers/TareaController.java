package org.jmura.mantenedor.backend.controllers;

import org.jmura.mantenedor.backend.models.Tarea;
import org.jmura.mantenedor.backend.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tareas")
public class TareaController {
    TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService) { this.tareaService=tareaService;}

    @GetMapping(path = "all")
    public @ResponseBody Iterable<Tarea> getAllTareas(){ return tareaService.getAll();};
}
