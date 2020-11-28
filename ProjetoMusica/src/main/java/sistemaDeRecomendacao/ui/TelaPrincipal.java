package sistemaDeRecomendacao.ui;

import javax.swing.JOptionPane;

import sistemaDeRecomendacao.model.Usuario;


public class TelaPrincipal extends javax.swing.JFrame {

	Usuario usuario;

	public TelaPrincipal(Usuario usuario) {
		this.usuario = usuario;
		initComponents();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}


	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		BtTelaGenerosPreferidos = new javax.swing.JToggleButton();
		BtTelaAvaliarMusicas = new javax.swing.JToggleButton();
		BtTelaRecomendacoes = new javax.swing.JToggleButton();
		BtSairPrograma = new javax.swing.JToggleButton();
		jLabel4 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		BtTelaGenerosPreferidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		BtTelaGenerosPreferidos.setText("Meus gêneros preferidos");
		BtTelaGenerosPreferidos.setToolTipText("Meus gêneros");
		BtTelaGenerosPreferidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BtTelaGenerosPreferidos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtTelaGenerosPreferidosActionPerformed(evt);
			}
		});

		BtTelaAvaliarMusicas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		BtTelaAvaliarMusicas.setText("Avaliar músicas");
		BtTelaAvaliarMusicas.setToolTipText("Avaliar");
		BtTelaAvaliarMusicas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BtTelaAvaliarMusicas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtTelaAvaliarMusicasActionPerformed(evt);
			}
		});

		BtTelaRecomendacoes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		BtTelaRecomendacoes.setText("Quero recomendações!");
		BtTelaRecomendacoes.setToolTipText("recomendações");
		BtTelaRecomendacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BtTelaRecomendacoes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtTelaRecomendacoesActionPerformed(evt);
			}
		});

		BtSairPrograma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		BtSairPrograma.setText("Sair");
		BtSairPrograma.setToolTipText("Sair da aplicação");
		BtSairPrograma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BtSairPrograma.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtSairProgramaActionPerformed(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText("Sistema de recomendação de musicas");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(24, 24, 24)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
								.addComponent(BtTelaGenerosPreferidos)
								.addComponent(BtTelaAvaliarMusicas, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(BtTelaRecomendacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(BtSairPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(50, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30)
						.addComponent(BtTelaGenerosPreferidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(15, 15, 15)
						.addComponent(BtTelaAvaliarMusicas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(BtTelaRecomendacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(28, 28, 28)
						.addComponent(BtSairPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack();
	}

	private void BtTelaGenerosPreferidosActionPerformed(java.awt.event.ActionEvent evt) {
		new GenerosPreferidos(usuario).setVisible(true);
		dispose();

	}

	private void BtTelaAvaliarMusicasActionPerformed(java.awt.event.ActionEvent evt) {
		new AvaliarMusicas(usuario).setVisible(true);
		dispose();
	}

	private void BtTelaRecomendacoesActionPerformed(java.awt.event.ActionEvent evt) {
		new Recomendacoes(usuario).setVisible(true);
		dispose();
	}

	private void BtSairProgramaActionPerformed(java.awt.event.ActionEvent evt) {
		int sair=JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION);
		if(sair==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JToggleButton BtSairPrograma;
	private javax.swing.JToggleButton BtTelaAvaliarMusicas;
	private javax.swing.JToggleButton BtTelaGenerosPreferidos;
	private javax.swing.JToggleButton BtTelaRecomendacoes;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables
}