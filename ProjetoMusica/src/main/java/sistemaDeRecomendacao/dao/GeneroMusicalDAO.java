package sistemaDeRecomendacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
			rs.last();
			int totalDeGeneros =  rs.getRow();
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



	public Musica[] obterMusicas(int idGenero) throws Exception {
		//obter musicas por genero
		String sql = "SELECT nome_musica, Id_musica FROM tb_musicas WHERE FK_Id_genero = ?;";
		ConnectionFactory conexao = new ConnectionFactory();
		try (Connection conn = conexao.obterConexao()) {
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ps.setInt(1, idGenero);
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




}
