package ec.edu.ups.appdis.g1.clienteExamenFinal.clirest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import ec.edu.ups.appdis.g1.clienteExamenFinal.model.Producto;
import ec.edu.ups.appdis.g1.clienteExamenFinal.model.Respuesta;


public class FachadaCli {
	private String WS_GET1 = "http://localhost:8080/ExamenProveedor1JEE/ws1/serv1/productonombre";
	private String WS_GET2 = "http://localhost:8080/ExamenProveedor2JEE/ws2/serv2/productonombre";
	
	private String WS_POST1 = "http://localhost:8080/ExamenProveedor1JEE/ws1/serv1/actualizar";
	private String WS_POST2 = "http://localhost:8080/ExamenProveedor2JEE/ws2/serv2/actualizar";
	
	/*http://localhost:8080/ExamenProveedor1JEE/ws1/serv1/productonombre?nombre=cemento
	http://localhost:8080/ExamenProveedor2JEE/serv2/productonombre?nombre={String}*/
	
	public Producto getProducto1(String nombre) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_GET1).queryParam("nombre", nombre);
		Producto producto = target.request().get(Producto.class);
		client.close();
		return producto;		
	}
	
	public Producto getProducto2(String nombre) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_GET2).queryParam("nombre", nombre);
		Producto producto = target.request().get(Producto.class);
		client.close();
		return producto;		
	}
	
	
	public Respuesta actualizaP1(Producto producto) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_POST1);
		Respuesta respuesta = target.request().post(Entity.json(producto), Respuesta.class);

		return respuesta;
	}
	
	public Respuesta actualizaP2(Producto producto) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_POST2);
		Respuesta respuesta = target.request().post(Entity.json(producto), Respuesta.class);

		return respuesta;
	}
}
