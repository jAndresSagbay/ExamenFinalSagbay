package ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.modelo.Proveedor;


@Stateless
public class Proveedordao {
	
	@Inject
	private EntityManager em;
	
	public void actualizarProveedor(Proveedor proveedor) {
		em.merge(proveedor);
	}
	
	public List<Proveedor> mostrarProveedores() {
		String jpql = "SELECT a FROM Proveedor a";
		Query query = em.createQuery(jpql, Proveedor.class);
		List<Proveedor> proveedores = query.getResultList();
		return proveedores;
	}
	

}
