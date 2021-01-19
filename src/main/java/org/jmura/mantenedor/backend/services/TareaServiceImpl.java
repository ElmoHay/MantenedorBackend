package org.jmura.mantenedor.backend.services;

import org.jmura.mantenedor.backend.models.Tarea;
import org.jmura.mantenedor.backend.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService{
    TareaRepository tareaRepository;

    @Autowired
    public TareaServiceImpl(TareaRepository tareaRepository)
    {
        this.tareaRepository=tareaRepository;
    }

    @Override
    public List<Tarea> getAll()
    {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea get(Long identificador) throws Exception
    {
        Optional<Tarea> tareaOptional = tareaRepository.findById(identificador);
        if (!tareaOptional.isPresent()) {
            throw new Exception("Tarea con el id "+identificador+" no encontrada");
        }
        return tareaOptional.get();
    }

    @Override
    public Tarea create(Tarea tarea)
    {
        return this.tareaRepository.save(tarea);
    }

    @Override
    public Tarea update(Long identificador, Tarea tarea)
    {
        Tarea aActualizar = tareaRepository.findById(identificador).get();

        aActualizar.setDescripcion(tarea.getDescripcion());
        aActualizar.setFechaCreacion(tarea.getFechaCreacion());
        aActualizar.setVigente(tarea.getVigente());

        return tareaRepository.save(aActualizar);
    }
    @Override
    public String delete(Long identificador)
    {
        tareaRepository.deleteById(identificador);
        return "Se borró la tarea con identificador "+identificador;
    }
}
