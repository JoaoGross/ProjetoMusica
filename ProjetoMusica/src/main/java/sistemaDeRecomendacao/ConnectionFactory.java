package sistemaDeRecomendacao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnectionFactory {
	private String usuario = "root";
	private String senha = "261199";
	private String host = "localhost";
	private String porta = "3306";
	private String bd = "projeto";

	public Connection obterConexao (){
		try{
			Connection c = DriverManager.getConnection(
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
	}

	public static String pegarSenha (String nomeUsuario){
		String sql = "SELECT senha FROM tb_usuario WHERE nome = ?";

		String senhaUsuario = "";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			//3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			//4: Executa o comando e guarda
			//o resultado em um ResultSet
			ps.setString(1, nomeUsuario);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				senhaUsuario = rs.getString(1);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return senhaUsuario;
	}

	public static void salvarUsuario (String nomeUsuario, String senhaUsuario, GeneroMusical generoPreferido){
		String query = "insert into tb_usuario(Nome, Senha, FK_Id_generoPreferio) values(?, ?, ?);";

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, nomeUsuario);
			ps.setString(2, senhaUsuario);
			ps.setInt(3, generoPreferido.getId());
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public static int pegarIdUsuario(String nomeUsuario) {
		String query = "";
		int IdUsuario = 0;
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, nomeUsuario);
			ResultSet rs = ps.executeQuery();
			IdUsuario = rs.getInt(1);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return IdUsuario;
	}
	
	public static ArrayList<GeneroMusical> pegarGenerosPreferidos(int id_usuario, String nomeUsuario){
		ArrayList<GeneroMusical> GenerosPreferidos = new ArrayList<>();
		String query = "";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);

		}
		catch (Exception e){
			e.printStackTrace();
		}
		return GenerosPreferidos;

	}
	
	public static GeneroMusical[] obterGeneros() {
		GeneroMusical[] generos = new GeneroMusical[4];
		String query = "SELECT nome_genero From tb_genero";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				String nome = rs.getString("nome_genero");
				GeneroMusical genero = new GeneroMusical(nome);
				generos[i] = genero;
				i++;
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return generos;

	}
	
	public static int obterIdGenero(String nomeGenero) {
		String query = "SELECT Id_genero FROM tb_genero Where nome_genero = ?";
		int IdGenero = 0;
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, nomeGenero);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				IdGenero = rs.getInt(1);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return IdGenero;
	}

	public static ArrayList<Musica> pegarNaoAvaliadas(int id_usuario, int id_genero){
		ArrayList<Musica> musicasNaoAvaliadas = new ArrayList<>();
		String query = "SELECT m.Id_musica ,m.nome_musica FROM tb_musicas m WHERE m.Id_musica NOT IN (SELECT Id_musica FROM tb_avaliacoes WHERE id_usuario = ?) AND m.Id_genero = ?;";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);

			ps.setInt(1, id_usuario);
			ps.setInt(2, id_genero);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int Id = rs.getInt("id_musica");
				String nome = rs.getString("nome");
				Musica musica = new Musica(Id, nome);
				musicasNaoAvaliadas.add(musica);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return musicasNaoAvaliadas;

	}
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


	

}
