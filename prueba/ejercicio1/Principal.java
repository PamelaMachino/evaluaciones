package ejercicio1;

import java.util.Scanner;

public class Principal {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		

	
		BIOTREN U1 = new BIOTREN();
		
		System.out.println("Ingrese número de tarjeta:");
		int num = sc.nextInt();
		U1.setNum(num);
		
		System.out.println("Ingrese tipo de usuario: ");
		System.out.println("Común");
		System.out.println("TNE");
		System.out.println("BIP");
		String tipo = sc.next();
		U1.setTipo(tipo);
		
		System.out.println("Ingrese saldo ");
		int saldo = sc.nextInt();
		U1.setSaldo(saldo);
		
		System.out.println("Cuenta: "+num);
		System.out.println("Tipo: "+tipo);
		System.out.println("Saldo "+saldo);
		
		
	
				
		
		
	}

}



