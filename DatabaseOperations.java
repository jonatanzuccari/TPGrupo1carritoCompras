package proyectoFinal;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DatabaseOperations {
	

	public static void main(String[] args) {
	try {
		
		Connection cX = DriverManager.getConnection("jdbc:mysql://localhost:3306/grupo1database","root","eliseo4608" );
		Statement sT = cX.createStatement();
		String consulta = "select * from clientes";
		
		ResultSet sql = sT.executeQuery(consulta);
		
		System.out.println("CODIGO\tDNI\t\tNOMBRE\t\tDIRECCION");
		while (sql.next()) {
			System.out.println(sql.getInt(1)+"\t"+sql.getInt(3)+"\t"+sql.getString(2)+"\t"+sql.getString(4));
		}
		
		
		System.out.println("\n\t\t SELECCIONE UN CODIGO DE CLIENTE:  ");
		Scanner entrada = new Scanner(System.in);
		int cod = entrada.nextInt();
		
		//BUSCAR EN LA TABLA CLIENTES EL ID INGRESADO POR CONSOLA
		
        consulta = String.format("select * from clientes WHERE ID_cliente = %s", cod);
		
		sql = sT.executeQuery(consulta);
		int ID_cliente=0,dni=0;
		String nombre="", dire = "";
	
		while (sql.next()) {	
			ID_cliente=sql.getInt(1);
			dni=sql.getInt(3);
			nombre = sql.getString(2);
			dire= sql.getString(4);
		}
		
		Cliente clien1 = new Cliente (ID_cliente, nombre, dni,  dire);
		
		System.out.println("\n\t\t INGRESE EL NUMERO DEL CARRITO:  ");
		cod = entrada.nextInt();		
		Carrito chango = new Carrito(cod, clien1);
		
		
		//listar productos desde la bd
		boolean datos = true;
		while (datos) {
			System.out.println("ingrese el codigo del producto:");
			int prod1 = entrada.nextInt();
			System.out.println("ingrese la cantidad: ");
			int cant = entrada.nextInt();
//TENDRIA QUE EJEMPLARIZAR ITEMCARRITO			
			System.out.println("Desea ingresar otro producto?  s-n");
			entrada.nextLine();
			String respu = entrada.nextLine();			
			
			if (respu.equals("n"))
				datos= false;			
		}
		
		Producto prod1 = new Producto(  1061,"Yerba", 350.50, 20, "1kg sin palo");
		Producto prod2 = new Producto( 1062,"Azucar", 250.99, 10, "1kg refinada ");
		Producto prod3 = new Producto( 1063,"Harina", 150.99, 10, "1kg tipo 000 ");
		Producto prod4 = new Producto(  1064,"Huevo", 350.50, 20, "12 unidades");
		Producto prod5 = new Producto( 1065,"Aceite", 250.99, 10, "1l girasol");
		Producto prod6 = new Producto( 1066,"Helado", 150.99, 10, "1kg Multifruta ");
	
		
		ItemCarrito item1 = new ItemCarrito(chango,prod1,2);
		ItemCarrito item2 = new ItemCarrito(chango,prod3,2);
		ItemCarrito item3 = new ItemCarrito(chango,prod3,5);
		ItemCarrito item4 = new ItemCarrito(chango,prod4,3);
		ItemCarrito item5 = new ItemCarrito(chango,prod5,1);
		ItemCarrito item6 = new ItemCarrito(chango,prod6,1);

	
		List<ItemCarrito> item;
		item = new ArrayList<ItemCarrito>();
		item.add(item1);
		item.add(item2);
		item.add(item3);
		item.add(item4);

				
	
		System.out.println("Cliente: "+clien1.getNombre());
		item4.mostrarItemTitulo();
		Iterator<ItemCarrito> iterador = item.iterator();
									
		String insertT = "insert into itemcarrito (idCA,numCA,idP,canIC,montoIC,fechaIC) values(?,?,?,?,?,?)";		                                         
		PreparedStatement updaIC = cX.prepareStatement(insertT);
		LocalDate fecha1 = LocalDate.now();
				

		while (iterador.hasNext()) {
		ItemCarrito items = iterador.next();		
		items.mostrarItem();
		
		updaIC.setInt(1,1);//le damos un valor nosotros por el momento solo para probar el insert
		updaIC.setInt(1,chango.getNumID());
		updaIC.setInt(2,items.getProducto());
		updaIC.setInt(3,items.getCantidad());
		updaIC.setDouble(4,items.getMontoItem());
		updaIC.setString(5,fecha1.toString());

		updaIC.executeUpdate();
		
		chango.sumarMonto(items);
		}
		System.out.println("\nTotal: "+String.format("%.2f",chango.getMontoCarrito()));

		Descuento dFijo = new DescuentoFijo();
		dFijo.asignaMonto(100);
		System.out.println("MontoTotal con descuento: "
		+ String.format("%.2f",dFijo.montoFinal(chango.getMontoCarrito())));
		LocalDate fecha = LocalDate.now();
		
		//cargar la tabla carrito
		consulta ="insert into carrito (idCA,numCA,idC,montoCA,descuCA,fechaCA) values(idCA,?,?,?,?,?)";
    	
    	PreparedStatement ins = cX.prepareStatement(consulta);		
		
    	//ins.setInt(1,idCA);
        ins.setInt(1,chango.getNumID());
        ins.setInt(2,clien1.getID_cliente());
        ins.setDouble(3,chango.getMontoCarrito());
        ins.setDouble(4,dFijo.montoFinal(chango.getMontoCarrito()));
        ins.setString(5,fecha.toString());

        // Indicamos que comience la actualización de la tabla en nuestra base de datos
        ins.executeUpdate();
		
		entrada.close();
		cX.close();
		
	}catch(Exception obj) {
		System.out.println("Error en la conexion");
		System.out.println(obj.fillInStackTrace());
	}			
	}
}
