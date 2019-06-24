package view;

/** 
 * VICTOR \/
 * Limpei os imports não utilizados.. tinham uns 10
 * 
 * Inseri um botão para atualizar a lista de mídias que não atualizava
 * ao inserir uma nova.
 * 
 * Consertei os erros de conversão entre BigDecimal e Double
 * 
 * Consertei erros de formatação de valores na tela
 * 
 * Consertei os BUGS na hora de realizar venda
 * 
 * Adicionei sistema de Pontos que estava faltando
 */

import utils.Ferramentas;
import controller.ProdutoController;
import controller.VendasController;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 * @author França
 */
public class Vendas extends javax.swing.JPanel {

    private List<Produto> produtos;
    Object[] colunas = {"Id", "Midia", "Preço", "Compositor", "Album"};
    DefaultTableModel tableModelVenda = new DefaultTableModel(colunas, 0);

    Venda venda = new Venda();

    List<ItemVenda> listaItem = new ArrayList();
    List<Produto> listaProduto = new ArrayList();
    Cliente cliente;

    /**
     * Creates new form Vendas
     */
    public Vendas() {
        venda.setTotal(BigDecimal.ZERO);
        initComponents();
        limpar();
        jTextValorTotal.setEnabled(false);
        carregaProdutos();
        jBAdicionar.setEnabled(false);
        jBExcluir.setEnabled(false);
        jTextCpf.setEnabled(false);
        jTextEmail.setEnabled(false);
        jTextNome.setEnabled(false);
    }

    public void limpar() {
        jTextValorTotal.setText("");
        jbuscaCpf.setText("");
        jTextNome.setText("");
        jTextCpf.setText("");
        jTextEmail.setText("");
    }

    public void carregaProdutos() {
        ProdutoController produtoController = new ProdutoController();

        produtos = produtoController.buscarProdutos();

        Object[] colunas = {"Id", "Midia", "Preço", "Compositor", "Album"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);

        for (Produto produto : produtos) {
            Object[] linhas = {produto.getId(), produto.getMidia(), produto.getPreco(), produto.getCompositor(), produto.getAlbum()};
            tableModel.addRow(linhas);
        }
        jTableProdutos.setModel(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextValorTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbVenda = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jBAdicionar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbuscaCpf = new javax.swing.JTextField();
        jBtBuscarPorCpf = new javax.swing.JButton();
        jTextNome = new javax.swing.JTextField();
        jTextCpf = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jComboFormaPagamento = new javax.swing.JComboBox();
        jBtBuscarPorCpf1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Confirmar venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextValorTotalActionPerformed(evt);
            }
        });
        jTextValorTotal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextValorTotalPropertyChange(evt);
            }
        });

        jLabel1.setText("Total da Compra:");

        jtbVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id Produto", "Nome produto", "Preço", "Quantidade"
            }
        ));
        jtbVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbVendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbVenda);

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Midia", "Preço", "Compositor", "Album"
            }
        ));
        jTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableProdutos);

        jBAdicionar.setText("Adicionar");
        jBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar Cliente por CPF");

        jbuscaCpf.setText("jTextField1");
        jbuscaCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuscaCpfActionPerformed(evt);
            }
        });
        jbuscaCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jbuscaCpfKeyReleased(evt);
            }
        });

        jBtBuscarPorCpf.setText("Buscar");
        jBtBuscarPorCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarPorCpfActionPerformed(evt);
            }
        });

        jTextNome.setText("jTextField1");
        jTextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeActionPerformed(evt);
            }
        });

        jTextCpf.setText("jTextField2");

        jTextEmail.setText("jTextField3");

        jComboFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cheque", "Cartao", " " }));
        jComboFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboFormaPagamentoActionPerformed(evt);
            }
        });

        jBtBuscarPorCpf1.setText("Atualizar");
        jBtBuscarPorCpf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarPorCpf1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextCpf))
                                    .addComponent(jbuscaCpf))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBtBuscarPorCpf)
                                        .addGap(112, 112, 112))
                                    .addComponent(jTextEmail)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jComboFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                    .addComponent(jBtBuscarPorCpf1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jBAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtBuscarPorCpf1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtBuscarPorCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jComboFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean confirma = Ferramentas.confirma("Confirmar a venda?");

        if (confirma) {
            this.venda.setCliente(cliente);
           
            this.venda.setFormaPagamento(jComboFormaPagamento.getSelectedItem().toString());
            BigDecimal valor = new BigDecimal(0);
            VendasController.gravarVenda(venda, listaProduto);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseClicked
        // TODO add your handling code here:

        int index = jTableProdutos.getSelectedRow();
        if (index >= 0) {
            jBAdicionar.setEnabled(true);
        }

    }//GEN-LAST:event_jTableProdutosMouseClicked

    private void jBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicionarActionPerformed
        // TODO add your handling code here:
        int index = jTableProdutos.getSelectedRow();
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setProduto(null);

        // faz a inserção de cada produto na tabela Venda
        Produto selecionado = new Produto();
        selecionado = produtos.get(index);
        Object[] novo = {selecionado.getId(), selecionado.getMidia(), selecionado.getPreco(), selecionado.getCompositor(), selecionado.getAlbum()};

        ItemVenda item = new ItemVenda();
        item.setProduto(selecionado);
        this.listaProduto.add(selecionado);
        this.listaItem.add(item);
        tableModelVenda.addRow(novo);
        jtbVenda.setModel(tableModelVenda);

        //Calcula o valor total
        
        // Vic: Consertando conversão p/ BigDecimal
        BigDecimal valor = new BigDecimal(selecionado.getPreco());
        
        venda.setTotal(venda.getTotal().add(valor));
        
        // Vic: Consertando formatação de valores na tela
        jTextValorTotal.setText(
                String.format("R$ %.2f",venda.getTotal().doubleValue()));
    }//GEN-LAST:event_jBAdicionarActionPerformed

    private void jtbVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbVendaMouseClicked
        // TODO add your handling code here:
        int index = jtbVenda.getSelectedRow();
        if (index >= 0) {
            jBExcluir.setEnabled(true);
        }

    }//GEN-LAST:event_jtbVendaMouseClicked

    private void jTextValorTotalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextValorTotalPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextValorTotalPropertyChange

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        // TODO add your handling code here:
        int index = jtbVenda.getSelectedRow();
        Produto selecionado = new Produto();
        selecionado = produtos.get(index);
//      Deduz o valor do item excluido do total

        // Vic: Consertando conversão p/ BigDecimal
        BigDecimal valor = new BigDecimal(selecionado.getPreco());
        //trocar para deduzir
        BigDecimal resultado = new BigDecimal(0);
        resultado = venda.getTotal();
        venda.setTotal(resultado.subtract(valor));
//        venda.setTotal(venda.getTotal().subtract(valor));
        System.out.println(resultado);
        jTextValorTotal.setText(venda.getTotal().toString());
        tableModelVenda.removeRow(index);

    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jbuscaCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbuscaCpfKeyReleased


    }//GEN-LAST:event_jbuscaCpfKeyReleased

    private void jBtBuscarPorCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarPorCpfActionPerformed
        // TODO add your handling code here:
        String cpf = jbuscaCpf.getText();
        this.cliente = VendasController.buscarPorCpf(cpf);
        System.out.println(cliente);
        jTextCpf.setText(this.cliente.getCpf());
        jTextEmail.setText(this.cliente.getEmail());
        jTextNome.setText(this.cliente.getNome());
    }//GEN-LAST:event_jBtBuscarPorCpfActionPerformed

    private void jTextValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextValorTotalActionPerformed

    private void jbuscaCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuscaCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbuscaCpfActionPerformed

    private void jTextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeActionPerformed

    private void jComboFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFormaPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboFormaPagamentoActionPerformed

    private void jBtBuscarPorCpf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarPorCpf1ActionPerformed
        // TODO add your handling code here:
        carregaProdutos();
    }//GEN-LAST:event_jBtBuscarPorCpf1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdicionar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBtBuscarPorCpf;
    private javax.swing.JButton jBtBuscarPorCpf1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextCpf;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextValorTotal;
    private javax.swing.JTextField jbuscaCpf;
    private javax.swing.JTable jtbVenda;
    // End of variables declaration//GEN-END:variables
}
