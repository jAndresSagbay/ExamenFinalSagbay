package ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.modelo.Producto;

@Stateless
public class Productodao {
	@Inject
	private EntityManager em;
	
	public void actualizarProveedor(Producto producto) {
		em.merge(producto);
	}

}
