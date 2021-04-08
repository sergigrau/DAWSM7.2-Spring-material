package edu.fje.daw2.m07.repositoris;

import edu.fje.daw2.m07.model.Usuari;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface M7_JPAUsuariRepository extends CrudRepository<Usuari, Long> {
}

