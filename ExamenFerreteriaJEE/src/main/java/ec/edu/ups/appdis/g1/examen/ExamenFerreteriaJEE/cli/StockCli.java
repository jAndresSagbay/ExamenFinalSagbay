package ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.cli;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.modelo.Producto;
import ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.services.Respuesta;


public class StockCli {
	

	private String WS_GET_PRODUCTO1= "http://localhost:8080/ExamenProveedor1JEE/ws1/serv/productonombre?nombre=";
	private String WS_GET_PRODUCTO2= "http://localhost:8080/ExamenProveedor2JEE/ws2/serv/productonombre?nombre=";
	private String WS_ACTUALIZAR_STOCK_1 = "http://localhost:8080/ExamenProveedor1JEE/ws1/serv/actualizar";
	private String WS_ACTUALIZAR_STOCK_2 = "http://localhost:8080/ExamenProveedor2JEE/ws2/serv/actualizar";
	
	public Respuesta actualizarStock1(Producto producto) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_ACTUALIZAR_STOCK_1);
		Respuesta respuesta = target.request().post(Entity.json(producto), Respuesta.class);

		return respuesta;
	}
	

	public Respuesta actualizarStock2(Producto producto) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_ACTUALIZAR_STOCK_2);
		Respuesta respuesta = target.request().post(Entity.json(producto), Respuesta.class);

		return respuesta;
	}
	
	public Producto getProdcuto1(String nombre) {
		Client client = ClientBuilder.newClient();		
		WebTarget target = client.target(WS_GET_PRODUCTO1+nombre);

		Producto categorias = target.request().get(new GenericType<Producto>() {});
		
		client.close();
		
		return categorias;		
	}
	
	public Producto getProdcuto2(String nombre) {
		Client client = ClientBuilder.newClient();		
		WebTarget target = client.target(WS_GET_PRODUCTO2+nombre);

		Producto categorias = target.request().get(new GenericType<Producto>() {});
		
		client.close();
		
		return categorias;		
	}
	

}
