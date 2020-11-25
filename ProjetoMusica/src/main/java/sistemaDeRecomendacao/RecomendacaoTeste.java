package sistemaDeRecomendacao;

import javax.swing.JOptionPane;

import sistemaDeRecomendacao.dao.GeneroMusicalDAO;
import sistemaDeRecomendacao.ui.TelaLogin;

public class RecomendacaoTeste {
	public static void main(String args[]) {
		GeneroMusicalDAO genero = new GeneroMusicalDAO();
		try {
			
			JOptionPane.showMessageDialog(null, genero.obterMusicas(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
