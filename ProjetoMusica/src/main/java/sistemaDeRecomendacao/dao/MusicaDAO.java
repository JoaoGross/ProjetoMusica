package sistemaDeRecomendacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.model.GeneroMusical;
import sistemaDeRecomendacao.model.Musica;

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
				int idGenero = rs.getInt(3);
				Musica musica = new Musica(nome, idMusica, idGenero);
				musicasNaoAvaliadas.add(musica);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return musicasNaoAvaliadas;

	}
	
//	public Musica[] obterMusicas() throws Exception {
//		String sql = "SELECT Id_genero, nome_musica FK_Id_genero FROM tb_musicas";
//		ConnectionFactory conexao = new ConnectionFactory();
//		try (Connection conn = conexao.obterConexao();
//				PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
//						ResultSet.CONCUR_READ_ONLY);
//				ResultSet rs = ps.executeQuery()) {
//			int totalDeMusica = rs.last() ? rs.getRow() : 0;
//			Musica[] musicas = new Musica[totalDeMusica];
//			rs.beforeFirst();
//			int contador = 0;
//			while (rs.next()) {
//				int idMusica= rs.getInt(1);
//				String nome = rs.getString(2);
//				int idGenero = rs.getInt(3);
//				musicas[contador++] = new Musica(nome, idMusica, idGenero);
//			}
//			return musicas;
//		}
//	}
	
	public GeneroMusical obterGenero(int idGenero) throws Exception {
		String sql = "SELECT nome_genero FROM tb_genero where Id_genero =?";
		ConnectionFactory conexao = new ConnectionFactory();
		try (Connection conn = conexao.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(idGenero, 1);
			ResultSet rs = ps.executeQuery();
			String nomeGenero = rs.getString(1);
			GeneroMusical genero = new GeneroMusical(nomeGenero, idGenero);
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
