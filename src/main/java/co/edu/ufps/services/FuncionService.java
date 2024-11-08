package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Funcion;
import co.edu.ufps.repositories.FuncionRepository;

@Service
public class FuncionService {
	
	@Autowired
	public FuncionRepository funcionRepository;
	
	public List<Funcion> list() {
		return funcionRepository.findAll();
	}
	
	public Funcion get(Integer id) {
		
		Optional<Funcion> funcionOpt =  funcionRepository.findById(id);
		
		if (funcionOpt.isPresent()) {
			return funcionOpt.get();
		}
		
		return null;
	}

	public Funcion delete(Integer id) {
		Optional<Funcion> funcionOpt =  funcionRepository.findById(id);
		
		if (funcionOpt.isPresent()) {
			
			Funcion funcion = funcionOpt.get();
			funcionRepository.delete(funcion);
			return funcion;
		}
		
		return null;
	}

	public Funcion create(Funcion funcion) {
		// TODO Auto-generated method stub
		return funcionRepository.save(funcion);
	}

	public Funcion update(Integer id, Funcion funcion) {
		// TODO Auto-generated method stub
		
		Optional<Funcion> funcionOpt =  funcionRepository.findById(id);
		
		if (funcionOpt.isPresent()) {
			
			Funcion funcionUpdate = funcionOpt.get();
			funcionUpdate.setDescripcion(funcion.getDescripcion());
			funcionRepository.save(funcionUpdate);
			return funcion;
		}
		
		return null;
	}

}

