package ejercicio3;

public class Automovil {
String marca;
String modelo;
int año;
double precio;

public Automovil() {
	super();
}

public Automovil(String marca, String modelo, int año, double precio) {
	super();
	this.marca = marca;
	this.modelo = modelo;
	this.año = año;
	this.precio = precio;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public int getAño() {
	return año;
}

public void setAño(int año) {
	this.año = año;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

public void preciofinal() {
 System.out.println(((precio*1.19)*1.05)+100000); 
}
}
