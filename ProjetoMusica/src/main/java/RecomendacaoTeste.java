
public class RecomendacaoTeste {
	public static void main(String args[]) {
		String nomeUsuario = ""; //recebe da interface
		String senha = ""; // recebe da interface

		String dbSenha = ConnectionFactory.pegarSenha(nomeUsuario); //recebe do banco

		if(senha.equals(dbSenha)) {
			Usuario usuario = new Usuario(nomeUsuario, senha);
			//proxima tela;
		}else {
			//erro de login;
		}
	}
}
