package ejercicio1;


public class BIOTREN {

    int num;
	String tipo;
	int saldo;
	int descuento;
	

	public BIOTREN() {
		super();
	}
	

public BIOTREN(int num, String tipo, int saldo, int descuento) {
		super();
		this.num = num;
		this.tipo = tipo;
		this.saldo = saldo;
		this.descuento = descuento;
	}


public int getNum() {
	return num;
}


public void setNum(int num) {
	this.num = num;
}


public String getTipo() {
	return tipo;
}


public void setTipo(String tipo) {
	this.tipo = tipo;
}


public int getSaldo() {
	return saldo;
}


public void setSaldo(int saldo) {
	this.saldo = saldo;
}


public int getDescuento() {
	return descuento;
}


public void setDescuento(int descuento) {
	this.descuento = descuento;
}



}
	

