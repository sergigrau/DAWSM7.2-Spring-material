package edu.fje.daw2.m07.controladors;

import edu.fje.daw2.m07.model.Alumne;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

/**
 * Controlador principal del projecte
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 24.02.21
 */
@Controller
public class M1_AlumneController {

    Set<Alumne> alumnes = new HashSet<>();

    @PostMapping("/afegirAlumne")
    public String afegirAlumne(
                        @RequestParam String nom,
                        @RequestParam(defaultValue = "0", required = false) int nota,
                        Model model) {
        alumnes.add(new Alumne(nom, nota));
        model.addAttribute("alumnes", alumnes);
        return "llistarAlumnes";
    }

    @PostMapping("/esborrarAlumne")
    public String esborrarAlumne(
            @RequestParam String nom,
            @RequestParam(defaultValue = "0", required = false) int nota,
            Model model) {
        alumnes.remove(new Alumne(nom, nota));
        model.addAttribute("alumnes", alumnes);
        return "llistarAlumnes";
    }
    @PostMapping("/modificarAlumne")
    public String modificarAlumne(
            @RequestParam String nom,
            @RequestParam(defaultValue = "0", required = false) int nota,
            Model model) {
        alumnes.remove(new Alumne(nom, nota));
        alumnes.add(new Alumne(nom, nota));
        model.addAttribute("alumnes", alumnes);
        return "llistarAlumnes";
    }

    @GetMapping("/llistarAlumnes")
    public String llistarAlumnes(Model model){
        model.addAttribute("alumnes", alumnes);
        return "llistarAlumnes";
    }
}
