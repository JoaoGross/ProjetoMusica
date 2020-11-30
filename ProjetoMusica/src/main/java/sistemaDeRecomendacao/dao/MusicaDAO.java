package sistemaDeRecomendacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.model.GeneroMusical;
import sistemaDeRecomendacao.model.Musica;
import sistemaDeRecomendacao.model.Usuario;

public class MusicaDAO {

	public Musica[] obterNaoAvaliadas(Usuario usuario) throws Exception {
		String query = "Select m.nome_musica, m.Id_musica from tb_musicas m where m.Id_musica Not in "
				+ "(SELECT FK_Id_musica FROM tb_avaliacoes where FK_Id_userName = ?) "
				+ "AND m.Id_musica in "
				+ "(SELECT FK_Id_musica from tb_generoMusicas where FK_Id_genero in "
				+ "(SELECT FK_Id_generoPreferido FROM tb_generoUsuario where FK_Id_userName = ?));";
		ConnectionFactory conexao = new ConnectionFactory();
		try (Connection conn = conexao.obterConexao()) {
			PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ps.setInt(1, usuario.getId());
			ps.setInt(2, usuario.getId());
			ResultSet rs = ps.executeQuery();
			rs.last();
			int totalDeMusicas =  rs.getRow();
			Musica[] musicas = new Musica[totalDeMusicas];
			rs.beforeFirst();
			int contador = 0;
			while (rs.next()) {
				String nome = rs.getString(1);
				int idMusica= rs.getInt(2);
				musicas[contador] = new Musica(nome, idMusica);
				contador++;
			}
			return musicas;
		}
	}
	
	public Musica[] obterAvaliadas(Usuario usuario) throws Exception {
		//obter musicas por genero
		String query = "Select m.nome_musica, m.Id_musica  from tb_musicas m where m.Id_musica in "
				+ "(SELECT FK_Id_musica FROM tb_avaliacoes where FK_Id_userName = ?);";
		ConnectionFactory conexao = new ConnectionFactory();
		try (Connection conn = conexao.obterConexao()) {
			PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ps.setInt(1, usuario.getId());
			ResultSet rs = ps.executeQuery();
			rs.last();
			int totalDeMusicas =  rs.getRow();
			Musica[] musicas = new Musica[totalDeMusicas];
			rs.beforeFirst();
			int contador = 0;
			while (rs.next()) {
				String nome = rs.getString(1);
				int idMusica= rs.getInt(2);
				musicas[contador] = new Musica(nome, idMusica);
				contador++;
			}
			return musicas;
		}
	}
	
//	String query = "Select nome_musica, Id_musica, FK_Id_genero from tb_musicas m where m.Id_musica Not in "
//			+ "(SELECT FK_Id_musica FROM tb_avaliacoes where FK_Id_userName = ?)"
//			+ "AND m.FK_Id_genero in (SELECT FK_Id_generoPreferido FROM tb_generoUsuario where FK_Id_userName = ?);";

	public void avaliarMusica(Musica musicaAvaliada, int nota, Usuario usuario) throws Exception{
		String query = "insert into tb_avaliacoes (FK_Id_userName,FK_Id_musica,nota_musica) values (?, ?,?);";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, usuario.getId());
			ps.setInt(2, musicaAvaliada.getId());
			ps.setInt(3, nota);
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void atualizarNota(String nomeMusica, int nota, Usuario usuario) throws Exception{
		String query = "UPDATE tb_avaliacoes SET nota_musica = ? where FK_Id_musica in "
				+ "(select Id_musica from tb_musicas where nome_musica = ?) And FK_Id_userName = ?;";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, nota);
			ps.setString(2, nomeMusica);
			ps.setInt(3,usuario.getId());
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Insira apenas valores inteiros de 1 à 5");
		}
	}
	
	public double obterNotaMedia(int idMusica) throws Exception{
		double nota = 0;
		String query = "select AVG(nota_musica) from tb_avaliacoes where FK_Id_musica = ?;";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, idMusica);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				nota = rs.getDouble(1);
			}
			return nota;
		}
	}
	
	public int obterNotaUsuario(int idUsuario, int idMusica) throws Exception{
		int nota = 0;
		String query = "select nota_musica from tb_avaliacoes where FK_Id_userName = ? AND FK_Id_musica = ?;";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, idUsuario);
			ps.setInt(2, idMusica);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				nota = rs.getInt(1);
			}
			return nota;
		}
	}

//	public GeneroMusical obterGenero(int idGenero) throws Exception {
//		String sql = "SELECT nome_genero FROM tb_genero where Id_genero =?";
//		ConnectionFactory conexao = new ConnectionFactory();
//		GeneroMusical genero = new GeneroMusical();
//		try (Connection conn = conexao.obterConexao()) {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, idGenero);
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//				String nomeGenero = rs.getString(1);
//				genero = new GeneroMusical(nomeGenero, idGenero);
//			}
//			return genero;
//		}
//	}
		//	select AVG(nota_musica) from tb_avaliacoes where FK_Id_musica = ?;


		//	public GeneroMusical pegarGenero(int IdMusica) {
		//		String query = "Select FK_Id_genero from tb_musicas where Id_musica = ?";
		//		
		//		ConnectionFactory factory = new ConnectionFactory();
		//		try (Connection c = factory.obterConexao()){
		//			PreparedStatement ps = c.prepareStatement(query);
		//			ps.setInt(1, IdMusica);
		//			ResultSet rs = ps.executeQuery();
		//			int	idGenero = rs.getInt(1);
		//			GeneroMusical genero = new GeneroMusical(idGenero);
		//			return genero;
		//		}
		//	}
	
}