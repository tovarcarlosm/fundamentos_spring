package co.edu.eam.dao;

import co.edu.eam.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteDao extends CrudRepository<Estudiante, Long> {

}
