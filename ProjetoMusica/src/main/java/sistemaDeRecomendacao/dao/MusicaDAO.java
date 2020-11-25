package sistemaDeRecomendacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.model.GeneroMusical;
import sistemaDeRecomendacao.model.Musica;
import sistemaDeRecomendacao.model.Usuario;

public class MusicaDAO {

	public ArrayList<Musica> pegarNaoAvaliadas(int id_usuario, int id_genero){
		ArrayList<Musica> musicasNaoAvaliadas = new ArrayList<>();
		String query = "Select nome_musica, Id_musica, FK_Id_genero from tb_musicas m where m.Id_musica Not in (SELECT FK_Id_musica FROM tb_avaliacoes where FK_Id_userName = ?)"
				+ "AND m.FK_Id_genero in (SELECT FK_Id_generoPreferido FROM tb_generoUsuario where FK_Id_userName = ?);";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);

			ps.setInt(1, id_usuario);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String nome = rs.getString(1);
				int idMusica = rs.getInt(2);
				Musica musica = new Musica(nome, idMusica);
				musicasNaoAvaliadas.add(musica);
			}
		}
		catch (Exception e){
			e.printStackTrace();

		}
		return musicasNaoAvaliadas;

	}

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
	
	public void atualizarNota(Musica musicaAvaliada, int nota, Usuario usuario) throws Exception{
		String query = "UPDATE tb_avaliacoes SET nota_musica = ? WHERE FK_Id_userName = ? and FK_Id_musica = ?;";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, nota);
			ps.setInt(2,usuario.getId());
			ps.setInt(3, musicaAvaliada.getId());
			ps.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public int obterNota(int idMusica) throws Exception{
		int nota = 0;
		String query = "Select nota_musica from tb_avaliacoes WHERE FK_Id_musica = ?;";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, idMusica);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				nota = rs.getInt(1);
			}
			return nota;
		}
	}

	public GeneroMusical obterGenero(int idGenero) throws Exception {
		String sql = "SELECT nome_genero FROM tb_genero where Id_genero =?";
		ConnectionFactory conexao = new ConnectionFactory();
		GeneroMusical genero = new GeneroMusical();
		try (Connection conn = conexao.obterConexao()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idGenero);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String nomeGenero = rs.getString(1);
				genero = new GeneroMusical(nomeGenero, idGenero);
			}
			return genero;
		}
	}
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