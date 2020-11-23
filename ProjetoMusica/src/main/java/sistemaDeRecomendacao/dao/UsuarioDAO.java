package sistemaDeRecomendacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.model.GeneroMusical;

public class UsuarioDAO {
	
	public void cadastrarUsuario (String nomeUsuario, String senhaUsuario){
		String query = "insert into tb_usuario(username, senha) values(?, ?);";

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, nomeUsuario);
			ps.setString(2, senhaUsuario);
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void cadastrarGenero (int IdUsuario, int IdGenero){
		String query = "insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values ( ?, ?);";

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, IdUsuario);
			ps.setInt(2, IdGenero);
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public int pegarIdUsuario(String nomeUsuario) {
		String query = "Select Id_usuario from tb_usuario where userName = ?;";
		int IdUsuario = 0;
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, nomeUsuario);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				IdUsuario = rs.getInt(1);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return IdUsuario;
	}
	
	public String pegarSenha (String nomeUsuario){
		String sql = "SELECT senha FROM tb_usuario WHERE userName = ?";

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
	
	public ArrayList<GeneroMusical> pegarGenerosPreferidos(int id_usuario){
		ArrayList<GeneroMusical> generosPreferidos = new ArrayList<>();
		String query = "Select g.nome_genero, g.Id_genero from tb_genero g where g.Id_genero in (SELECT FK_Id_generoPreferido FROM tb_generoUsuario where FK_Id_userName = ?);";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, id_usuario);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String nomeGenero = rs.getString(1);
				int idGenero = rs.getInt(2);
				generosPreferidos.add(new GeneroMusical(nomeGenero, idGenero));
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return generosPreferidos;

	}
}
