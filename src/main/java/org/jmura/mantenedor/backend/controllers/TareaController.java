package org.jmura.mantenedor.backend.controllers;

import org.jmura.mantenedor.backend.models.Tarea;
import org.jmura.mantenedor.backend.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tareas")
public class TareaController {
    @Autowired
    TareaService tareaService;

    public TareaController() { }

    @GetMapping(path = "listar")
    public @ResponseBody List<Tarea> getAllTareas(){ return tareaService.getAll();}

    @PostMapping
    public ResponseEntity<Tarea> create(@RequestBody Tarea tarea)
    {
        Tarea tareaGuardada = tareaService.create(tarea);
        return new ResponseEntity<>(tareaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<Tarea> update(@PathVariable(value = "identificador") Long id, @RequestBody Tarea tarea)
    {
        Tarea tareaActualizada = tareaService.update(id, tarea);
        return new ResponseEntity<>(tareaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{identificador}")
    public @ResponseBody String delete(@PathVariable(value = "identificador") Long id)
    {
        return tareaService.delete(id);
    }

}
