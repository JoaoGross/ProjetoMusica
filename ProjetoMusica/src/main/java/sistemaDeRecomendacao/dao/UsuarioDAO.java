package sistemaDeRecomendacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.model.GeneroMusical;

public class UsuarioDAO {
	
	public void salvarUsuario (String nomeUsuario, String senhaUsuario, GeneroMusical generoPreferido){
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
	
	public int pegarIdUsuario(String nomeUsuario) {
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
	
	public String pegarSenha (String nomeUsuario){
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
	
	public ArrayList<GeneroMusical> pegarGenerosPreferidos(int id_usuario, String nomeUsuario){
		ArrayList<GeneroMusical> generosPreferidos = new ArrayList<>();
		String query = "select * from table";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(parameterIndex, x);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String nomeGenero = rs.getString("nome_genero");
				int idGenero = rs.getInt("Id_genero");
				generosPreferidos.add(new GeneroMusical(nomeGenero, idGenero));
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return generosPreferidos;

	}
}
