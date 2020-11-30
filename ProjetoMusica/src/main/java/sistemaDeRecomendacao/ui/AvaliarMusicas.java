
package sistemaDeRecomendacao.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sistemaDeRecomendacao.dao.MusicaDAO;
import sistemaDeRecomendacao.model.GeneroMusical;
import sistemaDeRecomendacao.model.Musica;
import sistemaDeRecomendacao.model.Usuario;


public class AvaliarMusicas extends javax.swing.JFrame {

	Usuario usuario;
	MusicaDAO musicaDao = new MusicaDAO();
	
	public AvaliarMusicas(Usuario usuario) {
		this.usuario = usuario;
		initComponents();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setTitle("Avaliar músicas");
		try {
			jComboBoxMusica.setModel(new javax.swing.DefaultComboBoxModel<>(musicaDao.obterNaoAvaliadas(usuario)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@SuppressWarnings("unchecked")
	private void initComponents() {

		jTextField14 = new javax.swing.JTextField();
		jPanel1 = new javax.swing.JPanel();
		BtConfirmarAvaliacao = new javax.swing.JToggleButton();
		BtVoltarTelaPrincipal2 = new javax.swing.JToggleButton();
		jComboBoxNota = new javax.swing.JComboBox<>();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jComboBoxMusica = new javax.swing.JComboBox<>();
		BtVerMusicasAvaliadas = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();

		jTextField14.setText("jTextField1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setPreferredSize(new java.awt.Dimension(335, 295));

		BtConfirmarAvaliacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		BtConfirmarAvaliacao.setText("Confirmar avaliação");
		BtConfirmarAvaliacao.setToolTipText("Confirmar");
		BtConfirmarAvaliacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BtConfirmarAvaliacao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtConfirmarAvaliacaoActionPerformed(evt);
			}
		});

		BtVoltarTelaPrincipal2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		BtVoltarTelaPrincipal2.setText("Voltar");
		BtVoltarTelaPrincipal2.setToolTipText("");
		BtVoltarTelaPrincipal2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BtVoltarTelaPrincipal2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtVoltarTelaPrincipal2ActionPerformed(evt);
			}
		});

		jComboBoxNota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jComboBoxNota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
		jComboBoxNota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel1.setText("Músicas");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel3.setText(" Nota");
		jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		jComboBoxMusica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jComboBoxMusica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		try {
			jComboBoxMusica.setModel(new javax.swing.DefaultComboBoxModel<>(musicaDao.obterNaoAvaliadas(usuario)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		BtVerMusicasAvaliadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		BtVerMusicasAvaliadas.setText("Ver músicas já avaliadas");
		BtVerMusicasAvaliadas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtVerMusicasAvaliadasActionPerformed(evt);
			}
		});


		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel2.setText("Avaliar minhas músicas");


		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(BtVoltarTelaPrincipal2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(80, 80, 80)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(BtConfirmarAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(BtVerMusicasAvaliadas))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(18, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jComboBoxMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3)
												.addComponent(jComboBoxNota, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(33, 33, 33))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(70, 70, 70))))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(14, 14, 14)
						.addComponent(jLabel2)
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(jLabel1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jComboBoxMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jComboBoxNota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
						.addComponent(BtConfirmarAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(27, 27, 27)
						.addComponent(BtVerMusicasAvaliadas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(27, 27, 27)
						.addComponent(BtVoltarTelaPrincipal2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
						.addContainerGap())
				);

		pack();
	}

	private void BtVoltarTelaPrincipal2ActionPerformed(java.awt.event.ActionEvent evt) {
		new TelaPrincipal(usuario).setVisible(true);
		dispose();
	}

	private void BtVerMusicasAvaliadasActionPerformed(java.awt.event.ActionEvent evt) {
		new MusicasJaAvaliadas(usuario).setVisible(true);
		dispose();
	}

	private void BtConfirmarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {
		Musica musicaAvaliada = (Musica) jComboBoxMusica.getSelectedItem();
		int nota = Integer.parseInt((String) jComboBoxNota.getSelectedItem());

		try {

			if(musicaDao.avaliarMusica(musicaAvaliada, nota, usuario)) {
				JOptionPane.showMessageDialog(null, "Música avaliada com sucesso");
			}else {
				JOptionPane.showMessageDialog(null, "Sem músicas para avaliar");
			}
			jComboBoxMusica.setModel(new javax.swing.DefaultComboBoxModel<>(musicaDao.obterNaoAvaliadas(usuario)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JToggleButton BtConfirmarAvaliacao;
	private javax.swing.JButton BtVerMusicasAvaliadas;
	private javax.swing.JToggleButton BtVoltarTelaPrincipal2;
	private javax.swing.JComboBox<String> jComboBoxNota;
	private javax.swing.JComboBox<Musica> jComboBoxMusica;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextField14;
	// End of variables declaration//GEN-END:variables
}