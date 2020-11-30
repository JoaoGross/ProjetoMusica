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
	
	public Usuario(String nomeUsuario, String senha, int idUsuario) throws Exception{
		UsuarioDAO login = new UsuarioDAO();
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.idUsuario = idUsuario;
		this.generosPreferidos = login.pegarGenerosPreferidos(idUsuario);
	}
	
	public String getNome(){
		return nomeUsuario;
	}
	
	public String getSenha(){
		return senha;
	}
	
	
	public int getId() {
		return idUsuario;
	}
	
	public GeneroMusical[] getGenerosPreferidos(){
		return generosPreferidos;
	}
}
