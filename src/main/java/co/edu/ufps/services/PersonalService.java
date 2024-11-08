package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Personal;
import co.edu.ufps.repositories.PersonalRepository;
@Service
public class PersonalService {
	
	@Autowired
	public PersonalRepository personalRepository;

	public List<Personal> list() {
		return personalRepository.findAll();
	}
	
	public Personal create(Personal personal) {
		return personalRepository.save(personal);
	}
	
	public Personal update(Integer id, Personal personal) {
		
		Optional<Personal> personalOpt =  personalRepository.findById(id);
		
		if (personalOpt.isPresent()) {
			
			Personal personalUpd = personalOpt.get();
			
			BeanUtils.copyProperties(personal, personalUpd);
			
			personalRepository.save(personalUpd);
			
			return personalUpd;
			
		}

		return null;
	}
	
public Personal get(Integer id) {
		
		Optional<Personal> personalOpt =  personalRepository.findById(id);
		
		if (personalOpt.isPresent()) {
			return personalOpt.get();
		}
		
		return null;
	}

	public Personal delete(Integer id) {
		Optional<Personal> personalOpt =  personalRepository.findById(id);
		
		if (personalOpt.isPresent()) {
			
			Personal personal = personalOpt.get();
			personalRepository.delete(personal);
			return personal;
		}
		
		return null;
	}
	
}