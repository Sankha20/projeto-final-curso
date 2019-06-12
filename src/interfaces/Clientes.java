package interfaces;

import classes.Cliente;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import utilidades.*;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author Victor Pontes
 */
public class Clientes extends javax.swing.JPanel {

    DaoClientes bd = new DaoClientes();
    ArrayList<Cliente> clientes;
    Cliente selecionado = null;
    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
        atualizarTabela();
    }
    
//------------------------------------------------------------------------------
// REGION: FUNÇÕES
//------------------------------------------------------------------------------
    /**
     * Função que atualiza a tabela de clientes
     */
    private void atualizarTabela() {
        // Atualiza a lista de clientes
        clientes = bd.selectAll();
        
        // Salva o modelo da tabela
        DefaultTableModel tab = (DefaultTableModel) tabela_clientes.getModel();
        
        // Apaga todo o conteúdo da tabela
        tab.setRowCount(0);
        
        clientes.forEach((cliente) -> {
            tab.addRow(cliente.formatoTabela());
        });
        
        int quantidade = tab.getRowCount();
        lbl_clientes.setText(String.valueOf(quantidade));
    }
    
    /**
     * Lê as informações na tela e gera uma nova instancia de cliente
     * @return Cliente
     */
    private Cliente lerCliente() {
        // Lê os campos de texto e marca se algum está vazio
        String cpf = lerCpf();
        String nome = lerTexto(txt_nome);
        String email =lerTexto(txt_email);
        
        // Faz a verificação nos campos
        if (!verificarCampos(cpf, nome, email)) {
            Ferramentas.alerta("Preencha todos os campos.");
            return null;
        }
        
        // Cria um novo cliente
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setEmail(email);
        
        return cliente;
    }
        
    /**
     * Função que preenche os campos da tela com os valores do cliente
     * @param c Cliente
     */
    private void preencherCampos(Cliente c) {
        txt_cpf.setText(c.getCpf());
        txt_nome.setText(c.getNome());
        txt_email.setText(c.getEmail());
        txt_pontos.setText(String.valueOf(c.getPontos()));
    }
    
    /**
     * Verifica se todos os campos estão preenchidos
     * @param campos Todos os valores em STRING a serem verificados
     * @return True: Todos preenchidos / False
     */
    private boolean verificarCampos(Object ... campos) {
        for (Object campo : campos) {
            if (campo == null) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Função específica para ler e tratar o CPF da tela
     * @return String cpf em forma de string
     */
    private String lerCpf() {
        String cpf = String.valueOf(txt_cpf.getText());
        if (cpf.isEmpty() || cpf.length() != 11 || cpf.contains(" "))
            return null;
        return cpf;
    }
    
    /**
     * Lê um campo e vefifica se está vazio ou não
     * @param campo
     * @return String ou null
     */
    private String lerTexto(javax.swing.JTextField campo) {        
        if (campo.getText().isEmpty())
            return null;
        return (String) campo.getText();
    }
    
    /**
     * Busca na array de clientes o cliente pelo CPF passado
     * @param cpf
     */
    private void getClienteByCpf(String cpf) {
        clientes.forEach((cliente) -> {
            if (cliente.getCpf().equals(cpf)) {
                selecionado = cliente;
            }
        });
    }
    
    /**
     * Limpa todos os campos da tela
     */
    private void limparCampos() {
        txt_cpf.setValue("");
        txt_nome.setText("");
        txt_email.setText("");
        txt_pontos.setText("");
        selecionado = null;
    }
    
    
    
//------------------------------------------------------------------------------
// REGION: CLIQUES
//------------------------------------------------------------------------------
    
    private void clickBotaoDeletar() {
        String cpf = lerCpf();
        if (!verificarCampos(cpf)) {
            Ferramentas.alerta("Preencha o CPF.");
            return;
        }
        
        if(!Ferramentas.confirma(String.format(
                "Deseja remover o cliente de cpf %s?", cpf)))
            return;
        
        if (bd.delete(cpf)) {
            Ferramentas.alerta("Deletado com sucesso.");
            atualizarTabela();
            limparCampos();
        } else {
            Ferramentas.erro("Houve um erro ao tentar deletar o cliente.");
        }
    }
    
    /**
     * Função chamada ao clicar no botão Adicionar
     */
    private void clickBotaoAdicionar() {
        Cliente cliente = lerCliente();
        
        if (cliente == null)
            return;
                
        if (bd.insert(cliente)) {
            Ferramentas.alerta("Inserido com sucesso.");
            atualizarTabela();
            limparCampos();
        } else {
            Ferramentas.erro("Houve um erro ao tentar inserir o novo cliente.");
        } 
    }
    
    /**
     * Função chamada ao clicar no botão consultar
     */
    private void clickBotaoConsultar() {
        String cpf = lerCpf();
        if (!verificarCampos(cpf)) {
            Ferramentas.alerta("Preencha o CPF.");
            return;
        }
        
        getClienteByCpf(cpf);
        
        if (selecionado == null) {
            Ferramentas.alerta("Cliente não encontrado.");
            limparCampos();
        } else {
            preencherCampos(selecionado);
        }
    }
    
    /**
     * Função chamada ao clicar no botão Atualizar
     */
    private void clickBotaoAtualizar() {
        Cliente cliente = lerCliente();
        
        if (cliente == null)
            return;
        
        if (bd.update(cliente)) {
            Ferramentas.alerta("Cliente atualizado com sucesso.");
            limparCampos();
            atualizarTabela();
        } else {
            Ferramentas.erro("Erro ao atualizar cliente.");
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_clientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_atualizar = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        btn_adicionar = new javax.swing.JButton();
        btn_relatorio = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btn_consultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_cpf = new javax.swing.JFormattedTextField();
        txt_pontos = new javax.swing.JFormattedTextField();
        btn_limpar = new javax.swing.JButton();
        lbl_clientes = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setBorder(new javax.swing.border.MatteBorder(null));

        tabela_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Email", "Pontos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_clientes.getTableHeader().setReorderingAllowed(false);
        tabela_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_clientes);
        if (tabela_clientes.getColumnModel().getColumnCount() > 0) {
            tabela_clientes.getColumnModel().getColumn(0).setResizable(false);
            tabela_clientes.getColumnModel().getColumn(1).setResizable(false);
            tabela_clientes.getColumnModel().getColumn(2).setResizable(false);
            tabela_clientes.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btn_atualizar.setText("Atualizar");
        btn_atualizar.setToolTipText("Atualiza cliente. Todos os valores devem estar preenchidos.");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(btn_atualizar, gridBagConstraints);

        btn_remover.setText("Deletar");
        btn_remover.setToolTipText("Remove cliente por CPF. CPF deve estar preenchido.");
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(btn_remover, gridBagConstraints);

        btn_adicionar.setText("Adicionar");
        btn_adicionar.setToolTipText("Adicionar novo cliente. Todos os campos ao lado devem estar preenchidos.");
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(btn_adicionar, gridBagConstraints);

        btn_relatorio.setText("Gerar Relatório");
        btn_relatorio.setToolTipText("Gera relatório de todos os clientes em PDF.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(btn_relatorio, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados dos clientes"));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        btn_consultar.setText("Consultar");
        btn_consultar.setToolTipText("Buscar clientes por CPF");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel4.add(btn_consultar, gridBagConstraints);

        jLabel1.setText("CPF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel4.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel4.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Pontos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel4.add(jLabel4, gridBagConstraints);

        txt_nome.setToolTipText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 160;
        jPanel4.add(txt_nome, gridBagConstraints);

        txt_email.setToolTipText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 160;
        jPanel4.add(txt_email, gridBagConstraints);

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpf.setToolTipText("CPF. Apenas números");
        txt_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpfActionPerformed(evt);
            }
        });
        txt_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cpfKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 160;
        jPanel4.add(txt_cpf, gridBagConstraints);

        txt_pontos.setEditable(false);
        txt_pontos.setBackground(new java.awt.Color(204, 204, 204));
        txt_pontos.setForeground(new java.awt.Color(255, 0, 0));
        txt_pontos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txt_pontos.setToolTipText("Pontos. Apenas números");
        txt_pontos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pontosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(txt_pontos, gridBagConstraints);

        btn_limpar.setText("Limpar");
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel4.add(btn_limpar, gridBagConstraints);

        lbl_clientes.setForeground(new java.awt.Color(255, 0, 0));
        lbl_clientes.setText("0");

        jLabel6.setText("clientes encontrados.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbl_clientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_clientes)
                    .addComponent(jLabel6))
                .addContainerGap(92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

//------------------------------------------------------------------------------
// REGION: BOTÕES
//------------------------------------------------------------------------------
    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        // TODO add your handling code here:
        clickBotaoAdicionar();
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void txt_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfActionPerformed

    private void txt_pontosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pontosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pontosActionPerformed

    private void tabela_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_clientesMouseClicked
        // TODO add your handling code here:
        
        // Pega a tabela onde o mouse clicou
        JTable tabela = (JTable) evt.getSource();
        
        // Pega a posição do mouse relativa a tabela
        Point ponto = evt.getPoint();
        
        // Pega a linha onde o mouse clicou
        int linha = tabela.rowAtPoint(ponto);

        // Se foi click duplo e existe uma linha selecionada
        if (evt.getClickCount() == 2 && tabela.getSelectedRow() != -1) {

            // Lê os dados da tabela
            String cpf = (String) tabela.getValueAt(linha, 0);
            String nome = (String) tabela.getValueAt(linha, 1);
            String email = (String) tabela.getValueAt(linha, 2);
            String pontos = String.valueOf((int) tabela.getValueAt(linha, 3));
            
            txt_cpf.setText(cpf);
            txt_nome.setText(nome);
            txt_email.setText(email);
            txt_pontos.setText(pontos);
        }                
    }//GEN-LAST:event_tabela_clientesMouseClicked

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        // TODO add your handling code here:
        limparCampos();        
    }//GEN-LAST:event_btn_limparActionPerformed

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        // TODO add your handling code here:
        clickBotaoConsultar();
    }//GEN-LAST:event_btn_consultarActionPerformed

    private void txt_cpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfKeyTyped

    }//GEN-LAST:event_txt_cpfKeyTyped

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        // TODO add your handling code here:
        clickBotaoAtualizar();
    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        // TODO add your handling code here:
        clickBotaoDeletar();
    }//GEN-LAST:event_btn_removerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_relatorio;
    private javax.swing.JButton btn_remover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_clientes;
    private javax.swing.JTable tabela_clientes;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JFormattedTextField txt_pontos;
    // End of variables declaration//GEN-END:variables
}
