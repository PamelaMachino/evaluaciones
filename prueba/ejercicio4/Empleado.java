package ejercicio4;

public class Empleado {
String rut;
String nombres;
String direccion;
int telefono;
double sueldo;


public Empleado() {
	super();
}

public Empleado(String rut, String nombres, String direccion, int telefono, double sueldo) {
	super();
	this.rut = rut;
	this.nombres = nombres;
	this.direccion = direccion;
	this.telefono = telefono;
	this.sueldo = sueldo;
}

public String getRut() {
	return rut;
}

public void setRut(String rut) {
	this.rut = rut;
}

public String getNombres() {
	return nombres;
}

public void setNombres(String nombres) {
	this.nombres = nombres;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public int getTelefono() {
	return telefono;
}

public void setTelefono(int telefono) {
	this.telefono = telefono;
}

public double getSueldo() {
	return sueldo;
}

public void setSueldo(double sueldo) {
	this.sueldo = sueldo;
}


}
