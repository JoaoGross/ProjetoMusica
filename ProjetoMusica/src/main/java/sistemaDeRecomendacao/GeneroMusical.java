package sistemaDeRecomendacao;
import java.util.ArrayList;

public class GeneroMusical {
	int Id;
	String nomeGenero;
	ArrayList<Musica> musicas;
	
	public GeneroMusical(String nome) {
		this.nomeGenero = nome;
		this.Id = ConnectionFactory.obterIdGenero(nome);
	}
	public int getId() {
		return Id;
	}
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}
	
	@Override
	public String toString() {
		return nomeGenero;
	}
}
