package org.jmura.mantenedor.backend.repositories;

import org.jmura.mantenedor.backend.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

}
