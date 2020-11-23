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
