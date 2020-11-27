package sistemaDeRecomendacao.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import sistemaDeRecomendacao.dao.MusicaDAO;
import sistemaDeRecomendacao.model.Musica;
import sistemaDeRecomendacao.model.Usuario;


public class MusicasJaAvaliadas extends javax.swing.JFrame {
	Usuario usuario;
    
    @SuppressWarnings("serial")
	public MusicasJaAvaliadas(Usuario usuario) {
        initComponents();
        //bloqueia o maximizar da janela
        this.setResizable(false);
        //inicia a janela no meio da tela
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Musicas já avaliadas");
        this.usuario = usuario;
        try {

			musicasAvaliadas.setModel(new javax.swing.table.DefaultTableModel(
					coteudoAvaliado(),
					new String [] {
							"Musicas", "nota"
					}) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return column == 1;
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
        BtVoltarTelaAvaliarMusicas = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        musicasAvaliadas = new javax.swing.JTable();
        BtAtualizarAvaliacoes = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BtVoltarTelaAvaliarMusicas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtVoltarTelaAvaliarMusicas.setText("Voltar");
        BtVoltarTelaAvaliarMusicas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtVoltarTelaAvaliarMusicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVoltarTelaAvaliarMusicasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Musicas jÃ¡ avaliadas");

       
        jScrollPane1.setViewportView(musicasAvaliadas);
//        if (jTable2.getColumnModel().getColumnCount() > 0) {
//            jTable2.getColumnModel().getColumn(0).setResizable(false);
//            jTable2.getColumnModel().getColumn(1).setResizable(false);
//        }

        BtAtualizarAvaliacoes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtAtualizarAvaliacoes.setText("Atualizar  avaliaçoes");
        BtAtualizarAvaliacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtAtualizarAvaliacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAtualizarAvaliacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(BtVoltarTelaAvaliarMusicas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtAtualizarAvaliacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtVoltarTelaAvaliarMusicas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAtualizarAvaliacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String[][] coteudoAvaliado() throws Exception {
    	MusicaDAO musicaDao = new MusicaDAO();
		Musica[] musicasAvaliadas;
		musicasAvaliadas = musicaDao.obterAvaliadas(usuario);

		String[][] conteudo = new String[musicasAvaliadas.length][3];
		int ctd = 0;
		for(int i = 0; i<= musicasAvaliadas.length - 1; i++) {
			conteudo[ctd++] = new String[] {musicasAvaliadas[i].getNome(), 
					"" + musicaDao.obterNotaUsuario( usuario.getId(), musicasAvaliadas[i].getId())};
		}
		return conteudo;
	}
    
    private void BtVoltarTelaAvaliarMusicasActionPerformed(java.awt.event.ActionEvent evt) {
        new AvaliarMusicas(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtVoltarTelaAvaliarMusicasActionPerformed

    private void BtAtualizarAvaliacoesActionPerformed(java.awt.event.ActionEvent evt) {
    	TableModel tabelaAtualizada = musicasAvaliadas.getModel();
        MusicaDAO musicaDao = new MusicaDAO();
    	for(int i = 0; i<= tabelaAtualizada.getRowCount() - 1; i++) {
        	try {
        		String nomeMusica = (String) tabelaAtualizada.getValueAt(i, 0);
        		int nota = Integer.parseInt((String) tabelaAtualizada.getValueAt(i, 1));
				musicaDao.atualizarNota( nomeMusica, nota, usuario);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Insira apenas numeros inteiros de 1 à 5");
			}
        }
    	new AvaliarMusicas(usuario).setVisible(true);
        this.dispose();
    }

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
//            java.util.logging.Logger.getLogger(MusicasJaAvaliadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MusicasJaAvaliadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MusicasJaAvaliadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MusicasJaAvaliadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MusicasJaAvaliadas(usuario).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtAtualizarAvaliacoes;
    private javax.swing.JToggleButton BtVoltarTelaAvaliarMusicas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable musicasAvaliadas;
    // End of variables declaration//GEN-END:variables
}