package ec.edu.ups.appdis.g1.examen.ExamenProveedor1.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.examen.ExamenProveedor1.modelo.Producto;

@Stateless
public class Productodao {
	@Inject
	private EntityManager em1;
	
	public void actualizarProducto(Producto producto) {
		em1.merge(producto);
	}
	public Producto buscarProducto(String nombre) {
		Producto cli = new Producto();
		try {
			String jpql = "SELECT c FROM Producto c where c.nombre = :nombre";
			Query query = em1.createQuery(jpql, Producto.class);
			query.setParameter("nombre", nombre);
			cli = (Producto) query.getSingleResult();
		} catch (Exception e) {
			cli = null;
		}

		return cli;
	}
	
	
}
