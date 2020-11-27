package sistemaDeRecomendacao.bd;
import java.sql.Connection;
import java.sql.DriverManager;

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

CREATE TABLE tb_musicas (
    Id_musica int not null auto_increment,
    nome_musica char(100),
    Primary key (Id_musica),
    FK_Id_genero int,
    foreign key (FK_Id_genero) references tb_genero (Id_genero)
);

CREATE TABLE tb_usuario (
    Id_usuario int not null auto_increment,
    userName char(100) NOT NULL,
    Senha char(16),
    primary key (Id_usuario),
    UNIQUE (userName)
);

CREATE TABLE tb_generoUsuario (
    FK_Id_userName int,
    foreign key (FK_Id_userName) references tb_usuario (Id_usuario),
    FK_Id_generoPreferido int,
    foreign key (FK_Id_generoPreferido) references tb_genero (Id_genero)
);

CREATE TABLE tb_avaliacoes (
    FK_Id_userName int,
    foreign key (FK_Id_userName) references tb_usuario (Id_usuario),
    FK_Id_musica int,
    foreign key (FK_Id_musica) references tb_musicas (Id_musica),
    nota_musica int check (nota_musica > 0 AND nota_musica < 6)
);

insert into tb_genero (nome_genero) values ("Rock");
insert into tb_genero (nome_genero) values ("Blues");
insert into tb_genero (nome_genero) values ("Jazz");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("The Hollies - Long Cool Woman", "1");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("the greg kihn band - the breakup song", "1");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("ccr - who'll stop the rain", "1");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("the doors - gloria", "1");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("the rolling stones - she's so cold", "1");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("ZZ Top - La Grange", "2");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("Five Finger Death Punch - Blue On Black", "2");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("ZZ Top - I Gotsta Get Paid", "2");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("Eric Clapton - Wonderful Tonight ", "2");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("Chain Breaker (tradução) - Zach Williams", "2");

insert into tb_musicas (nome_musica,FK_Id_genero) values ("Sweet Georgia Brown - E. Hines and His Orchestra", "3");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("Bugle Call Rag - B. Goodman and His Orchestra", "3");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("Gary B.B. Coleman - The Sky is Crying", "3");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("A-Tisket, A-Tasket - E. Fitzgerald acc. by C. Webb and His Orchestra", "3");
insert into tb_musicas (nome_musica,FK_Id_genero) values ("Cocktails for Two - T. Dorsey and His Orchestra", "3");
insert into tb_usuario (userName,Senha) values ("Icaro", "12345");
insert into tb_usuario (userName,Senha) values ("Lucas", "00000");
insert into tb_usuario (userName,Senha) values ("Richinei", "54321");

insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ("1","3");
insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ("1","2");
insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ("2","1");
insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ("3","1");
insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ("3","3");

insert into tb_avaliacoes (FK_Id_userName,FK_Id_musica,nota_musica) values ("1", "12","4");
insert into tb_avaliacoes (FK_Id_userName,FK_Id_musica,nota_musica) values ("1", "13","3");
insert into tb_avaliacoes (FK_Id_userName,FK_Id_musica,nota_musica) values ("2", "9","3");
	 */


	


