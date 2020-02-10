package ejercicio4;
import java.util.Scanner;
public class Persona {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Publico epublico = new Publico ("152423566", "Fernando Mellado Salinas","Los Laureles 45", 945281947, 780000, "Municipalidad de Los Alamos", "Administrativo");
		
		Privado eprivado = new Privado("123456787", "Francisco Risopatrón De Lourdes", "Juan Bosco 1786", 976834616, 6000000, "Comuna de Las Condes", "Gerencia");
}
}
