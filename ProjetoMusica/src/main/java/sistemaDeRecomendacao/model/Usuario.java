package sistemaDeRecomendacao.model;
import java.util.ArrayList;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.dao.MusicaDAO;
import sistemaDeRecomendacao.dao.UsuarioDAO;

public class Usuario {
	int idUsuario;
	String nomeUsuario;
	String senha;
	GeneroMusical[] generosPreferidos;
	
	//Login
	public Usuario(String nomeUsuario, String senha) throws Exception{
		UsuarioDAO login = new UsuarioDAO();
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.idUsuario = login.pegarIdUsuario(nomeUsuario);
		this.generosPreferidos = login.pegarGenerosPreferidos(idUsuario);
	}
	
	public String getNome(){
		return nomeUsuario;
	}
	
	public int getId() {
		return idUsuario;
	}
	
	public GeneroMusical[] getGenerosPreferidos(){
		return generosPreferidos;
	}
	
	public Musica[] getMusicasUsuario() {
		int qtdMusicas = 0;
		int qtd = generosPreferidos.length -1;
		
		for(int i=0; i<= qtd; i++) {
			int musicas = generosPreferidos[i].getMusicas().length;
			qtdMusicas += musicas;
		}
		Musica[] musicas = new Musica[qtdMusicas];
		int cont = 0;
		for(int i=0; i<= qtd; i++) {
			System.arraycopy(generosPreferidos[i].getMusicas(), 0, musicas, cont, generosPreferidos[i].getMusicas().length);
			cont += generosPreferidos[i].getMusicas().length;
		}
		return musicas;
	}
	public ArrayList<Musica> recomendar(){
		MusicaDAO musica = new MusicaDAO();
		ArrayList<Musica> recomendacoes = new ArrayList<>();
		for(int i = 0; i<= generosPreferidos.length; i++) {
			recomendacoes.addAll(musica.pegarNaoAvaliadas(idUsuario, generosPreferidos[i].getId()));
		}
		
		return recomendacoes;
	}
	

}
