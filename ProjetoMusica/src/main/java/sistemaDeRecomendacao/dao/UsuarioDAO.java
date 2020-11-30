package sistemaDeRecomendacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.model.GeneroMusical;
import sistemaDeRecomendacao.model.Usuario;

public class UsuarioDAO {
	
	public boolean existe(Usuario usuario) throws Exception {
		String sql = "SELECT * FROM tb_usuario WHERE userName= ? AND Senha = ?";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection conn = factory.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		}
	}

	public void cadastrarUsuario (String nomeUsuario, String senhaUsuario){
		String query = "insert into tb_usuario(userName, Senha) values(?, ?);";

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, nomeUsuario);
			ps.setString(2, senhaUsuario);
			ps.execute();
			JOptionPane.showMessageDialog(null, "Usuario Criado com sucesso");
		}
		catch (SQLIntegrityConstraintViolationException e){
			JOptionPane.showMessageDialog(null, "nome de usuario j· existe");
			e.printStackTrace();
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

	public int obterIdUsuario(String nomeUsuario) throws Exception{
		String query = "select Id_usuario from tb_usuario where userName = ?";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			int idUsuario = -1;
			ps.setString(1, nomeUsuario);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				idUsuario = rs.getInt(1);
			}
			return idUsuario;
		}
	}

	public String pegarSenha (String nomeUsuario){
		String sql = "SELECT Senha FROM tb_usuario WHERE userName = ?";

		String senhaUsuario = "";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			//3: Pr√© compila o comando
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


	public GeneroMusical[] pegarGenerosPreferidos(int id_usuario) throws Exception {
		String sql = "Select g.nome_genero, g.Id_genero from tb_genero g where g.Id_genero in "
				+ "(SELECT FK_Id_generoPreferido FROM tb_generoUsuario where FK_Id_userName = ?);";
		ConnectionFactory conexao = new ConnectionFactory();
		try (Connection conn = conexao.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);) {
			ps.setInt(1, id_usuario);
			ResultSet rs = ps.executeQuery();
			rs.last();
			int totalDeGeneros = rs.getRow();
			GeneroMusical[] generosPreferidos = new GeneroMusical[totalDeGeneros];
			rs.beforeFirst();
			int contador = 0;
			while (rs.next()) {
				String nome = rs.getString(1);
				int id= rs.getInt(2);
				generosPreferidos[contador] = new GeneroMusical(nome, id);
				contador++;
			}
			return generosPreferidos;
		}
	}

	public GeneroMusical[] obterGenerosNaoFavoritos(int id_usuario) throws Exception {
		String sql = "SELECT nome_genero, Id_genero FROM tb_genero where Id_genero Not in "
				+ "(Select g.Id_genero from tb_genero g where g.Id_genero in "
				+ "(SELECT FK_Id_generoPreferido FROM tb_generoUsuario where FK_Id_userName = ?));";
		ConnectionFactory conexao = new ConnectionFactory();
		try (Connection conn = conexao.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);) {
			ps.setInt(1, id_usuario);
			ResultSet rs = ps.executeQuery();
			rs.last();
			int totalDeGeneros = rs.getRow();
			GeneroMusical[] generos = new GeneroMusical[totalDeGeneros];
			rs.beforeFirst();
			int contador = 0;
			while (rs.next()) {
				String nome = rs.getString(1);
				int id= rs.getInt(2);
				generos[contador++] = new GeneroMusical(nome, id);
			}
			return generos;
		}
	}
	
	public void adicionarGeneroPreferido(GeneroMusical novoGenero, Usuario usuario) throws Exception{
		String query = "insert into tb_generoUsuario (FK_Id_userName,FK_Id_generoPreferido) values (?, ?);";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, usuario.getId());
			ps.setInt(2, novoGenero.getId());
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void excluirGeneroPreferido(GeneroMusical generoExcluido, Usuario usuario) throws Exception{
		String query = "delete from tb_generoUsuario WHERE FK_Id_userName = ? AND FK_Id_generoPreferido = ?;";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, usuario.getId());
			ps.setInt(2, generoExcluido.getId());
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
