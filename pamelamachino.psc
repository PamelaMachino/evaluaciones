Algoritmo menu
	
	Definir nombre, alumnos, datos como caracter
	Definir num, a, b, c, cont, op, suma, genero, bd Como Entero

	
	Repetir
		
		Escribir "******************MENU******************"
		Escribir "*1.Secuencial                          *"
		Escribir "*2.Condicional Si entonces             *"
		Escribir "*3.Condicional Si entonces anidado     *"
		Escribir "*4.Condicional Según                   *"
		Escribir "*5.Repetitiva Mientras                 *"
		Escribir "*6.Repetitiva Repetir                  *"
		Escribir "*9.Arreglo bidimensional               *"
		Escribir "*10.Salir                              *"
		Leer op
		
		Escribir "****************************************"
		
		Segun op hacer
			
			1:  secuencial
				Borrar pantalla
				
			2:  si_entonces
				Borrar pantalla
				
			3:  si_anidado
				Borrar pantalla
				
			4:  condicional_segun
				Borrar pantalla
				
			5:  repetitiva_mientras
				Borrar pantalla
				
			6:  repetitiva_repetir
				Borrar pantalla
				
			9: arreglo_bidimensional
				Borrar Pantalla
				
		FinSegun
		
	Hasta Que op = 10
FinAlgoritmo


Funcion secuencial 
	
	Escribir "Ingrese el primer número"
	Leer a
	Escribir "Ingrese el segundo número"
	leer b
	Escribir "Ingrese el tercer número"
	leer c
    Mostrar "Promedio = " (a+b+c)/3
	
	Esperar Tecla
	
FinFuncion

	
	
Funcion si_entonces
	
	Escribir "Ingrese su nombre"
	leer nombre
	Escribir "Ingrese un 1 si su genero es masculino o un 2 si su género es femenino"
	leer genero
	Si genero<>2 y genero<>1 entonces
	Escribir "No se encontró baño para este género"
	Escribir "Ingrese su género seleccionando entre las opciones 1 y 2"
	FinSi
	Si genero=2 entonces
		escribir "",nombre," diríjase al baño de mujeres"
	FinSi
	Si genero=1 entonces
		Escribir "",nombre,": diríjase baño de hombres"
	FinSi
	
	Esperar Tecla
	
FinFuncion
	
	
	
	Funcion si_anidado

	Escribir "Ingrese su nombre"
	leer nombre
	Escribir "Ingrese un 1 si su genero es masculino o un 2 si su género es femenino"
	leer genero
	Escribir "Si desea ir a las duchas ingrese: 1, si desea ir a los baños ingrese: 2"
	Leer bd
	
	Si genero<>1 y genero<>2 
		Escribir "No se han encontrado baños para la opción ingresada"
		Escribir "Intente nuevamente seleccionando entre las opciones 1 y 2"
	FinSi
	
	Si genero=1 entonces
		Si bd<>1 y bd<>2 entonces
			Escribir "La opción seleccionada para la eleccion de baños o duchas es incorrecta"
			Escribir "Seleccione entre las opciones 1 y 2"
		FinSi
		Si bd=1 entonces
			escribir "",nombre,", diríjase a las duchas del baño de hombres, el precio de las duchas es de $ 2.500"
		FinSi
		Si bd=2 entonces
			Escribir "",nombre,", diríjase al baño de hombres, el precio del baño es de $250"
		FinSi
	FinSi
	
	Si genero=2 entonces
		Si bd<>1 y bd<>2 entonces
			Escribir "La opción seleccionada para la eleccion de baños o duchas es incorrecta"
			Escribir "Seleccione entre las opciones 1 y 2"
		FinSi
		Si bd=1 entonces
			escribir "",nombre,", diríjase a las duchas del baño de mujeres, el precio de las duchas es de $ 2.500"
		FinSi
		Si bd=2 entonces
			Escribir "",nombre,", diríjase al baño de mujeres, el precio del baño es de $250"
		FinSi
	FinSi
	
	Esperar Tecla
	
FinFuncion


Funcion condicional_segun
	
	Escribir "Ingrese un número del 1 al 10"
	Leer num
	Segun num hacer
		1: Escribir"uno"
		2: Escribir"dos"
		3: Escribir"tres"
		4: Escribir"cuatro"
		5: Escribir"cinco"
		6: Escribir"seis"
		7: Escribir"siete"
		8: Escribir"ocho"
		9: Escribir"nueve"
		10: Escribir"diez"
	FinSegun
	
	Esperar Tecla
	
FinFuncion



Funcion repetitiva_mientras
	
	cont=1
	Escribir "Ingrese números para promediarlos. Para obtener el resultado ingrese un: 0"
	leer num
	
	suma=0
	
	Mientras num<>0
		cont=cont+1
		suma=suma+num
		leer num
	FinMientras
	
	Escribir "Promedio = ",suma/(cont-1),""
	Escribir "Se han ingresado ",cont-1," números" 
	Escribir "(excluyendo el cero)"
	
	Esperar Tecla
	
FinFuncion



	
Funcion repetitiva_repetir
	
	Cont=0
	
	Repetir
		cont=cont+1
		Escribir "Ingrese un nombre"
		leer nombre
	Hasta Que nombre="juan" o nombre="Juan"
	
	Escribir "Se realizaron ",cont-1," intentos antes de llegar al nombre Juan" 
	
	Esperar Tecla
	
FinFuncion


Funcion arreglo_bidimensional
	Dimension datos[4]
	datos[0]="Nombre"
	datos[1]="Apellido"
	datos[2]="Fono"
	datos[3]="E-mail"
	
	Escribir "Ingrese cantidad de alumnos: "
	leer a
	
	Si a>0 Entonces
		Dimension alumnos[a,4]
		
		Para b=0 hasta a-1
			Escribir "Datos del alumno"
			
			Para c=0 hasta 3
				Escribir "Ingrese ",datos[c],": "
				Leer alumnos[b,c]
			FinPara
			
		FinPara
	FinSi
	
	Escribir "Los datos de todos los alumnos son:"
	Escribir " "
	
	Para b=0 hasta a-1
		Escribir "Nombre: ", alumnos[b,0], " ", alumnos[b,1], "  " 
		Escribir "Fono: ", alumnos[b,2], "  " 
		Escribir "E-mail: ", alumnos[b,3]
	FinPara
	
	Esperar Tecla
FinFuncion




	