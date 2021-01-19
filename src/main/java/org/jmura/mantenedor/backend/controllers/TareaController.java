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

    TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService) { this.tareaService=tareaService; }

    @GetMapping(path = "listar")
    public @ResponseBody List<Tarea> getAllTareas(){ return tareaService.getAll();}

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Tarea tarea)
    {
        tareaService.create(tarea);
        return new ResponseEntity<String>("tarea guardada exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<Tarea> get(@PathVariable(value = "identificador") Long id) throws Exception {
        return new ResponseEntity<>(tareaService.get(id),HttpStatus.FOUND);
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
