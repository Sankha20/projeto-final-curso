package view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Victor Pontes
 */
public class Principal extends javax.swing.JFrame {
    
    // DEBUG | Modo de debug true / false
    final boolean DEBUG = true;
    
    // Mudança de telas
    
    JPanel clientes;
    JPanel produtos;
    JPanel vendas;
    
    final static String CARD_CLIENTES = "clientes";
    final static String CARD_PRODUTOS = "produtos";
    final static String CARD_VENDAS = "vendas";
    
    
    
    
    
    public Principal() {
        initComponents();
        initCardLayout();
    }
    
    
    
    
//==============================================================================
// Region: Victor Pontes
//==============================================================================
    /**
     * Muda o painel do menu.
     * 
     * @param panel Nome do painel para mudar
     */
    private void mudarMenu(String panel) {
        debug("Mudando menu para: " + panel);
        CardLayout card = (CardLayout) pnl_conteudo.getLayout();
        card.show(pnl_conteudo, panel);
    }
    
    /**
     * Função usada para imprimir no terminal msgs de debug.
     * @param msg Mensagem de deubg
     */
    private void debug(String msg) {
        if (DEBUG) {
            System.out.println("DEBUG | " + msg);
        }
    }
    
    /**
     * Inicializa os componentes responsáveis para a mudança de telas do menu
     */
    private void initCardLayout() {
        clientes = new Clientes();
        produtos = new Produtos();
        vendas = new Vendas();
        
        pnl_conteudo.add(clientes, CARD_CLIENTES);
        pnl_conteudo.add(produtos, CARD_PRODUTOS);
        pnl_conteudo.add(vendas, CARD_VENDAS);
    }
    
    
    // Botões de comando do menu principal
    private void botaoMenuClientes() {
        mudarMenu(CARD_CLIENTES);
    }
    
    private void botaoMenuProdutos() {
        mudarMenu(CARD_PRODUTOS);
    }
    
    private void botaoMenuVendas() {
        mudarMenu(CARD_VENDAS);
    }
    
//==============================================================================
// End Region: Victor Pontes
//==============================================================================

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_menu = new javax.swing.JPanel();
        btn_clientes = new javax.swing.JButton();
        btn_produtos = new javax.swing.JButton();
        btn_vendas = new javax.swing.JButton();
        pnl_conteudo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Soca Som");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(928, 522));

        pnl_menu.setPreferredSize(new java.awt.Dimension(100, 522));

        btn_clientes.setText("Clientes");
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        btn_produtos.setText("Produtos");
        btn_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produtosActionPerformed(evt);
            }
        });

        btn_vendas.setText("Vendas");
        btn_vendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vendasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuLayout = new javax.swing.GroupLayout(pnl_menu);
        pnl_menu.setLayout(pnl_menuLayout);
        pnl_menuLayout.setHorizontalGroup(
            pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(btn_vendas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_menuLayout.setVerticalGroup(
            pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_clientes)
                .addGap(18, 18, 18)
                .addComponent(btn_produtos)
                .addGap(18, 18, 18)
                .addComponent(btn_vendas)
                .addContainerGap(406, Short.MAX_VALUE))
        );

        pnl_conteudo.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_conteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnl_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnl_conteudo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produtosActionPerformed
        // TODO add your handling code here:
        botaoMenuProdutos();
    }//GEN-LAST:event_btn_produtosActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        // TODO add your handling code here:
        botaoMenuClientes();
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void btn_vendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vendasActionPerformed
        // TODO add your handling code here:
        botaoMenuVendas();
    }//GEN-LAST:event_btn_vendasActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame menu = new Principal();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_produtos;
    private javax.swing.JButton btn_vendas;
    private javax.swing.JPanel pnl_conteudo;
    private javax.swing.JPanel pnl_menu;
    // End of variables declaration//GEN-END:variables
}
