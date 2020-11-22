package sistemaDeRecomendacao.model;
import java.util.ArrayList;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.dao.MusicaDAO;
import sistemaDeRecomendacao.dao.UsuarioDAO;

public class Usuario {
	int idUsuario;
	String nomeUsuario;
	String senha;
	ArrayList<GeneroMusical> generosPreferidos;
	
	//Login
	public Usuario(String nomeUsuario, String senha){
		UsuarioDAO login = new UsuarioDAO();
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.idUsuario = login.pegarIdUsuario(nomeUsuario);
		this.generosPreferidos = login.pegarGenerosPreferidos(idUsuario, nomeUsuario);
	}
	
	public String getNome(){
		return nomeUsuario;
	}
	
	public ArrayList<Musica> recomendar(){
		MusicaDAO musica = new MusicaDAO();
		ArrayList<Musica> recomendacoes = new ArrayList<>();
		for(int i = 0; i<= generosPreferidos.size(); i++) {
			recomendacoes.addAll(musica.pegarNaoAvaliadas(idUsuario, generosPreferidos.get(i).getId()));
		}
		
		return recomendacoes;
	}

}
