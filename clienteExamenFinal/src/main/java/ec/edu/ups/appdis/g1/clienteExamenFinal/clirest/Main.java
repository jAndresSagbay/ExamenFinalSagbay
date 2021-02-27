package ec.edu.ups.appdis.g1.clienteExamenFinal.clirest;

import java.util.List;

import ec.edu.ups.appdis.g1.clienteExamenFinal.model.Producto;

public class Main {

	public static void main(String args[]) {
		
		//CategoriasCli cli = new CategoriasCli();
		//TransaccionCli cliente= new TransaccionCli();
		FachadaCli cli = new FachadaCli();
		
		Producto producto1=cli.getProducto1("cemento");
		Producto producto2=cli.getProducto2("clavos");
		System.out.println(producto1.toString());
		System.out.println(producto2.toString());
		
		
		producto1.setStock(30);
		producto2.setStock(40);
		
		
		System.out.println(cli.actualizaP1(producto1));
		System.out.println(cli.actualizaP2(producto2));
		
		/*
		//Cosumiendo WS-REST de tipo GET que retorna un objeto 
		Categoria cat = cli.getCategoria(100);
		System.out.println(cat);
		
		//Cosumiendo WS-REST de tipo GET que retorna una colección de objeto 
		List<Categoria> categorias = cli.getCategorias();
		System.out.println(categorias);
		
		*/
		
		//Consumiento un WS-REST de tipo POST enviando una entidad como parametro
	/*Respuesta respuesta = cliente.registraTransferenciaentrecuentas(trf);
		System.out.println("Transferencia: "+respuesta);
		
		Respuesta respuestaDeposito = cliente.registraDeposito(trfDeposito);
		System.out.println("Deposito"+respuestaDeposito);
		
		Respuesta respuestaRetiro = cliente.registraRetiro(trfRetiro);
		System.out.println("Retiro: "+respuestaRetiro);*/
		
		//ec.ups.edu.appdis.g1.clientesoap
	}
}
