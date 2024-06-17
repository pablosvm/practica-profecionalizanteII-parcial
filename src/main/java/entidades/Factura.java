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
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="total")
	private int total;
	
	
	//Vinculacion ManyToOne
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	
	//Relacion
	
	@OneToMany(mappedBy="factura", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<DetalleFactura> detas = new ArrayList<DetalleFactura>();
	
	
	//Constructores y Geter and Seter

	//Constructores	
	public Factura() {
	}

	public Factura(String fecha, String numero, int total) {
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
	}

	public Factura(String fecha, String numero, int total, Cliente cliente) {
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
		this.cliente = cliente;
	}

	public Factura(String fecha, String numero, int total, Cliente cliente, List<DetalleFactura> detas) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
		this.cliente = cliente;
		this.detas = detas;
	}

	//Metodo ToSring	
	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", total=" + total + "]";
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetas() {
		return detas;
	}

	public void setDetas(List<DetalleFactura> detas) {
		this.detas = detas;
	}
	
}
