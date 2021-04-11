package edu.fje.daw2.m07.repositoris;

import edu.fje.daw2.m07.model.Aparcament;
import edu.fje.daw2.m07.model.Usuari;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface M8_JPAAparcamentRepository extends CrudRepository<Aparcament, Long> {
}

