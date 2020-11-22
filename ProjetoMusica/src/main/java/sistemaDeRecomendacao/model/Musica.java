package sistemaDeRecomendacao.model;

import java.sql.SQLException;

import sistemaDeRecomendacao.dao.MusicaDAO;

public class Musica {
	int Id;
	String nome;
	GeneroMusical genero;

	public Musica(int Id, String nome) {
		this.Id = Id;
		this.nome = nome;
		MusicaDAO musicaDao = new MusicaDAO();
		try {
			this.genero = musicaDao.pegarGenero();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
