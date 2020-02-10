package ejercicio2;

public class Empleado {

	private String rut;
	private String cargo;
	private String nombre;
	private String apellidop;
	private String apellidom;
	private String direccion;
	private int fono;
	private String email;

	

	public Empleado(String rut, String cargo, String nombre, String apellidop, String apellidom) {
		super();
		this.rut = rut;
		this.cargo = cargo;
		this.nombre = nombre;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
	}



	public Empleado(String rut, String apellidop, String apellidom, String direccion, int fono, String email) {
		super();
		this.rut = rut;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.direccion = direccion;
		this.fono = fono;
		this.email = email;
	}

	
}

