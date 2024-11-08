package co.edu.ufps.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Funcion;
import co.edu.ufps.entities.TipoPersona;
import co.edu.ufps.repositories.FuncionRepository;
import co.edu.ufps.repositories.TipoPersonaRepository;
@Service
public class TipoPersonaService {
	
	@Autowired
	public TipoPersonaRepository tipoPersonaRepository;
	@Autowired
	public FuncionRepository funcionRepository;
	
	public List<TipoPersona> list() {
		return tipoPersonaRepository.findAll();
	}
	
	public TipoPersona get(Integer id) {
		
		Optional<TipoPersona> tipoPersonaOpt =  tipoPersonaRepository.findById(id);
		
		if (tipoPersonaOpt.isPresent()) {
			return tipoPersonaOpt.get();
		}
		
		return null;
	}

	public TipoPersona delete(Integer id) {
		Optional<TipoPersona> tipoPersonaOpt =  tipoPersonaRepository.findById(id);
		
		if (tipoPersonaOpt.isPresent()) {
			
			TipoPersona tipoPersona = tipoPersonaOpt.get();
			tipoPersonaRepository.delete(tipoPersona);
			return tipoPersona;
		}
		
		return null;
	}

	public TipoPersona create(TipoPersona tipoPersona) {
		return tipoPersonaRepository.save(tipoPersona);
	}

	public TipoPersona update(Integer id, TipoPersona tipoPersona) {
		
		Optional<TipoPersona> tipoPersonaOpt =  tipoPersonaRepository.findById(id);
		
		if (tipoPersonaOpt.isPresent()) {
			
			TipoPersona tipoPersonaUpd = tipoPersonaOpt.get();
			tipoPersonaUpd.setDescripcion(tipoPersona.getDescripcion());
			tipoPersonaRepository.save(tipoPersonaUpd);
			
			return tipoPersonaUpd;
			
		}
		// TODO Auto-generated method stub
		return null;
	}

	public TipoPersona addFuncion(Integer id, Integer funcionId) {
		
		Optional<TipoPersona> tipoPersonaOpt =  tipoPersonaRepository.findById(id);
		
		if (tipoPersonaOpt.isPresent()) {
			
			TipoPersona tipoPersona = tipoPersonaOpt.get();

			Optional<Funcion> funcionOpt = funcionRepository.findById(funcionId);
			
			if (funcionOpt.isPresent()) {
				
				tipoPersona.addFuncion(funcionOpt.get());
				
			}

			return tipoPersonaRepository.save(tipoPersona);
		}
		
		return null;
	}

}