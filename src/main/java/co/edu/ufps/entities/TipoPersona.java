package co.edu.ufps.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
@Table(name="tipo_persona")
public class TipoPersona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descripcion;
	
	@OneToMany(mappedBy = "tipoPersona", cascade= CascadeType.ALL)
	@JsonIgnore
	List<Personal> personals;
	
	@ManyToMany
	@JoinTable(
			  name = "tipo_personal_funcion", 
			  joinColumns = @JoinColumn(name = "tipo_persona_id"), 
			  inverseJoinColumns = @JoinColumn(name = "funcion_id"))
    List<Funcion> funciones;
	
	
	public void addFuncion(Funcion funcion) {
		this.funciones.add(funcion);
	}
	
	public void removeFuncion(Funcion funcion) {
		this.funciones.remove(funcion);
	}

}

