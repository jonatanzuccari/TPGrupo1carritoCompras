package proyectoFinal;

public class DescuentoPorc extends Descuento {
	public double montoFinal( double montoIncial) {
		return montoIncial- (montoIncial*this.getMonto());
	} 
}