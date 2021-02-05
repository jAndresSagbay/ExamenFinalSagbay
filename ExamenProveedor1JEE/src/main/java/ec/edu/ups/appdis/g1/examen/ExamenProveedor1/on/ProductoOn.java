package ec.edu.ups.appdis.g1.examen.ExamenProveedor1.on;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.g1.examen.ExamenProveedor1.dao.Productodao;
import ec.edu.ups.appdis.g1.examen.ExamenProveedor1.modelo.Producto;
import ec.edu.ups.appdis.g1.examen.ExamenProveedor1.services.Respuesta;

@Stateless
public class ProductoOn {
	@Inject
	Productodao dao;
	public Producto buscarProducto(String nombre) {
		return this.dao.buscarProducto(nombre);
}
	
	public Respuesta actualizar( Producto producto) {
		this.dao.actualizarProducto(producto);
		Respuesta res= new Respuesta();
		res.setCodigo(200);
		res.setMensaje("ok");
		return res;
		
		
	}

}
