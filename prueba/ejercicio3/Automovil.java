package ejercicio3;

public class Automovil {
String marca;
String modelo;
int a�o;
double precio;

public Automovil() {
	super();
}

public Automovil(String marca, String modelo, int a�o, double precio) {
	super();
	this.marca = marca;
	this.modelo = modelo;
	this.a�o = a�o;
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

public int getA�o() {
	return a�o;
}

public void setA�o(int a�o) {
	this.a�o = a�o;
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
