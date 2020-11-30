
package sistemaDeRecomendacao.ui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.dao.UsuarioDAO;
import sistemaDeRecomendacao.model.Usuario;

public class TelaLogin extends javax.swing.JFrame {


	public TelaLogin() {
		initComponents();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}


	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		BtEntrar = new javax.swing.JButton();
		BtTelaCadastro = new javax.swing.JButton();
		CampoNomeUsuario = new javax.swing.JLabel();
		CampoSenha = new javax.swing.JLabel();
		CampoInserirUsuario = new javax.swing.JTextField();
		CampoInserirSenha = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setName("");

		BtEntrar.setFont(new java.awt.Font("Tahoma", 1, 11));
		BtEntrar.setText("Entrar");
		BtEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BtEntrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtEntrarActionPerformed(evt);
			}
		});

		BtTelaCadastro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		BtTelaCadastro.setText("Não tem cadastro?");
		BtTelaCadastro.setToolTipText("Cadastre-se aqui");
		BtTelaCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BtTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtTelaCadastroActionPerformed(evt);
			}
		});

		CampoNomeUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		CampoNomeUsuario.setText("Nome usuário");

		CampoSenha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		CampoSenha.setText("Senha");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(39, 39, 39)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addGap(0, 0, Short.MAX_VALUE)
														.addComponent(BtEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(59, 59, 59))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
														.addComponent(CampoSenha)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(BtTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(CampoInserirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(25, 25, 25)
										.addComponent(CampoNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addComponent(CampoInserirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(34, 34, 34))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
				.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
						.addGap(73, 73, 73)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(CampoInserirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(CampoNomeUsuario))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(CampoSenha)
								.addComponent(CampoInserirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(13, 13, 13)
						.addComponent(BtEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(BtTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(65, Short.MAX_VALUE))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);

		pack();
	}

	private void BtEntrarActionPerformed(java.awt.event.ActionEvent evt) {
		
		String login = CampoInserirUsuario.getText();
		String senha = new String(CampoInserirSenha.getPassword());

		try {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			Usuario usuario = new Usuario(login, senha, usuarioDao.obterIdUsuario(login));
			if (usuarioDao.existe(usuario)) {
				
				TelaPrincipal telaPrincipal = new TelaPrincipal(usuario);
				telaPrincipal.setVisible(true);
				this.dispose();
				
			} else {
				JOptionPane.showMessageDialog(null, "Login ou senha inválido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problemas técnicos. Tente novamente mais tarde");
			e.printStackTrace();
		}
	}

	private void BtTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {
		
		new TelaCadastro().setVisible(true);
		dispose();
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaLogin().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton BtEntrar;
	private javax.swing.JButton BtTelaCadastro;
	private javax.swing.JPasswordField CampoInserirSenha;
	private javax.swing.JTextField CampoInserirUsuario;
	private javax.swing.JLabel CampoNomeUsuario;
	private javax.swing.JLabel CampoSenha;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables
}