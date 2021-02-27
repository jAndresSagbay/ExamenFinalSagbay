package ec.edu.ups.appdis.g1.clienteExamenFinal.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.ups.appdis.g1.clienteExamenFinal.clirest.FachadaCli;
import ec.edu.ups.appdis.g1.clienteExamenFinal.model.Producto;
import ec.edu.ups.appdis.g1.clienteExamenFinal.model.Proveedor;
import ec.edu.ups.appdis.g1.clienteExamenFinal.model.Respuesta;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	
	Proveedor p1;
	Proveedor p2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		p1= new Proveedor();
		p2= new Proveedor();
		initialize();

	}

	
	public void data() {
p1.setNombre("P1");
		
		p2.setNombre("P2");
		FachadaCli cli = new FachadaCli();

		Producto producto1 = cli.getProducto1("cemento");
		producto1.setProveedor(p1);
		producto1.setId(1);
		Producto producto2 = cli.getProducto2("clavos");
		producto2.setProveedor(p2);
		producto2.setId(2);
		

		int numcolumns = table.getModel().getColumnCount();

		Object[] fila = new Object[numcolumns];
		fila[0] = producto1.getId();
		fila[1] = producto1.getNombre();
		fila[2] = producto1.getProveedor().getNombre();
		fila[3] = producto1.getStock();
		((DefaultTableModel) table.getModel()).addRow(fila);

		Object[] fila2 = new Object[numcolumns];
		fila2[0] = producto2.getId();
		fila2[1] = producto2.getNombre();
		fila2[2] = producto2.getProveedor().getNombre();
		fila2[3] = producto2.getStock();
		((DefaultTableModel) table.getModel()).addRow(fila2);

	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 403, 125);
		panel.add(scrollPane);

		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = table.rowAtPoint(e.getPoint());

				Producto ac = new Producto();
				ac.setNombre(String.valueOf(table.getValueAt(seleccion, 1)));

				FachadaCli cli = new FachadaCli();
				if (seleccion == 0) {
					String cant = JOptionPane.showInputDialog("Ingresa la cantidad del pedido");
					ac.setStock(Integer.parseInt(cant));
					Respuesta mensaje = cli.actualizaP1(ac);
					JOptionPane.showMessageDialog(null, mensaje);
				} else {
					
					String cant = JOptionPane.showInputDialog("Ingresa la cantidad del pedido");
					ac.setStock(Integer.parseInt(cant));
					Respuesta mensaje = cli.actualizaP2(ac);
					JOptionPane.showMessageDialog(null, mensaje);

				}
				p1.setNombre("P1");
				p2.setNombre("P2");
				  DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			        while(modelo.getRowCount()>0)modelo.removeRow(0);
				FachadaCli cli2 = new FachadaCli();

				Producto producto1 = cli.getProducto1("cemento");
				producto1.setProveedor(p1);
				producto1.setId(1);
				Producto producto2 = cli.getProducto2("clavos");
				producto2.setProveedor(p2);
				producto2.setId(2);
				
				int numcolumns = table.getModel().getColumnCount();

				Object[] fila = new Object[numcolumns];
				fila[0] = producto1.getId();
				fila[1] = producto1.getNombre();
				fila[2] = producto1.getProveedor().getNombre();
				fila[3] = producto1.getStock();
				((DefaultTableModel) table.getModel()).addRow(fila);

				Object[] fila2 = new Object[numcolumns];
				fila2[0] = producto2.getId();
				fila2[1] = producto2.getNombre();
				fila2[2] = producto2.getProveedor().getNombre();
				fila2[3] = producto2.getStock();
				((DefaultTableModel) table.getModel()).addRow(fila2);
			}
			
		});
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Producto", "Proveedor", "Stock", "Acciones" }));
		scrollPane.setViewportView(table);
		this.data();

	}
	
}
