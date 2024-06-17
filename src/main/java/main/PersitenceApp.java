package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;


public class PersitenceApp {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
						
			Factura factura1 = new Factura();
			
			factura1.setNumero("12");
			factura1.setFecha("17/06/2024");
			factura1.setTotal(15324);
			
			Domicilio domicilio1 = new Domicilio();
			
			domicilio1.setNombreCalle("San martin");
			domicilio1.setNumero(1092);
			
			Cliente cliente1 = new Cliente();
			
			cliente1.setNombre("Pablo");
			cliente1.setApellido("Luquez");
			cliente1.setDni(58974635);
			
			cliente1.setDomicilio(domicilio1);
			domicilio1.setCliente(cliente1);
			
			factura1.setCliente(cliente1);
			
			Categoria perecederos = new Categoria("perecederos");
			Categoria lacteos = new Categoria("lacteos");
			Categoria limpieza = new Categoria("limpieza");
			
			Articulo art1 = new Articulo(200, "Yogurt", 20);
			Articulo art2 = new Articulo(80, "detergente", 70);
			 
			art1.getCategs().add(lacteos);
			art1.getCategs().add(perecederos);
			lacteos.getArticulos().add(art1);
			perecederos.getArticulos().add(art1);
			
			art2.getCategs().add(limpieza);
			limpieza.getArticulos().add(art2);
			
			DetalleFactura detalle1 = new DetalleFactura();
			
			detalle1.setArticulo(art1);
			detalle1.setCantidad(2);
			detalle1.setSubtotal(40);
			
			art1.getArts().add(detalle1);
			factura1.getDetas().add(detalle1);
			detalle1.setFactura(factura1);
			
			DetalleFactura detalle2 = new DetalleFactura();
			
			detalle2.setArticulo(art2);
			detalle2.setCantidad(1);
			detalle2.setSubtotal(80);
			
			art2.getArts().add(detalle2);
			factura1.getDetas().add(detalle1);
			detalle1.setFactura(factura1);
			
			factura1.setTotal(120);
			
			em.persist(factura1);
			
			em.flush();
			 
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		em.close();
		emf.close();
	}
}
