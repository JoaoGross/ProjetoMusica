package sistemaDeRecomendacao.ui;
import javax.swing.JFrame;

import sistemaDeRecomendacao.dao.MusicaDAO;
import sistemaDeRecomendacao.model.Musica;
import sistemaDeRecomendacao.model.Usuario;

public class Recomendacoes extends javax.swing.JFrame {
	Usuario usuario;

	@SuppressWarnings("serial")
	public Recomendacoes(Usuario usuario) {
		initComponents();
		//bloqueia o maximizar da janela
		this.setResizable(false);
		//inicia a janela no meio da tela
		this.setLocationRelativeTo(null);
		this.usuario = usuario;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	}


	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
	}// </editor-fold>//GEN-END:initComponents


	
	
	private String[][] coteudoRecomendado() throws Exception {
		
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




	private void BtVoltarTelaPrincipal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVoltarTelaPrincipal3ActionPerformed
		//fecha a tela de recomendações e volta para tela principal
		new TelaPrincipal(usuario).setVisible(true);
		this.dispose();
	}//GEN-LAST:event_BtVoltarTelaPrincipal3ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	//    public static void main(String args[]) {
	//        /* Set the Nimbus look and feel */
	//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	//         */
	//        try {
	//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	//                if ("Nimbus".equals(info.getName())) {
	//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	//                    break;
	//                }
	//            }
	//        } catch (ClassNotFoundException ex) {
	//            java.util.logging.Logger.getLogger(Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (InstantiationException ex) {
	//            java.util.logging.Logger.getLogger(Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (IllegalAccessException ex) {
	//            java.util.logging.Logger.getLogger(Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	//            java.util.logging.Logger.getLogger(Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        }
	//        //</editor-fold>
	//        //</editor-fold>
	//        //</editor-fold>
	//        //</editor-fold>
	//
	//        /* Create and display the form */
	//        java.awt.EventQueue.invokeLater(new Runnable() {
	//            public void run() {
	//                new Recomendacoes().setVisible(true);
	//            }
	//        });
	//    }

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JToggleButton BtVoltarTelaPrincipal3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration//GEN-END:variables
}