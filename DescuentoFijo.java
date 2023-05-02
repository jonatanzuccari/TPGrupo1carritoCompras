package proyectoFinal;

public class DescuentoFijo extends Descuento{
	public double montoFinal( double montoIncial) {
		return montoIncial- this.getMonto();
	} 
}