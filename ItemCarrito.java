package proyectoFinal;

public class ItemCarrito {
	private Carrito carro;
	private Producto prod;
	private int cantidad;
	private double montoItem;
	private int numeroC;
	
	public ItemCarrito(Carrito num, Producto p, int cantidad) {
		carro= num;
		prod = p;
		this.cantidad=cantidad;
		montoItem= prod.getPrecio() * cantidad;	
	}
	public int getCantidad() {
		return cantidad;
	}
	
	public double getMontoItem() {
		return montoItem;
	}
	public int getProducto() {
		return prod.getCodigo();
	}
	public void mostrarItem() {
		
		System.out.println(cantidad+"\t"+montoItem+"\t"+String.format("%.2f",montoItem ));
	}
	public void mostrarItemTitulo() {
		System.out.println("Carro num: "+carro.getNumID());
		System.out.println("Cant:\tPrecio:\tSub Total:\tProd:");
	}


}