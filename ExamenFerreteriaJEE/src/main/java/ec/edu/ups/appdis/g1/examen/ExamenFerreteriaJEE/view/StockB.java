package ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.cli.StockCli;
import ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.modelo.Producto;
import ec.edu.ups.appdis.g1.examen.ExamenFerreteriaJEE.on.ProductoOn;


@Named
@ViewScoped
public class StockB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Inject
	ProductoOn productoon;
	/*@Inject 
	transient StockCli cli;*/
	
	private Producto producto;
	
	private List<Producto> productos;
	
	@PostConstruct
	public void init() {
		this.producto= new Producto();
		
		listarProductos();
	}

	public Producto getProducto() {
		return producto;
	}

	public void listarProductos() {
		//StockCli cli = new StockCli(); 
		Producto c = new Producto();
		c.setId(1);
		c.setNombre("madera");
		c.setStock(30);
		
		this.productos.add(c/*this.cli.getProdcuto1("cemento"));

		this.productos.add(this.cli.getProdcuto2("clavos")*/);
		
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	

}
