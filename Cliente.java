package proyectoFinal;


public class Cliente {
	private int ID_cliente;
	private String nombre;
	private int dni;
	private String dire;
	private String tel;
	private String email;
	private String estCivil;


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getDire() {
		return dire;
	}


	public void setDire(String dire) {
		this.dire = dire;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEstCivil() {
		return estCivil;
	}


	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}


	public Cliente(int ID_cliente, String nombre, int dni, String dire) {
		this.ID_cliente=ID_cliente;
		this.nombre=nombre;
		this.dni=dni;
		this.dire=dire;
		
	}

	public int getID_cliente() {
		return ID_cliente;
	}


	public void setID_cliente(int iD_cliente) {
		ID_cliente = iD_cliente;
	}


	public void mostrarPersona () {
		System.out.println("Persona : ");
		System.out.println("DNI: " + dni+"  "+"Nombre: " + nombre);
		System.out.println("Mail: " + email+"  "+"Direccion: " + dire);
		System.out.println("Telefono: " + tel+"  "+"Estado civil: " + estCivil);

	}


}