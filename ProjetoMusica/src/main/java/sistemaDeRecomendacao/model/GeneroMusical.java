package sistemaDeRecomendacao.model;
import java.util.ArrayList;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.dao.GeneroMusicalDAO;

public class GeneroMusical {
	int id;
	String nomeGenero;
	ArrayList<Musica> musicas;
	
	public GeneroMusical(String nome, int id) {
		GeneroMusicalDAO genero = new GeneroMusicalDAO();
		this.nomeGenero = nome;
		this.id = id;
//		this.musicas = genero.pegarMusicas();
	}
	
	public GeneroMusical(int id) {
		GeneroMusicalDAO genero = new GeneroMusicalDAO();
		this.id = id;
//		this.nomeGenero = nome;
	}
	public int getId() {
		return id;
	}
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}
	
	@Override
	public String toString() {
		return nomeGenero;
	}
}
