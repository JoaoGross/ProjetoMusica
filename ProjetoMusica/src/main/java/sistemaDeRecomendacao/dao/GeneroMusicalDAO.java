package sistemaDeRecomendacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.model.GeneroMusical;
import sistemaDeRecomendacao.model.Musica;

public class GeneroMusicalDAO {

	public GeneroMusical[] obterGeneros() throws Exception {
		String sql = "SELECT nome_genero, Id_genero FROM tb_genero";
		ConnectionFactory conexao = new ConnectionFactory();
		try (Connection conn = conexao.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = ps.executeQuery()) {
			int totalDeGeneros = rs.last() ? rs.getRow() : 0;
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
	


//	public ArrayList<Musica> pegarMusicas() {
//		String query = "SELECT * from tb_musicas";
//		ArrayList<Musica> musicas = new ArrayList<>();
//		ConnectionFactory conexao = new ConnectionFactory();
//		try (Connection c = conexao.obterConexao()){
//			
//			PreparedStatement ps = c.prepareStatement(query);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				int idMusica = rs.getInt("Id_musica");
//				String nomeMusica = rs.getString("nome_musica");
////				Musica musica = new Musica(idMusica, nomeMusica);
////				musicas.add(musica);
//			}
//			
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		return musicas;
//	}
}
