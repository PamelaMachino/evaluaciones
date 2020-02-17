package Cajero;

import java.util.Scanner;
import javax.swing.JOptionPane;
public class Principal {
static Scanner sc = new Scanner(System.in);
	
	
public static void main(String[] args) {
	int opmenu=0;
	int op=0;
	int opcli=0;
	
	Cliente[] cte= new Cliente[10];
	cte[0]= new Cliente(8000001, "123abc", "Corriente", 0, "121898128", "Alejandra", "Hidalgo");
	cte[1]= new Cliente(8000002, "123abd", "Ahorro", 0, "198145726", "Pamela", "Machino");
	cte[2]= new Cliente(8000003, "123abe", "Corriente", 0, "154879188", "Ignacia", "Vega");
	cte[3]= new Cliente(8000004, "123abf", "Vista", 0, "107741534", "José", "Osandon");	
	cte[4]= new Cliente(8000005, "123abg", "Ahorro", 0, "164658848", "Andrea", "Araya");
	int cont=5;//contador para crear cuenta

	String m[][] = new String [10][5];//registrar movimientos cuenta
	
	do {
		try {
		opmenu=Integer.parseInt(JOptionPane.showInputDialog("" 
			
			+ "Menú"
			+ "\n 1.- Administrador"
			+ "\n 2.- Cliente"
			+ "\n 3.- Salir"));
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null,"Opcion no valida");
    	}

    if(opmenu==1) {

    	String arreglosimple[] = new String [2]; 
    	boolean admin=false;
    	
    	arreglosimple[0]=JOptionPane.showInputDialog(null, "Usser: ");	
    	arreglosimple[1]=JOptionPane.showInputDialog(null, "Pass: ");
    	
    	if  (arreglosimple[0].equals("root") && arreglosimple[1].equals("root")) {
    	
    			JOptionPane.showMessageDialog(null, ""
    			+ "\n Usser: " +arreglosimple[0]
    			+ "\n Pass: ****");
    	
    			admin=true;
    	
    	} else JOptionPane.showMessageDialog(null, "el usuario o la contraseña igresados son incorrectos", "Error!", JOptionPane.ERROR_MESSAGE);
    	
    		
    	if (admin) {
    
    		do {
    		try {
    			op=Integer.parseInt(JOptionPane.showInputDialog(""	
				+ "Menú Administrador"
				+ "\n 1.- Crear cuenta"
				+ "\n 2.- Crear cliente"
				+ "\n 3.- Mostrar cliente"
				+ "\n 4.- Salir" ));
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Opcion no valida");
	    	}
    	if (op==1) {
			if (cont<10) {
				int opcuenta;
				cte[cont]= new Cliente();
				opcuenta=Integer.parseInt(JOptionPane.showInputDialog(""	
					+ "Seleccione el tipo de cuenta:"
					+ "\n 1.- Corriente "
					+ "\n 2.- Ahorro "
					+ "\n 3.- Vista "
					+ "\n 4.- Salir " ));
				if (opcuenta!=4 && cont<10) {
				
					cte[cont].asignar_cuenta(cont+1);
					cte[cont].tipo_cuenta(opcuenta);
					cte[cont].consultar();
					cont++;
				}
				if (opcuenta==4) {
				break;
				}

			}else JOptionPane.showMessageDialog(null, "Hay 10 cuentas creadas");
    
		}
		if (op==2) {		
		
			int tipo;
			String stipo="";
			int posdisp=0;
			
			tipo=Integer.parseInt(JOptionPane.showInputDialog(""
					+ "Ingrese tipo de cuenta"
					+ "\n 1.- Corriente"
					+ "\n 2.- Ahorro"
					+ "\n 3.- Vista"));
		
			boolean disp=false;
			if (tipo==1) {stipo="Corriente";}
			if (tipo==2) {stipo="Ahorro";}
			if (tipo==3) {stipo="Vista";}	
			for (int x=0;x<cont;x++) {
				if ((cte[x].getRut()==null)&&(cte[x].getTipo().equals(stipo))) {
					disp=true;
					posdisp=x;
					x=cont;
				}
			}
			if (disp) {
			String auxrut="";
			boolean rutvalido=false;
			int intentorut=0;
			do {
				
				auxrut=JOptionPane.showInputDialog(""
						+ "\n Cueta nueva: "+cte[posdisp].getCuenta()
						+ "\n Ingrese Rut ");
				//cte[cont].setRut
				rutvalido=Cliente.validaRut(auxrut);
				if (rutvalido==true){
					cte[posdisp].setRut(auxrut);
				} else {
					intentorut++;
					JOptionPane.showMessageDialog(null, "rut no valido, intento "+intentorut, "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}while ((!rutvalido)&&(intentorut<3));
			
			if (rutvalido) {
				cte[posdisp].setNombre(JOptionPane.showInputDialog(null,"Ingrese Nombre "));
				cte[posdisp].setApellido(JOptionPane.showInputDialog(null,"Ingrese Apellido "));
				cte[posdisp].asignar_clave();			
				cte[posdisp].setSaldo(0);
				cte[posdisp].consultar();
			}
			}else JOptionPane.showMessageDialog(null, "No hay cuenta disponible de ese tipo");
			}
		
		if (op==3) {	
			int poscon=-1;
			int numerodecuenta;
			numerodecuenta=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese número de cuenta"));
			
			for (poscon=0; poscon<cont; poscon++)	
				if(cte[poscon].getCuenta()==numerodecuenta) {
					JOptionPane.showMessageDialog(null, ""	
							+ "\n Cuenta: "+cte[poscon].getCuenta()
							+ "\n Tipo: "+cte[poscon].getTipo()
							+ "\n Rut: "+cte[poscon].getRut()
							+ "\n Nombre: "+cte[poscon].getNombre()
							+ "\n Apellido: "+cte[poscon].getApellido()
							+ "\n Saldo: "+cte[poscon].getSaldo());
				}
		}
	}while(op!=4);//fin menu
    }
    }
	
    

    if(opmenu==2) {//menu cliente
    	boolean ctavalida =false;
		boolean clevalida=false;
		int poscta=0;// posicion de cuenta actual
		do {
			int cli=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese Cuenta Cliente "));
		   	for (int k=0;k<cont;k++) {
	   			if (Integer.compare(cte[k].getCuenta(),cli)==0) {
	   				poscta=k;
	   				ctavalida=true;	
	   				k=cont;//para terminar el for
	   			}
	   		}	
	
			if (ctavalida){
				int intento=0;
				do {
					String cla=JOptionPane.showInputDialog(null,"Ingrese Clave ");
					if (cte[poscta].getClave().equals(cla)) {
						clevalida=true;
						JOptionPane.showMessageDialog(null, "Bienvenido"
								+"\n"+ cte[poscta].getNombre()+" "+ cte[poscta].getApellido());
					}
					intento++;
					if (!clevalida)
						JOptionPane.showMessageDialog(null, "Clave no valida intento "+intento);
				}while((!clevalida)&&(intento<3));
			} else JOptionPane.showMessageDialog(null, "Cuenta no valida");
			
		}while (!ctavalida);
		
		if (ctavalida&&clevalida) {

			do {
				int a=0;
				boolean mov=false;
				String asunto="";
				try{				
				opcli=Integer.parseInt(JOptionPane.showInputDialog(""	
						+ "Menú Cliente"
						+ "\n 1.- Abono Dinero"
						+ "\n 2.- Retirar Dinero"
						+ "\n 3.- Consultar Saldo"
						+ "\n 4.- Cambio Clave"
						+ "\n 5.- Ultimos Movimientos"
						+ "\n 6.- Salir" ));
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null,"Opcion no valida");
		    	}
				if (opcli==1) {
					try{
	       		 		a =Integer.parseInt(JOptionPane.showInputDialog(null, 
           		 			" Cuenta N° "+ cte[poscta].getCuenta()
           		 			+"\n Ingrese abono"));
	       		 		cte[poscta].abono(a);
	       		 		asunto="Abono de dinero "+a;
	       		 		mov=true;
	       		 		cte[poscta].consultar_saldo();
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null,"No es un número");
			    	}
				}
				if (opcli==2) {
					try{					
	       		 		a =Integer.parseInt(JOptionPane.showInputDialog(null, 
           		 			" Cuenta N° "+cte[poscta].getCuenta()
           		 			+"\n Ingrese retiro"));
	       		 		asunto="Retiro de dinero -"+a;
	       		 		mov=cte[poscta].retiro(a);
	       		 		cte[poscta].consultar_saldo();	
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null,"No es un número");
			    	}	       		 		
				}
				if (opcli==3) {
					cte[poscta].consultar_saldo();
				}
				if (opcli==4) {
					String cla=JOptionPane.showInputDialog(null,"Ingrese Clave ");
					if (cte[poscta].getClave().equals(cla)) {
						String cla1=JOptionPane.showInputDialog(null,"Ingrese Clave Nueva ");
						String cla2=JOptionPane.showInputDialog(null,"Reingrese Clave Nueva ");
						if (cla1.equals(cla2)) {
							cte[poscta].setClave(cla1);
							JOptionPane.showMessageDialog(null, "Cambio Clave Exitoso");
			       		 	asunto="Cambio de Clave";
			       		 	mov=true;
						}else JOptionPane.showMessageDialog(null, "Claves no coinciden");

					}else JOptionPane.showMessageDialog(null, "Clave no valida");
					
				}
				if (opcli==5) {
					String elegante="";
					for (int l=0;l<5;l++) {
						if (m[poscta][l]!=null){
							elegante =elegante +"\n"+ m[poscta][l]; 
						}
					}
					JOptionPane.showMessageDialog(null,"Cuenta N° "+cte[poscta].getCuenta()
							+ elegante );	
				}
				if (mov){
					boolean espacio=false;
					for (int l=0;l<5;l++) {
						if (m[poscta][l]==null){
							m[poscta][l]=asunto;
							espacio = true;
							JOptionPane.showMessageDialog(null,(l+1)+" "+ m[poscta][l] );
							break;
						}
					}
					if (!espacio) {
						for (int p=1;p<5;p++) {
							m[poscta][p-1]=m[poscta][p];
						}
						m[poscta][4]=asunto;
						JOptionPane.showMessageDialog(null,"5 "+ m[poscta][4] );
					}
				}
				
			}while(opcli!=6);
		}
    	
    }

	}while(opmenu!=3);
	
	
}
}

	
	
	
	
	
	