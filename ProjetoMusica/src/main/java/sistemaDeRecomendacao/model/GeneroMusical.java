package sistemaDeRecomendacao.model;
import java.util.ArrayList;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.dao.GeneroMusicalDAO;

public class GeneroMusical {
	int id;
	String nomeGenero;
	Musica[] musicas;
	
	
	public GeneroMusical(String nome, int id) throws Exception {
		GeneroMusicalDAO genero = new GeneroMusicalDAO();
		this.nomeGenero = nome;
		this.id = id;
		this.musicas = genero.obterMusicas(id);
	}
	
	public int getId() {
		return id;
	}
	public Musica[] getMusicas() {
		return musicas;
	}
	
	@Override
	public String toString() {
		return nomeGenero;
	}
}
