package proyectoFinal;

public class Carrito {

	private int numID;
	private Cliente ClienID;
	private double MontoCarrito;

	public Carrito (int numID, Cliente C) {
	this.numID = numID;
	ClienID = C;

	}

	public int getNumID() {
		return numID;
	}

	public void setNumID(int numID) {
		this.numID = numID;
	}

	public Cliente getClienID() {
		return ClienID;
	}

	public void setClienID(Cliente clienID) {
		ClienID = clienID;
	}

	public double getMontoCarrito() {
		return MontoCarrito;
	}

	public void setMontoCarrito(double Total) {
		MontoCarrito = Total;
		System.out.println("Total: " + MontoCarrito);
	}

public void sumarMonto(ItemCarrito montoItem) {
	MontoCarrito = MontoCarrito + montoItem.getMontoItem();
}
}