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

    public List<Usuari> trobarTots() {
        var it = ur.findAll();
        var usuaris = new ArrayList<Usuari>();
        it.forEach(usuaris::add); //equivalent a it.forEach(e -> usuaris.add(e));
        return usuaris;
    }

    public Long comptar() {
        return ur.count();
    }

    public void modificarPerId(Long UsuariId) {
        ur.deleteById(UsuariId);
    }

    public Usuari trobarPerId(Long id){
       return ur.findById(id).get();
    }

    public void afegirUsuari(String nom, String cognom, String email){
        var u1 = new Usuari(nom, cognom, email);
        ur.save(u1);
    }
    public void afegirUsuari(Usuari u){
        ur.save(u);
    }

}