package sistemaDeRecomendacao.model;

import java.sql.SQLException;

import sistemaDeRecomendacao.dao.GeneroMusicalDAO;
import sistemaDeRecomendacao.dao.MusicaDAO;

public class Musica {
	int idMusica;
	String nomeMusica;
	GeneroMusical genero;
	int nota = 0;

	public Musica(String nome, int idMusica) throws Exception {
		this.idMusica = idMusica;
		this.nomeMusica = nome;
		MusicaDAO musicaDao = new MusicaDAO();
		this.nota = musicaDao.obterNota(idMusica);
	}
	
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public int getId() {
		return idMusica;
	}
	
	public int getNota() {
		return nota;
	}
	@Override
	public String toString() {
		return nomeMusica;
	}
	
}
