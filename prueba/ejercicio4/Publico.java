package ejercicio4;

public class Publico extends Empleado{
	private String municipalidad;
	private String departamento;
	
	public Publico() {
		super();
	}

	public Publico(String rut, String nombres, String direccion, int telefono, double sueldo, String municipalidad,
			String departamento) {
		super(rut, nombres, direccion, telefono, sueldo);
		this.municipalidad = municipalidad;
		this.departamento = departamento;
	}

	public String getMunicipalidad() {
		return municipalidad;
	}

	public void setMunicipalidad(String municipalidad) {
		this.municipalidad = municipalidad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
