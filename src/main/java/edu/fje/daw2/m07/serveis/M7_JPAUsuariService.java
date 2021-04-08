package edu.fje.daw2.m07.serveis;

import edu.fje.daw2.m07.model.Usuari;
import edu.fje.daw2.m07.repositoris.M7_JPAUsuariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servei JPA, Aquesta és la classe de servei.
 * La classe proporciona tres mètodes per trobar tots els usuaris,
 * comptar usuaris i suprimir un usuari per identificador.
 *
 * @author sergi.grau@fje.edu
 * @version 1.0 08.04.21
 */

@Service
public class M7_JPAUsuariService {

    @Autowired
    private M7_JPAUsuariRepository ur;

    public List<Usuari> findAll() {
        var it = ur.findAll();
        var Usuaris = new ArrayList<Usuari>();
        it.forEach(e -> Usuaris.add(e));
        return Usuaris;
    }

    public Long count() {
        return ur.count();
    }

    public void deleteById(Long UsuariId) {
        ur.deleteById(UsuariId);
    }

    public void afegirUsuari(String nom, String cognom, String email){
        var u1 = new Usuari(nom, cognom, email);
        ur.save(u1);
    }
}