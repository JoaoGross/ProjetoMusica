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
	
	public ArrayList<Musica> recomendar(){
		MusicaDAO musica = new MusicaDAO();
		ArrayList<Musica> recomendacoes = new ArrayList<>();
		for(int i = 0; i<= generosPreferidos.length; i++) {
			recomendacoes.addAll(musica.pegarNaoAvaliadas(idUsuario, generosPreferidos[i].getId()));
		}
		
		return recomendacoes;
	}
	
	public GeneroMusical[] getGenerosPreferidos(){
		return generosPreferidos;
	}

}
