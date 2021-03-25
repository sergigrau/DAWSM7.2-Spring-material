package edu.fje.daw2.m07.controladors;

import edu.fje.daw2.m07.model.Alumne;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Controlador principal del projecte basat en REST
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 04.03.21
 */
@RestController
public class M3_AlumneRestController {

    Set<Alumne> alumnes = new HashSet<>();

    @PostMapping("/RESTafegirAlumne")
    public Alumne afegirAlumne(
            @RequestParam String nom,
            @RequestParam(defaultValue = "0", required = false) int nota,
            Model model) {
        Alumne a = new Alumne(nom, nota);
        alumnes.add(a);
        model.addAttribute("alumnes", alumnes);
        return a;
    }

    @DeleteMapping("/RESTesborrarAlumne")
    public Alumne esborrarAlumne(
            @RequestParam String nom,
            @RequestParam(defaultValue = "0", required = false) int nota,
            Model model) {
        Alumne a = new Alumne(nom, nota);
        alumnes.remove(a);
        model.addAttribute("alumnes", alumnes);
        return a;
    }
    @PutMapping("/RESTmodificarAlumne")
    public Alumne modificarAlumne(
            @RequestParam String nom,
            @RequestParam(defaultValue = "0", required = false) int nota,
            Model model) {
        Alumne a = new Alumne(nom, nota);
        alumnes.remove(a);
        alumnes.add(a);
        model.addAttribute("alumnes", alumnes);
        return a;
    }

    @GetMapping("/RESTllistarAlumnes")
    public Set<Alumne> llistarAlumnes(Model model){
        model.addAttribute("alumnes", alumnes);
        return alumnes;
    }
}
