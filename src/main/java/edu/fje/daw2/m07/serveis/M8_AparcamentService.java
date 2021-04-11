package edu.fje.daw2.m07.serveis;

import edu.fje.daw2.m07.model.Aparcament;
import edu.fje.daw2.m07.repositoris.M8_JPAAparcamentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sergi grau
 */
public class M8_AparcamentService {

    @Autowired
    private M8_JPAAparcamentRepository ar;

    public Aparcament crearAparcament(String ubicacio) {
        Aparcament ap = new Aparcament();
        ap.setUbicacio(ubicacio);
        ar.save(ap);
        return ap;
    }

    public void esborrarAparcament(Long id) {
        ar.deleteById(id);
    }

    public Aparcament trobarAparcament(Long id) {
        return ar.findById(id).get(); //necessitem get() donat que retorna un Optional
    }

    public List<Aparcament> trobarTotsAparcaments() {

        var it = ar.findAll();
        var apartaments = new ArrayList<Aparcament>();
        it.forEach(apartaments::add);
        return apartaments;
    }
}
