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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "articulo")
public class Articulo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="cantidad")
	private int cantidad;
	
	@Column (name="denominacion")
	private String denominacion;
	
	@Column (name="precio")
	private int precio;
	
	//Relacion Articulo-DetalleFactura
	@OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
	private List<DetalleFactura> arts = new ArrayList<DetalleFactura>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable (name = "articulo_categoria",
				joinColumns = @JoinColumn(name ="articulo_id"),
				inverseJoinColumns = @JoinColumn(name ="categoria_id"))
	private List<Categoria> categs = new ArrayList<Categoria>();
	
	
	//Constructores y Getters and Setters

	//Cosntructores
	public Articulo() {
	}

	public Articulo(int cantidad, String denominacion, int precio) {
		this.cantidad = cantidad;
		this.denominacion = denominacion;
		this.precio = precio;
	}

	public Articulo(int cantidad, String denominacion, int precio, List<DetalleFactura> arts) {
		this.cantidad = cantidad;
		this.denominacion = denominacion;
		this.precio = precio;
		this.arts = arts;
	}

	public Articulo(int cantidad, String denominacion, int precio, List<DetalleFactura> arts, List<Categoria> categs) {
		super();
		this.cantidad = cantidad;
		this.denominacion = denominacion;
		this.precio = precio;
		this.arts = arts;
		this.categs = categs;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getArts() {
		return arts;
	}

	public void setArts(List<DetalleFactura> arts) {
		this.arts = arts;
	}

	public List<Categoria> getCategs() {
		return categs;
	}

	public void setCategs(List<Categoria> categs) {
		this.categs = categs;
	}

	//Metodo ToString
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", cantidad=" + cantidad + ", Denominacion=" + denominacion + ", precio=" + precio
				+ "]";
	}
}



