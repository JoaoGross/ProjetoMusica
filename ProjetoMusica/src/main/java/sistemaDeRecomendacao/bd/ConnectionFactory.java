package sistemaDeRecomendacao.bd;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private String usuario = "root";
	private String senha = "senha";
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
	
Drop database projeto;
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

CREATE TABLE tb_generoMusicas (
    FK_Id_musica int,
    foreign key (FK_Id_musica) references tb_musicas (Id_musica),
    FK_Id_genero int,
    foreign key (FK_Id_genero) references tb_genero (Id_genero)
);

CREATE TABLE tb_usuario (
    Id_usuario int not null auto_increment,
    userName char(100) NOT NULL check ( userName != "" ),
    Senha char(16) NOT NULL check ( Senha != "" ),
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
    nota_musica int check ( nota_musica < 6 AND nota_musica > 0 )
);

insert into tb_genero (nome_genero) values ("Rock");
insert into tb_genero (nome_genero) values ("Blues");
insert into tb_genero (nome_genero) values ("Jazz");

insert into tb_musicas (nome_musica) values ("The Hollies - Long Cool Woman");
insert into tb_musicas (nome_musica) values ("the greg kihn band - the breakup song");
insert into tb_musicas (nome_musica) values ("ccr - who'll stop the rain");
insert into tb_musicas (nome_musica) values ("the doors - gloria");
insert into tb_musicas (nome_musica) values ("the rolling stones - she's so cold");

insert into tb_musicas (nome_musica) values ("ZZ Top - La Grange");
insert into tb_musicas (nome_musica) values ("Five Finger Death Punch - Blue On Black");
insert into tb_musicas (nome_musica) values ("ZZ Top - I Gotsta Get Paid");
insert into tb_musicas (nome_musica) values ("Eric Clapton - Wonderful Tonight");
insert into tb_musicas (nome_musica) values ("Chain Breaker (tradução) - Zach Williams");

insert into tb_musicas (nome_musica) values ("Sweet Georgia Brown - E. Hines and His Orchestra");
insert into tb_musicas (nome_musica) values ("Bugle Call Rag - B. Goodman and His Orchestra");
insert into tb_musicas (nome_musica) values ("Gary B.B. Coleman - The Sky is Crying");
insert into tb_musicas (nome_musica) values ("A-Tisket, A-Tasket - E. Fitzgerald acc. by C. Webb and His Orchestra");
insert into tb_musicas (nome_musica) values ("Cocktails for Two - T. Dorsey and His Orchestra");

-- Para mostrar o programa funcionando  = 
/*
insert into tb_genero (nome_genero) values ("Kpop");
insert into tb_musicas (nome_musica) values ("I cant stop me - Twice");
insert into tb_musicas (nome_musica) values ("Can't you see me - TXT");
insert into tb_musicas (nome_musica) values ("Shine - Pentagon");
insert into tb_musicas (nome_musica) values ("Love Shot - EXO");
insert into tb_musicas (nome_musica) values ("Dynamite - BTS");
*/
/*
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("1","1");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("2","1");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("3","1");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("4","1");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("5","1");

insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("6","2");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("7","2");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("8","2");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("9","2");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("10","2");

insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("11","3");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("12","3");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("13","3");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("14","3");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("15","3");

-- Exceções

insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("6","1");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("11","1");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("1","2");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("12","2");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("2","3");
insert into tb_generoMusicas (FK_Id_musica, FK_Id_genero) values ("7","3");

insert into tb_usuario (userName,Senha) values ("Joãozinho", "12345");
insert into tb_usuario (userName,Senha) values ("Lucas", "00000");
insert into tb_usuario (userName,Senha) values ("Richiney", "54321");

insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ("1","3");
insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ("1","2");
insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ("2","1");
insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ("3","1");
insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ("3","3");

insert into tb_avaliacoes (FK_Id_userName,FK_Id_musica,nota_musica) values ("1", "12","5");
insert into tb_avaliacoes (FK_Id_userName,FK_Id_musica,nota_musica) values ("1", "13","5");
insert into tb_avaliacoes (FK_Id_userName,FK_Id_musica,nota_musica) values ("2", "9","5");
	 */

	


