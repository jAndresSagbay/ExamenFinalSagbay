package ec.edu.ups.appdis.g1.examen.ExamenProveedor1.services;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.appdis.g1.examen.ExamenProveedor1.modelo.Producto;
import ec.edu.ups.appdis.g1.examen.ExamenProveedor1.on.ProductoOn;



@Path("serv2")
public class ClienteServiceRest {
	@Inject
	private ProductoOn productoon;
	

	@GET
	@Path("productonombre")
	@Produces("application/json")
	public Producto buscartransaccionID(@QueryParam("nombre") String nombre) {
		try {
			return this.productoon.buscarProducto(nombre);// transaccionon.getTransaccion(id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@POST
	@Path("/actualizar")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta update(Producto producto) {
		Respuesta r = new Respuesta();
		try {
			r =this.productoon.actualizar(producto);// transaccionon.retiro(fachada);
		} catch (Exception e) {
			e.printStackTrace();
			r.setCodigo(99);
			r.setMensaje(e.getMessage());
		}
		return r;
	}
}