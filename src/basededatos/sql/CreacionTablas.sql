/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Antonio Manuel
 * Created: 23-abr-2019
 */

/*Creamos las tablas que formaran nuestra base de datos que utiizaremos más adelante*/

    CREATE TABLE EQUIPO (
        ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
        NOMBRE VARCHAR(50),
        ESCUDO VARCHAR(30),
        CONSTRAINT ID_EQUIPO_PK PRIMARY KEY (ID)
    );

    CREATE TABLE PILOTOS (
        ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
        NOMBRE VARCHAR(35) NOT NULL,
        APELLIDOS VARCHAR(50) NOT NULL,
        DNI CHAR(9) NOT NULL,
        EQUIPO INT NOT NULL,
        NUMTELEFONO CHAR (11),
        FECNACIMIENTO DATE NOT NULL,
        FOTO VARCHAR(35) NOT NULL,
        SALARIO DECIMAL(7,2),
        CATEGORIA VARCHAR(40) NOT NULL,
        CONSTRAINT ID_PILOTOS_PK PRIMARY KEY (ID),
        CONSTRAINT EQ_PILOTOS_FK FOREIGN KEY (EQUIPO) REFERENCES EQUIPO (ID)
    );

    
