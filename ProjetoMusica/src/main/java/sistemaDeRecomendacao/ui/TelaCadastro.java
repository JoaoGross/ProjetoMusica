
package sistemaDeRecomendacao.ui;

import java.awt.event.ActionEvent;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sistemaDeRecomendacao.bd.ConnectionFactory;
import sistemaDeRecomendacao.dao.GeneroMusicalDAO;
import sistemaDeRecomendacao.dao.UsuarioDAO;
import sistemaDeRecomendacao.model.GeneroMusical;


public class TelaCadastro extends javax.swing.JFrame {
	
	GeneroMusicalDAO generos = new GeneroMusicalDAO();

	public TelaCadastro() {

		initComponents();
		this.setResizable(false);
		//inicia a janela no meio da tela
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}


	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		BotaoCadastrar = new javax.swing.JButton();
		CampoCriarUsuario = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		CampoConfirmarSenha = new javax.swing.JLabel();
		CriarUsuario = new javax.swing.JTextField();
		CampoCriarSenha = new javax.swing.JPasswordField();
		CampoRepetirSenha = new javax.swing.JPasswordField();
		BtVoltarTelaLogin = new javax.swing.JButton();
		generoComboBox = new javax.swing.JComboBox<>();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setFocusable(false);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Cadastro de usuários");

		BotaoCadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		BotaoCadastrar.setText("Cadastrar");
		BotaoCadastrar.setToolTipText("Cadastrar");
		BotaoCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BotaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BotaoCadastrarActionPerformed(evt);
			}
		});

<<<<<<< HEAD
		CampoCriarUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		CampoCriarUsuario.setText("Nome usuário");
=======
		CampoCriarUsuario.setFont(new java.awt.Font("Tahoma", 1, 11));
		CampoCriarUsuario.setText("Nome usuario");
>>>>>>> 31e4ba63449906497426bdbd9f4c9549f6fb32ba

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel3.setText("Senha");

		CampoConfirmarSenha.setFont(new java.awt.Font("Tahoma", 1, 11));
		CampoConfirmarSenha.setText("Repetir senha");


//		CampoCriarSenha.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				CampoCriarSenhaActionPerformed(evt);
//			}
//
//			private void CampoCriarSenhaActionPerformed(ActionEvent evt) {
//				// TODO Auto-generated method stub
//
//			}
//		});

		BtVoltarTelaLogin.setFont(new java.awt.Font("Tahoma", 1, 11));
		BtVoltarTelaLogin.setText("Voltar");
		BtVoltarTelaLogin.setToolTipText("Voltar");
		BtVoltarTelaLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BtVoltarTelaLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtVoltarTelaLoginActionPerformed(evt);
			}
		});

		generoComboBox.setFont(new java.awt.Font("Tahoma", 1, 11));
		try {
			generoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(generos.obterGeneros()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		generoComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel4.setText("Gênero favorito");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(113, 113, 113)
						.addComponent(BtVoltarTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(BotaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addGap(8, 8, 8)
																		.addComponent(CampoCriarUsuario))
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addGap(23, 23, 23)
																		.addComponent(jLabel3)))
														.addGap(0, 11, Short.MAX_VALUE))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(CampoConfirmarSenha)
														.addComponent(jLabel4)))
										.addGap(18, 18, 18)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(CampoCriarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(CriarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
														.addComponent(CampoRepetirSenha)
														.addComponent(generoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)))
						.addContainerGap(42, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(27, 27, 27)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(CampoCriarUsuario)
								.addComponent(CriarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(CampoCriarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(CampoRepetirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(CampoConfirmarSenha))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(generoComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
								.addComponent(jLabel4))
						.addGap(33, 33, 33)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(BtVoltarTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(BotaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack();
	}
	
	private void BotaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
		
		String login = CriarUsuario.getText();
		String senha = new String(CampoCriarSenha.getPassword());
		String senhaRepetida = new String(CampoRepetirSenha.getPassword());
		GeneroMusical generoPreferido = (GeneroMusical) generoComboBox.getSelectedItem();
		UsuarioDAO novoUsuario = new UsuarioDAO();
		
		if(senha.equals(senhaRepetida)) {
			try {
				novoUsuario.cadastrarUsuario(login, senha);
				int IdUsuario = novoUsuario.obterIdUsuario(login);
				novoUsuario.cadastrarGenero(IdUsuario, generoPreferido.getId());
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro");
			}
			
			TelaLogin telaLogin = new TelaLogin();
			telaLogin.setVisible(true);
			this.dispose();

		}else {
			JOptionPane.showMessageDialog(null, "As senhas não correspondem");
		}
	}

	private void BtVoltarTelaLoginActionPerformed(java.awt.event.ActionEvent evt) {
		new TelaLogin().setVisible(true);
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
			java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TelaCadastro().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton BotaoCadastrar;
	private javax.swing.JButton BtVoltarTelaLogin;
	private javax.swing.JLabel CampoConfirmarSenha;
	private javax.swing.JPasswordField CampoCriarSenha;
	private javax.swing.JLabel CampoCriarUsuario;
	private javax.swing.JPasswordField CampoRepetirSenha;
	private javax.swing.JTextField CriarUsuario;
	private javax.swing.JComboBox<GeneroMusical> generoComboBox;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables



}