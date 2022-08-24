package co.edu.eam.service;

import co.edu.eam.domain.Estudiante;
import java.util.List;

public interface EstudianteService {

    public List<Estudiante> listar();
    public Estudiante buscar(Estudiante estudiante);
    public void guardar(Estudiante estudiante);
    public void eliminar(Estudiante estudiante);


}
