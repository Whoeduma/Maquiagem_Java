CREATE schema Duda_coiffeur;
USE Duda_coiffeur;

CREATE table maquiagem (
	id 	int primary key auto_increment, 
    marca varchar(100),
    tipo varchar(100),
    cor varchar(100)
);