package org.jmura.mantenedor.backend.services;

import org.jmura.mantenedor.backend.models.Tarea;
import org.jmura.mantenedor.backend.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService {
    TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository)
    {
        this.tareaRepository=tareaRepository;
    }

    public Iterable<Tarea> getAll()
    {
        return tareaRepository.findAll();
    }
}
