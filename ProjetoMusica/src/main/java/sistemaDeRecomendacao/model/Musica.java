package sistemaDeRecomendacao.model;

import java.sql.SQLException;

import sistemaDeRecomendacao.dao.MusicaDAO;

public class Musica {
	int IdMusica;
	String nomeMusica;
	GeneroMusical genero;

	public Musica(String nome, int Id, int IdGenero) {
		this.IdMusica = Id;
		this.nomeMusica = nome;
		MusicaDAO musicaDao = new MusicaDAO();
	}
}
