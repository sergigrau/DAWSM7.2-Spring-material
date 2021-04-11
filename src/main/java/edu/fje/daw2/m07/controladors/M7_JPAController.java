package edu.fje.daw2.m07.controladors;

import edu.fje.daw2.m07.model.Usuari;
import edu.fje.daw2.m07.serveis.M7_JPAUsuariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador principal del projecte
 * Implementa un senzill mapping GET, amb paràmetre opcional.
 * Ho fem servir per a la demo de JPA
 * Reducciona a la vista salutacio de ThymeLeaf
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 24.02.21
 */
@Controller
public class M7_JPAController {
    @Autowired
    private M7_JPAUsuariService us;

    @GetMapping("/llistarUsuaris")
    public String llistarUsuaris(Model model) {
        model.addAttribute("usuaris", us.trobarTots());
        return "llistarUsuaris";
    }

    @GetMapping("/nombreUsuaris")
    public Long comptarUsuaris() {
        return us.comptar();
    }

    @PostMapping("/esborrarUsuari")
    public String esborrarUsuari(
            @RequestParam String id,
            Model model) {

        Long idUsuari = Long.parseLong(id);
        us.modificarPerId(idUsuari);
        model.addAttribute("usuaris", us.trobarTots());
        return "llistarUsuaris";
    }

    @PostMapping("/afegirUsuari")
    public String afegirUsuari(
            @RequestParam String nom,
            @RequestParam String cognom,
            @RequestParam String email,

            Model model) {
        us.afegirUsuari(nom, cognom, email);
        model.addAttribute("usuaris", us.trobarTots());
        return "llistarUsuaris";
    }
    @PostMapping("/modificarUsuari")
    public String modificarUsuari(
            @RequestParam String id,
            @RequestParam String nom,
            @RequestParam String cognom,
            @RequestParam String email,
            Model model) {

        Long idUsuari = Long.parseLong(id);
        Usuari usuari = us.trobarPerId(idUsuari);
        usuari.setNom(nom);
        usuari.setCognom(cognom);
        usuari.setEmail(email);
        us.afegirUsuari(usuari);
        model.addAttribute("usuaris", us.trobarTots());
        return "llistarUsuaris";
    }
}
