package Cajero;

import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.regex.*;


public class Cliente extends Cuenta{

	String rut;
	String nombre;
	String apellido;
	
	
	
	public Cliente() {
		super();
		
	}


	public Cliente(int cuenta, String clave, String tipo, double saldo, String rut, String nombre, String apellido) {
		super(cuenta, clave, tipo, saldo);
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;		
	}


	public String getRut() {
		return rut;
	}



	public void setRut(String rut) {
		this.rut = rut;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void consultar() {
		JOptionPane.showMessageDialog(null, ""
				+ "\n CUENTA: "+getCuenta()
				+ "\n Tipo Cuenta: "+getTipo()
				+ "\n Clave: "+getClave()
				+ "\n Saldo: "+getSaldo()
				+ "\n Rut: "+getRut()
				+ "\n Nombre: " +getNombre()
				+ "\n Apellido: " +getApellido());	
		
	}
	
	
	public static Boolean validaRut ( String rut ) {
		Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
		Matcher matcher = pattern.matcher(rut);
			if ( matcher.matches() == false ) return false;
				String[] stringRut = rut.split("-");
				return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
				}
			
			/**
			 * Valida el dígito verificador
			 */
			public static String dv ( String rut ) {
				Integer M=0,S=1,T=Integer.parseInt(rut);
				for (;T!=0;T=(int) Math.floor(T/=10))
					S=(S+T%10*(9-M++%6))%11;
				return ( S > 0 ) ? String.valueOf(S-1) : "k";		
			}
			
}
