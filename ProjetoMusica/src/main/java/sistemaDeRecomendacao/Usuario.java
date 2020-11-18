package sistemaDeRecomendacao;
import java.util.ArrayList;

public class Usuario {
	int IdUsuario;
	String nomeUsuario;
	String senha;
	ArrayList<GeneroMusical> generosPreferidos;
	
	//Cadastro
	public Usuario(String nomeUsuario, String senha, ArrayList<GeneroMusical> generosPreferidos){
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.generosPreferidos = generosPreferidos;
		//armazenar no banco de dados
		ConnectionFactory.salvarUsuario(nomeUsuario, senha);
		this.IdUsuario = ConnectionFactory.pegarIdUsuario(nomeUsuario);
		for(int i = 0; i<= generosPreferidos.size(); i++) {
			ConnectionFactory.guardarGeneroPreferido(generosPreferidos.get(i).getId(), IdUsuario);
		}
	}
	//proximos logins
	public Usuario(String nomeUsuario, String senha){
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		//pegar generos do banco e id
	}
	
	public String getNome(){
		return nomeUsuario;
	}
	
	public ArrayList<Musica> recomendar(){
		ArrayList<Musica> recomendacoes = new ArrayList<>();
		for(int i = 0; i<= generosPreferidos.size(); i++) {
			recomendacoes.addAll(ConnectionFactory.pegarNaoAvaliadas(IdUsuario, generosPreferidos.get(i).getId()));
		}
		
		return recomendacoes;
	}

}
