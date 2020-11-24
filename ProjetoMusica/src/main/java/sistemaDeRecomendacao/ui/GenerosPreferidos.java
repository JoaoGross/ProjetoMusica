package sistemaDeRecomendacao.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sistemaDeRecomendacao.dao.UsuarioDAO;
import sistemaDeRecomendacao.model.GeneroMusical;
import sistemaDeRecomendacao.model.Usuario;


public class GenerosPreferidos extends javax.swing.JFrame {
	Usuario usuario;
    
//    public GenerosPreferidos() {
//        initComponents();
//        //bloqueia o maximizar da janela
//        this.setResizable(false);
//        //inicia a janela no meio da tela
//        this.setLocationRelativeTo(null);
//        //descarta o objeto frame e mantem o apricativo rodando
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setTitle("Generos preferidos");
//    }
    
    public GenerosPreferidos(Usuario usuario) throws Exception {
        initComponents();
        //bloqueia o maximizar da janela
        this.setResizable(false);
        //inicia a janela no meio da tela
        this.setLocationRelativeTo(null);
        //descarta o objeto frame e mantem o apricativo rodando
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.usuario = usuario;
        setTitle("Generos preferidos");
        UsuarioDAO usuarioDao = new UsuarioDAO();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.pegarGenerosPreferidos(usuario.getId())));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.obterGenerosNaoFavoritos(usuario.getId())));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtAdicionar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        BtVoltarTelaPrincipal = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        BtExcluir = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(321, 288));

//        BtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("sistemaDeRecomendacao/images/adc.png"))); // NOI18N
        BtAdicionar.setToolTipText("Adicionar");
        BtAdicionar.setText("Adicionar");
        BtAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtAdicionar.setPreferredSize(new java.awt.Dimension(40, 40));
        BtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					BtAdicionarActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("       Meus Generos");

        BtVoltarTelaPrincipal.setText("Voltar");
        BtVoltarTelaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtVoltarTelaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVoltarTelaPrincipalActionPerformed(evt);
            }
        });

        

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Adicionar novo");

        BtExcluir.setText("Excluir");
        BtExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					BtExcluirActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtVoltarTelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtExcluir)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(BtExcluir)
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtVoltarTelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtVoltarTelaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {
        //fecha a tela de Generos Preferidos e volta para tela principal
        new TelaPrincipal(usuario).setVisible(true);
        this.dispose();
    }

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
    	GeneroMusical novoGenero = (GeneroMusical) jComboBox2.getSelectedItem();
    	UsuarioDAO usuarioDao = new UsuarioDAO();
    	usuarioDao.adicionarGeneroPreferido(novoGenero, usuario);
    	JOptionPane.showMessageDialog(null, "Genero Adicionado com sucesso");
    	jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.pegarGenerosPreferidos(usuario.getId())));
    	jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.obterGenerosNaoFavoritos(usuario.getId())));
    }
    
    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
    	GeneroMusical generoExcluido = (GeneroMusical) jComboBox1.getSelectedItem();
    	UsuarioDAO usuarioDao = new UsuarioDAO();
    	usuarioDao.excluirGeneroPreferido(generoExcluido, usuario);
    	JOptionPane.showMessageDialog(null, "Genero Excluido com sucesso");
    	jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.pegarGenerosPreferidos(usuario.getId())));
    	jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.obterGenerosNaoFavoritos(usuario.getId())));
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
//            java.util.logging.Logger.getLogger(GenerosPreferidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GenerosPreferidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GenerosPreferidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GenerosPreferidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GenerosPreferidos(usuario).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtAdicionar;
    private javax.swing.JToggleButton BtVoltarTelaPrincipal;
    private javax.swing.JToggleButton BtExcluir;
    private javax.swing.JComboBox<GeneroMusical> jComboBox1;
    private javax.swing.JComboBox<GeneroMusical> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}