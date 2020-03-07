******************************************************************************************
EJERCICIO 1

Creación de las tablas EN MySQL:

CREATE TABLE empleado (
  idEmpleado BIGINT NOT NULL PRIMARY KEY,
  nombreEmpleado CHARACTER(50) NOT NULL,
  fechaIngreso DATE NOT NULL
);

CREATE TABLE servicio (
  idServicio BIGINT NOT NULL PRIMARY KEY,
  nombreServicio CHARACTER(20) NOT NULL,
  valorServicio BIGINT NOT NULL,
);

CREATE TABLE prestacion_servicio (
  idPrestacionServicio BIGINT NOT NULL PRIMARY KEY,
  id_Servicio BIGINT NOT NULL,
  id_Empleado BIGINT NOT NULL,
  id_Vehiculo BIGINT NOT NULL,
  fecha DATE NOT NULL
)
------------------------------------------------------------------------------------------
a.- Mostrar la cantidad de prestaciones de servicios ejecutados entre 
el 01 de octubrey el 26 de noviembre del 2018

SELECT COUNT(idPrestacionServicio) AS Cantidad_de_Prestaciones 
FROM prestacion_servicio
WHERE fecha BETWEEN '2018-10-01' and '2018-11-26';


b.-Mostrar la cantidad total de prestaciones realizadas agrupadas por idVehiculo.

SELECT id_Vehiculo, COUNT(idPrestacionServicio) AS Cantidad_de_Prestaciones
FROM prestacion_servicio
GROUP BY id_Vehiculo;


c.-Mostrar los vehículos con la menor cantidad de prestaciones de servicios realizados. 
(Se muestran los 5 vehículos con menor cantidad de prestaciones de servicios realizados)

SELECT id_Vehiculo, COUNT(idPrestacionServicio) AS Cantidad_de_Prestaciones
FROM prestacion_servicio
GROUP BY id_Vehiculo
ORDER BY `Cantidad_de_Prestaciones` ASC
LIMIT 5;

******************************************************************************************
EJERCICIO 2
Creación de la tabla empleado en MySQL

CREATE TABLE empleado (
    idEmpleado BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre CHARACTER(15) NOT NULL,
    apellido CHARACTER(15) NOT NULL,
    direccion CHARACTER(50) NOT NULL,
    telefono BIGINT NOT NULL,
    idDepartamento BIGINT NOT NULL
)

******************************************************************************************
EJERCICIO 3

- Se creó el modelo conceptual de Entidad-Relación para la marca de cine 
en PowerDesigner utilizando las tablas:
1. cine
2. sala
3. funcion
4. promocion
5. pelicula
6. opinion
7. persona (en esta tabla se encuentran actores y directores)
8. personaje

Entidad     relación    entidad      Cardinalidad
cine        "tiene"      sala        - de cine a sala (1,n) un cine tiene una o muchas 
                                       salas
			 	     - de sala a cine (1,1) una sala la tiene solo 
                                       un cine

sala        "realiza"    funcion     - de sala a funcion (1,n) en una sala se realizan 
				       una o muchas funciones
                                     - de funcion a sala (1,1) una función se realiza en
                                       una sola sala

funcion     "ofrece"     promocion   - de funcion a promocion (0,n) una función ofrece
                                       entre ninguna y muchas promociones
        			     - de promocion a funcion (1,n) una promocion se 
                                       ofrece en una o en muchas funciones 

funcion     "exhibe"     pelicula    - de funcion a pelicula (1,1) una funcion exhibe 
                                       solo una pelicula
                                     - de pelicula a funcion (1,n) una pelicula se 
                                       exhibe en una o muchas funciones

pelicula    "adjunta"    opinion     - de pelicula a opinion (0,n) a una pelicula se 
                                       adjuntan entre ninguna y muchas opiniones
                                     - de opinion a pelicula (1,1) una opinión se 
                                       adjunta a una sola pelicula

pelicula    "presenta"   persona     - de pelicula a persona (1,n) en cada pelicula se
                                       presentan una o muchas personas
                                     - de persona a pelicula (1,n) cada persona se  
                                       presenta en una o muchas peliculas  

persona     "interpreta" personaje   - de persona a personaje (0,n) cada persona interpreta
                                       entre ninguno y muchos personajes
                                     - de personaje a persona (1,n) cada personaje es  
                                       interpretado por una o muchas personas
                                        

------------------------------------------------------------------------------------------ 
Creación de las tablas en MySQL

CREATE TABLE cine (
    nombCine CHARACTER(50) NOT NULL PRIMARY KEY,
    direccion CHARACTER(50) NOT NULL,
    telefono INT NOT NULL
);

CREATE TABLE sala (
    nomb_Cine CHARACTER(50) NOT NULL,
    idSala BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombSala CHARACTER(10) NOT NULL,
    cantButacas SMALLINT NOT NULL,
    FOREIGN KEY(nomb_Cine) REFERENCES cine(nombCine)
);

CREATE TABLE pelicula (
    idPelicula BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    tituloDistrib CHARACTER(50) NOT NULL,
    tituloOriginal CHARACTER(50) NOT NULL,
    genero CHARACTER(20) NOT NULL,
    idioma CHARACTER(15) NOT NULL,
    subEsp CHARACTER(2) NOT NULL,
    pais CHARACTER(20),
    año SMALLINT,
    url CHARACTER(50),
    duracion TIME NOT NULL,
    calificacion CHARACTER(23) NOT NULL,
    fechaEstreno DATE NOT NULL,
    resumen VARCHAR(1316)
);

CREATE TABLE funcion (
    idFuncion BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    dia CHARACTER(9) NOT NULL,
    hora TIME NOT NULL,
    id_Sala BIGINT NOT NULL,
    id_Pel BIGINT NOT NULL,
    FOREIGN KEY(id_Sala) REFERENCES sala(idSala),
    FOREIGN KEY(id_Pel) REFERENCES pelicula(idPelicula)
);

CREATE TABLE persona (
    id_Pelicula BIGINT NOT NULL,
    nombPer CHARACTER(50) NOT NULL PRIMARY KEY,
    cargo CHARACTER(14) NOT NULL,
    nacionalidad CHARACTER(30),
    cantPelDirig SMALLINT,
    cantPelAct SMALLINT,
    FOREIGN KEY(id_Pelicula) REFERENCES pelicula(idPelicula)
);

CREATE TABLE personaje (
    idPersonaje BIGINT NOT NULL PRIMARY KEY,
    nombPersonaje CHARACTER(50) NOT NULL,
    nomb_Per CHARACTER(50) NOT NULL,
    id_Peli BIGINT NOT NULL,
    FOREIGN KEY(id_Peli) REFERENCES pelicula(idPelicula)
);

CREATE TABLE promocion (
    idPromocion BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    descripcion CHARACTER(100) NOT NULL,
    descuento TINYINT NOT NULL,
    id_Funcion BIGINT NOT NULL,
    FOREIGN KEY(id_Funcion) REFERENCES funcion(idFuncion)
);

CREATE TABLE opinion (
    id_Pelic BIGINT NOT NULL,
    idOpinion BIGINT AUTO_INCREMENT NOT NULL,
    nombreOp CHARACTER(50),
    edadOp TINYINT,
    fechaOp DATE NOT NULL,
    calificacionOp CHARACTER(12) NOT NULL,
    comentario CHARACTER(150),
    PRIMARY KEY(idOpinion, id_Pelic),
    FOREIGN KEY(id_Pelic) REFERENCES pelicula(idPelicula)
);

------------------------------------------------------------------------------------------


******************************************************************************************