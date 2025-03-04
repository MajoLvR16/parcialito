package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Personal;
import co.edu.ufps.repositories.PersonalRepository;
import co.edu.ufps.services.PersonalService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/*
@RestController
@RequestMapping("/personals")
public class PersonalController {
	
	@Autowired
	public PersonalService personalService;
	@Autowired
	public PersonalRepository personalRepository;
	
	@GetMapping()
	public List<Personal> list() {
		return personalService.list();
	}

	
//	buscar en el personal por id (GET-> obtener)
	@GetMapping("/{id}")
	public Personal getListar1(@PathVariable Integer id) {
		
		return personalRepository.findById(id).orElseThrow(() -> 
		new RuntimeException("Personal no encontrado con el id: "+ id));
	}
	
//	actualizar, crea un nuevo registro (POST)
	@PostMapping("/crear")
	public Personal postPersonal(@RequestBody Personal personal) {
		return personalRepository.save(personal);
	}
	
	// Modificar (actualizar un Personal existente)
    @PutMapping("/{id}")
    public Personal update(@PathVariable Integer id, @RequestBody Personal updatedPersonal) {
        return personalRepository.findById(id)
                .map(personal -> {
                    personal.setDocumento(updatedPersonal.getDocumento());
                    personal.setNombre(updatedPersonal.getNombre());
                    personal.setEmail(updatedPersonal.getEmail());
                    personal.setTelefono(updatedPersonal.getTelefono());
                    return personalRepository.save(personal);
                }).orElseThrow(() -> new RuntimeException("Personal no encontrado con el id: " + id));
    }
	
    @DeleteMapping("/{id}")
    public String deletePersonal(@PathVariable Integer id) {
        // Verificar si el objeto Personal existe
        Personal personal = personalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Personal no encontrado con el id: " + id));

        // Eliminar el objeto si existe
        personalRepository.delete(personal);

        // Devolver un mensaje de confirmación
        return "Personal con ID " + id + " fue eliminado exitosamente";
    }
}
*/

@RestController
@RequestMapping("/personals")
public class PersonalController {
	
	@Autowired
	public PersonalService personalService;
	
	@GetMapping()
	public List<Personal> list() {
		return personalService.list();
	}
	
	@PostMapping()
	public Personal create(@RequestBody Personal personal) {
		
		Personal nuevaPersonal = personalService.create(personal);
		return nuevaPersonal;
	}
	
	@PutMapping("/{id}")
	public Personal update(@PathVariable Integer id, @RequestBody Personal personal) {
		return personalService.update(id, personal);
	}
	
	@GetMapping("/{id}")
	public Personal get(@PathVariable Integer id) {
		return personalService.get(id);
	}
	
	@DeleteMapping("/{id}")
	public Personal delete(@PathVariable Integer id) {
		return personalService.delete(id);
	}

}