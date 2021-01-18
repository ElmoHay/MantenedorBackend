package org.jmura.mantenedor.backend.services;

import org.jmura.mantenedor.backend.models.Tarea;
import java.util.List;

public interface TareaService {
    List<Tarea> getAll();
    Tarea create(Tarea tarea);
    Tarea update(Long identificador, Tarea tarea);
    String delete(Long identificador);
}
