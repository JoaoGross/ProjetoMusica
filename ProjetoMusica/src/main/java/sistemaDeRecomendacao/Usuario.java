package sistemaDeRecomendacao;
import java.util.ArrayList;

public class Usuario {
	int idUsuario;
	String nomeUsuario;
	String senha;
	ArrayList<GeneroMusical> generosPreferidos;
	
	//Login
	public Usuario(String nomeUsuario, String senha){
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.idUsuario = ConnectionFactory.pegarIdUsuario(nomeUsuario);
		this.generosPreferidos = ConnectionFactory.pegarGenerosPreferidos(idUsuario, nomeUsuario);
	}
	
	public String getNome(){
		return nomeUsuario;
	}
	
	public ArrayList<Musica> recomendar(){
		ArrayList<Musica> recomendacoes = new ArrayList<>();
		for(int i = 0; i<= generosPreferidos.size(); i++) {
			recomendacoes.addAll(ConnectionFactory.pegarNaoAvaliadas(idUsuario, generosPreferidos.get(i).getId()));
		}
		
		return recomendacoes;
	}

}
