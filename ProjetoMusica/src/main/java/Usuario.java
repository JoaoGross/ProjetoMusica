import java.util.ArrayList;

public class Usuario {
	int Id;
	String nomeUsuario;
	String senha;
	ArrayList<GeneroMusical> generosPreferidos;
	
	//Cadastro
	public Usuario(String nomeUsuario, String senha, ArrayList<GeneroMusical> generosPreferidos){
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.generosPreferidos = generosPreferidos;
		//armazenar no banco de dados
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
			recomendacoes.addAll(ConnectionFactory.pegarNaoAvaliadas(Id, generosPreferidos.get(i).getId()));
		}
		
		return recomendacoes;
	}

}