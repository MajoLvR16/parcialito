package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.entities.Funcion;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Integer> {
	
}
