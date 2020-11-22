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

	public GeneroMusical pegarGenero() throws SQLException {
		String query = "";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obterConexao()){
			//3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(query);
			//4: Executa o comando e guarda
			//o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			int	idGenero = rs.getInt(1);
			String	nomeGenero = rs.getString(2);
			GeneroMusical genero = new GeneroMusical(nomeGenero, idGenero);
			return genero;
		}
	}
}
