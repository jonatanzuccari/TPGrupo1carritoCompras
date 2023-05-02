package proyectoFinal;

public abstract class Descuento {
	private double Monto;

	public double getMonto() {
		return Monto;
	}

	public void asignaMonto(double Monto) {
		this.Monto = Monto;
	}
	public abstract double montoFinal(double montoinicial);
}