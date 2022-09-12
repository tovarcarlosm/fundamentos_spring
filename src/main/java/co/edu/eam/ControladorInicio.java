package co.edu.eam;

import co.edu.eam.dao.EstudianteDao;
import co.edu.eam.domain.Estudiante;
import co.edu.eam.service.EstudianteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/")
    public String mostrar(Model modelo, @AuthenticationPrincipal User user){
        var estudiantes = estudianteService.listar();
        log.info("Inició sesión el usuario: " + user);
        modelo.addAttribute("estudiantes", estudiantes);
        modelo.addAttribute("totalEstudiantes", estudiantes.size());
        return "index";
    }

    @GetMapping("/registrar")
    public String registrar(Estudiante estudiante){
        return "actualizar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Estudiante estudiante, Errors errors){
        if(errors.hasErrors()){
            return "redirect:/";
        }

        estudianteService.guardar(estudiante);
        return "redirect:/";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(Estudiante estudiante, Model model){
        estudiante = estudianteService.buscar(estudiante);
        model.addAttribute("estudiante", estudiante);
        return "actualizar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Estudiante estudiante){
        estudianteService.eliminar(estudiante);
        return "redirect:/";
    }
}
