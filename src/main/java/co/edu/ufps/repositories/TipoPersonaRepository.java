package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.entities.TipoPersona;

@Repository	
public interface TipoPersonaRepository extends JpaRepository<TipoPersona, Integer> {

}