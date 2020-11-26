package sistemaDeRecomendacao.model;

import java.sql.SQLException;

import sistemaDeRecomendacao.dao.GeneroMusicalDAO;
import sistemaDeRecomendacao.dao.MusicaDAO;

public class Musica {
	int idMusica;
	String nomeMusica;
	GeneroMusical genero;
	double notaMedia;
	int notaUsuario;

	public Musica(String nome, int idMusica) throws Exception {
		this.idMusica = idMusica;
		this.nomeMusica = nome;
		MusicaDAO musicaDao = new MusicaDAO();
		this.notaMedia = musicaDao.obterNotaMedia(idMusica);
		this.notaUsuario = musicaDao.obterNotaUsuario(idMusica);
	}
	
	public void setNotaMedia(double nota) {
		this.notaMedia = nota;
	}
	
	public void setNotaUsuario(int nota) {
		this.notaMedia = nota;
	}
	
	public int getId() {
		return idMusica;
	}
	
	public String getNome() {
		return nomeMusica;
	}
	
	public double getNotaMedia() {
		return notaMedia;
	}
	
	public int getNotaUsuario() {
		return notaUsuario;
	}
	@Override
	public String toString() {
		return nomeMusica;
	}
	
}
