package sistemaDeRecomendacao.ui;
import javax.swing.JFrame;

import sistemaDeRecomendacao.dao.MusicaDAO;
import sistemaDeRecomendacao.model.Musica;
import sistemaDeRecomendacao.model.Usuario;

public class Recomendacoes extends javax.swing.JFrame {
	Usuario usuario;

	public Recomendacoes(Usuario usuario) {
		this.usuario = usuario;
		initComponents();
		//bloqueia o maximizar da janela
		this.setResizable(false);
		//inicia a janela no meio da tela
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
<<<<<<< HEAD
		try {

			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					coteudoRecomendado(),
					new String [] {
							"Músicas", "nota"
					}) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			}
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
=======
		
>>>>>>> 31e4ba63449906497426bdbd9f4c9549f6fb32ba
	}


	@SuppressWarnings({ "unchecked", "serial" })
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jLabel1 = new javax.swing.JLabel();
		BtVoltarTelaPrincipal3 = new javax.swing.JToggleButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setPreferredSize(new java.awt.Dimension(321, 288));

		jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		jScrollPane1.setViewportView(jTable1);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Recomendações para você");

		BtVoltarTelaPrincipal3.setText("Voltar");
		BtVoltarTelaPrincipal3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		BtVoltarTelaPrincipal3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtVoltarTelaPrincipal3ActionPerformed(evt);
			}
		});
		
		try {

			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					coteudoRecomendado(usuario),
					new String [] {
							"Musicas", "nota"
					}) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(32, 32, 32)
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(111, 111, 111)
										.addComponent(BtVoltarTelaPrincipal3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(27, 27, 27)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addComponent(BtVoltarTelaPrincipal3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);

		pack();
	}


	
	
	private String[][] coteudoRecomendado(Usuario usuario) throws Exception {
		
		MusicaDAO musicasNaoAvaliadas = new MusicaDAO();
		Musica[] musicasRecomendadas;
		musicasRecomendadas = musicasNaoAvaliadas.obterNaoAvaliadas(usuario);

		String[][] recomendacoes = new String[musicasRecomendadas.length][3];
		int ctd = 0;
		for(int i = 0; i<= musicasRecomendadas.length - 1; i++) {
			recomendacoes[ctd++] = new String[] {musicasRecomendadas[i].getNome(), String.format( "%.1f", musicasRecomendadas[i].getNotaMedia())};
		}
		return recomendacoes;		
	}

	private void BtVoltarTelaPrincipal3ActionPerformed(java.awt.event.ActionEvent evt) {
		new TelaPrincipal(usuario).setVisible(true);
		this.dispose();
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JToggleButton BtVoltarTelaPrincipal3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration//GEN-END:variables
}