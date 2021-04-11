package edu.fje.daw2.m07.controladors;

import edu.fje.daw2.m07.model.Alumne;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador principal del projecte
 * Implementa una etiqueta personalizada amb ThymeLeaf.
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 24.02.21
 */
@Controller
public class M6_EtiquetaPersonalitzadaController {
    @GetMapping("/etiqueta")
    public String salutar(
            @RequestParam(defaultValue = "sergi", required = false) String nom,
            Model model) {
        Alumne alumne= new Alumne("sergi", 8);
        model.addAttribute("alumne", alumne);

        return "etiqueta";
    }
}
