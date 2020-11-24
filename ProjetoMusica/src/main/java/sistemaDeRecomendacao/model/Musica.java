package sistemaDeRecomendacao.model;

import java.sql.SQLException;

import sistemaDeRecomendacao.dao.GeneroMusicalDAO;
import sistemaDeRecomendacao.dao.MusicaDAO;

public class Musica {
	int idMusica;
	String nomeMusica;
	GeneroMusical genero;

	public Musica(String nome, int idMusica, int idGenero) throws Exception {
		this.idMusica = idMusica;
		this.nomeMusica = nome;
		MusicaDAO generoMusica = new MusicaDAO();
		this.genero = generoMusica.obterGenero(idGenero);
	}
	
	
}
