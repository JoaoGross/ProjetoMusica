package sistemaDeRecomendacao.model;
import java.util.ArrayList;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.dao.GeneroMusicalDAO;

public class GeneroMusical {
	int id;
	String nomeGenero;
	Musica[] musicas;
	
	
	public GeneroMusical() throws Exception {
		
	}
	public GeneroMusical(String nome, int id) throws Exception {
		GeneroMusicalDAO genero = new GeneroMusicalDAO();
		this.nomeGenero = nome;
		this.id = id;
		this.musicas = genero.obterMusicas(id);
	}
	
//	public void preencherMusicas(int generohhh) {
//		GeneroMusicalDAO genero = new GeneroMusicalDAO();
//		try {
//			musicas = genero.obterMusicas(generohhh);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
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
