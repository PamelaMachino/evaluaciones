package Cajero;
import java.util.Random;

import javax.swing.JOptionPane;
public class Cuenta {

	int cuenta;
	String clave; 
	String tipo;
	double saldo;
	
	
	public Cuenta() {
		super();
	}

	

	public Cuenta(int cuenta, String clave, String tipo, double saldo) {
		super();
		this.cuenta = cuenta;
		this.clave = clave;
		this.tipo = tipo;
		this.saldo = saldo;
	}



	public int getCuenta() {
		return cuenta;
	}


	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
   public void tipo_cuenta(int op) {
	if (op==1) {
		setTipo("Corriente");
	}
	if (op==2) {
		setTipo("Ahorro");
	}
	if (op==3) {
		setTipo("Vista");	
	}
	
   }
   	public void asignar_clave() {
   		Random r = new Random();
   		int ii=r.nextInt(100000-50000)+50000;
	    setClave(""+ii);

   	}

   	public void asignar_cuenta(int cue) {
   		setCuenta(8000000+cue);
   	}
   	
	public void consultar_saldo() {
		JOptionPane.showMessageDialog(null, ""
				+ "\n Cuenta N° "+getCuenta()
				+ "\n Saldo "+String.format("%.0f",getSaldo()));		
	}
	
	public void abono(int monto) {
		setSaldo(getSaldo()+monto);
	}
   	
	public boolean retiro(int monto) {
		if (getSaldo()>=monto){
			setSaldo(getSaldo()-monto);
			return true;
		}else {
			JOptionPane.showMessageDialog(null, " Saldo insuficiente, NO puede retirar dinero");
			return false;
		}
	}  	
}
