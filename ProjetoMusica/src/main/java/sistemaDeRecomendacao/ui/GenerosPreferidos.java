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
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.usuario = usuario;
        setTitle("Generos preferidos");
        UsuarioDAO usuarioDao = new UsuarioDAO();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.pegarGenerosPreferidos(usuario.getId())));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.obterGenerosNaoFavoritos(usuario.getId())));
    }

    
    @SuppressWarnings("unchecked")
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("       Meus Generos");

        BtVoltarTelaPrincipal.setText("Voltar");
        BtVoltarTelaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtVoltarTelaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVoltarTelaPrincipalActionPerformed(evt);
            }
        });

        

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Adicionar novo");

        BtExcluir.setText("Excluir");
        BtExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					BtExcluirActionPerformed(evt);
				} catch (Exception e) {
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
    }

    private void BtVoltarTelaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaPrincipal(usuario).setVisible(true);
        this.dispose();
    }

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
    	GeneroMusical novoGenero = (GeneroMusical) jComboBox2.getSelectedItem();
    	UsuarioDAO usuarioDao = new UsuarioDAO();
    	if(usuarioDao.adicionarGeneroPreferido(novoGenero, usuario)) {
    		JOptionPane.showMessageDialog(null, "Genero Adicionado com sucesso");
    	}
    	
    	jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.pegarGenerosPreferidos(usuario.getId())));
    	jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.obterGenerosNaoFavoritos(usuario.getId())));
    }
    
    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
    	GeneroMusical generoExcluido = (GeneroMusical) jComboBox1.getSelectedItem();
    	UsuarioDAO usuarioDao = new UsuarioDAO();
    	if(usuarioDao.excluirGeneroPreferido(generoExcluido, usuario)) {
    		JOptionPane.showMessageDialog(null, "Genero Excluido com sucesso");
    	}
    	jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.pegarGenerosPreferidos(usuario.getId())));
    	jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(usuarioDao.obterGenerosNaoFavoritos(usuario.getId())));
    }


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