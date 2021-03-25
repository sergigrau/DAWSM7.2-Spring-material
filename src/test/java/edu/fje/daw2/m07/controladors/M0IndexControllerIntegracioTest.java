package edu.fje.daw2.m07.controladors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Controlador d'integració que realitza les peticions des de codi
 * l'atribut usuari del model
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 28.02.21
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(M0_IndexController.class)
public class M0IndexControllerIntegracioTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testSalutacioSenseNom() throws Exception {
        mvc.perform(get("/salutacio").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hola"))
                .andExpect(model().attribute("nom", is("sergi")));
    }
    @Test
    public void testSalutacioAmbNom() throws Exception {
        mvc.perform(get("/salutacio").param("nom", "sergi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hola"))
                .andExpect(model().attribute("nom", is("sergi")));
    }
}
