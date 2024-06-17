package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="dni", unique = true)
	private int dni;
	
	//creamos el objeto domicilio para crear la vinculacion one to one
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_domicilio")
	private Domicilio domicilio;
	
	//Relacion Cliente-Factura
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facs = new ArrayList<Factura>();
		
	//Constructores y Get and Setter
	
	//Constructor Vacio
	public Cliente() {
	}

	//Constructor lleno
	public Cliente(String nombre, String apellido, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public Cliente(String nombre, String apellido, int dni, Domicilio domicilio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
	}

	//Generamos los Getters and setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	//Metodo ToString
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
}
