package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="denominacion")
	private String denominacion;
	
	
	@ManyToMany (mappedBy = "categs")
	private List<Articulo> articulos = new ArrayList<Articulo>();
		
	//Constructores y Getters and Setters
	
	//Constructores
	public Categoria() {
	}

	public Categoria(String categoria) {
		this.denominacion = categoria;
	}

	public Categoria(String denominacion, List<Articulo> articulos) {
		this.denominacion = denominacion;
		this.articulos = articulos;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return denominacion;
	}

	public void setCategoria(String categoria) {
		this.denominacion = categoria;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	//Metodo ToString
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", categoria=" + denominacion + "]";
	}
}
