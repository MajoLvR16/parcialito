package co.edu.ufps.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Personal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String documento;
	
	private String nombre;
	
	private String email;
	
	private String telefono;
	
	
	@ManyToOne
	@JoinColumn(name = "tipo_personal_id")
	private TipoPersona tipoPersona;
}


