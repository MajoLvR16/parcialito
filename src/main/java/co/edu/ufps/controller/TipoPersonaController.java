package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Funcion;
import co.edu.ufps.entities.Personal;
import co.edu.ufps.entities.TipoPersona;
import co.edu.ufps.repositories.PersonalRepository;
import co.edu.ufps.services.TipoPersonaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/tipo_personals")
public class TipoPersonaController {

	
	@Autowired
	public TipoPersonaService tipoPersonaService;
	
	@GetMapping()
	public List<TipoPersona> list() {
		return tipoPersonaService.list();
	}
	
	@GetMapping("/{id}")
	public TipoPersona get(@PathVariable Integer id) {
		return tipoPersonaService.get(id);
	}
	
	@GetMapping("/{id}/funcions")
	public List<Funcion> getFuncions(@PathVariable Integer id) {
		return tipoPersonaService.get(id).getFunciones();
	}
	
	@PostMapping()
	public TipoPersona create(@RequestBody TipoPersona tipoPersona) {
		
		TipoPersona nuevaTipoPersona = tipoPersonaService.create(tipoPersona);
		return nuevaTipoPersona;
	}
	
	@PostMapping("/{id}/add_funcions/{funcionId}")
	public TipoPersona addFunction(@PathVariable Integer id, @PathVariable Integer funcionId) {
		
		TipoPersona nuevaTipoPersona = tipoPersonaService.addFuncion(id, funcionId);
		return nuevaTipoPersona;
	}
	
	@PutMapping("/{id}")
	public TipoPersona update(@PathVariable Integer id, @RequestBody TipoPersona tipoPersona) {
		return tipoPersonaService.update(id, tipoPersona);
	}
	
	@DeleteMapping("/{id}")
	public TipoPersona delete(@PathVariable Integer id) {
		return tipoPersonaService.delete(id);
	}
	
}