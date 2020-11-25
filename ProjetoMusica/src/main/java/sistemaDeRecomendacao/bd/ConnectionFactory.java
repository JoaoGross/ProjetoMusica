package sistemaDeRecomendacao.bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sistemaDeRecomendacao.model.GeneroMusical;
import sistemaDeRecomendacao.model.Musica;

public class ConnectionFactory {
	private String usuario = "root";
	private String senha = "261199";
	private String host = "localhost";
	private String porta = "3306";
	private String bd = "projeto";

	public Connection obterConexao () throws Exception{
		Connection c = null;
		try{
			c = DriverManager.getConnection(
					"jdbc:mysql://" + host + ":" + porta + "/" + bd  + "?useTimezone=true&serverTimezone=UTC",
					usuario,
					senha
					);
			return c;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}}
	/*Banco:
	 * Tabela tb_usuarios(Id_usuario, Nome, Senha, FK_Id_generoPreferio)
	 * Tabel tb_musicas(Id_musica, nome_musica, Id_genero)
	 * tb_avaliacoes(Id_usuario, Id_musica, nota_musica) ----- select Id_musica, nota from a.tb_avaliacoes A LEFT JOIN where not I
	 * tb_genero(Id_genero, nome_genero)
	 * Query criar banco de dados = 
create database projeto;	 
use projeto;

CREATE TABLE tb_genero (
	Id_genero int not null auto_increment,
    nome_genero char(50),
    primary key (Id_genero)
);

CREATE TABLE tb_usuario (
	Id_usuario int not null auto_increment,
    Nome char(100),
    Senha char(16),
    primary key (Id_usuario),
	FK_Id_generoPreferio int ,
	foreign key (FK_Id_generoPreferio) references tb_genero (Id_genero)
);

CREATE TABLE tb_musicas (
	Id_musica int not null auto_increment,
    nome_musica char(100),
    Primary key (Id_musica),
    Id_genero int,
	foreign key (Id_genero) references tb_genero (Id_genero)
);

CREATE TABLE tb_avaliacoes (
	Id_usuario int,
	foreign key (Id_usuario) references tb_usuario (Id_usuario),
    Id_musica int,
    foreign key (Id_musica) references tb_musicas (Id_musica),
    nota_musica int
);

insert into tb_genero (nome_genero) values ("Rock");
insert into tb_genero (nome_genero) values ("Blues");
insert into tb_genero (nome_genero) values ("Jazz");

insert into tb_musicas (nome_musica,Id_genero) values ("All Blues", "5");
insert into tb_musicas (nome_musica,Id_genero) values ("ACDC HELL", "3");
insert into tb_musicas (nome_musica,Id_genero) values ("Blue River", "5");

insert into tb_usuario (Nome,Senha,FK_Id_generoPreferio) values ("Joãozinho", "12345","5");

insert into tb_avaliacoes (Id_usuario,Id_musica,nota_musica) values ("1", "1","5");
	 */


	


