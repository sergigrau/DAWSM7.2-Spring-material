package edu.fje.daw2.m07.controladors;

import edu.fje.daw2.m07.model.Salutacio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
/**
 * Controlador que fa us de REST
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 04.03.21
 */
@RestController
public class M2_IndexRestController {
    @GetMapping("/RESTsalutacio")
    public Salutacio salutar(@RequestParam(required = false, defaultValue = "daw2") String nom){
        return new Salutacio(MessageFormat.format("hola {0}", nom));
    }
}
