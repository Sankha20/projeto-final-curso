package view;

// Victor: Ajeitei alguns imports
import dao.ConnectionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Produto;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import dao.DaoProdutos;
import javax.swing.SwingUtilities;
import utils.Ferramentas;
import static utils.Ferramentas.alerta;

/**
 * @author Rodrigo da Soledade Elias
 */
public class Produtos extends javax.swing.JPanel {

    DaoProdutos bd = new DaoProdutos();
    ArrayList<Produto> produtos;
    Produto selecionado = null;

    /**
     * Creates new form Produtos
     */
    public Produtos() {
        initComponents();
        desativaBotoes();
        desativaCampos();
        atualizarTabela();
        txt_id.setEditable(false);
    }

    /*------------------------------------------------*/
 /*Função que atualiza a tabela de produtos*/
    private void atualizarTabela() {
        // Atualiza a lista de clientes
        produtos = bd.listaProdutos();

        // Salva o modelo da tabela
        DefaultTableModel tab = (DefaultTableModel) tabela_produtos.getModel();

        // Apaga todo o conteúdo da tabela
        tab.setRowCount(0);

        //Definindo tamanho de uma parte da tabela.
        tabela_produtos.getColumnModel().getColumn(0).setPreferredWidth(4);

        produtos.forEach((produto) -> {
            tab.addRow(produto.formatoTabela());
        });

        int quantidade = tab.getRowCount();
        lbl_produtos.setText(String.valueOf(quantidade));
    }

    private void atualizarTabela2() {

        String coluna = comboBusca.getSelectedItem().toString();
        String busca = txt_busca.getText();

        produtos = bd.buscaProduto(coluna, busca);

        DefaultTableModel tab = (DefaultTableModel) tabela_produtos.getModel();

        tab.setRowCount(0);

        tabela_produtos.getColumnModel().getColumn(0).setPreferredWidth(4);
        produtos.forEach((produto) -> {
            tab.addRow(produto.formatoTabela());
        });
        int quantidade = tab.getRowCount();
        lbl_produtos.setText(String.valueOf(quantidade));
        

    }

    /*Limpa os campos e combobox*/
    private void limparCampos() {
        txt_id.setText(null);
        txt_album.setText(null);
        txt_compositor.setText(null);
        comboMidia.setSelectedIndex(-1);
        comboGenero.setSelectedIndex(-1);
        txt_preco.setText(null);
        selecionado = null;
    }
//checa campos vazios

    private boolean camposVazios() {
        if (txt_album.getText().trim().equals("") || txt_compositor.getText().trim().equals("")
                || txt_preco.getText().trim().equals("")) {
            return true;
        }
        return false;
    }

    /*Desativa & Ativa os botões*/
    private void desativaBotoes() {

        btIncluir.setEnabled(false);
        btDeletar.setEnabled(false);
        btAlterar.setEnabled(false);

    }

    private void ativaBotoes() {

        btIncluir.setEnabled(true);
        btDeletar.setEnabled(true);
        btAlterar.setEnabled(true);

    }

    /*Desativa & Ativa Campos*/
    private void desativaCampos() {
        txt_id.setEnabled(false);
        txt_album.setEnabled(false);
        txt_compositor.setEnabled(false);
        comboMidia.setEnabled(false);
        comboGenero.setEnabled(false);
        txt_preco.setEnabled(false);

    }

    private void ativaCampos() {
        txt_id.setEnabled(true);
        txt_album.setEnabled(true);
        txt_compositor.setEnabled(true);
        comboMidia.setEnabled(true);
        comboGenero.setEnabled(true);
        txt_preco.setEnabled(true);

    }

    /*
    //Ro: A função de gerar o relatório em si do exercício do Alex
    public void relatorioProduto() throws JRException, SQLException{
        ResultSet rs = null;
        int numero = 0;

       // if (d.testaNum(jTxtNumero.getText(), titulo)) {
                 
            if (! txt_id.getText().isEmpty() ){
               numero = Integer.parseInt(txt_id.getText());
            }
            
            rs = bd.imprimir(numero);

            //implementação da interface JR ResultSetDataSource
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            
            //criei um package pros relatórios, usei o blue simple.
            JasperReport report = JasperCompileManager.compileReport("src/reports/realatorioproduto.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, null, jrRS);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

           JFileChooser abrir = new JFileChooser();
            int retorno = abrir.showOpenDialog(null);
            if (retorno == JFileChooser.APPROVE_OPTION) {
                salvar1 = abrir.getSelectedFile().getAbsolutePath();
            }
            salvar2 = salvar1 + ".pdf";
            //salvar2 = "cargo.pdf";
            JasperExportManager.exportReportToPdfFile(print, salvar2);

            JOptionPane.showMessageDialog(null, "Listagem pronta!");
            limparCampos();
       // }
    }*/
    private void newReport() {
        try {

            String report = "src\\reports\\RelatorioProduto.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(report);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, ConnectionFactory.getConnection());
            new JasperViewer(jp, false).setVisible(true);
            JasperExportManager.exportReportToPdfFile(jp, "relatorio-produto.pdf");

        } catch (Exception e) {
            System.err.println("ERRO: newReport\n" + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btIncluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_album = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_compositor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboMidia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_preco = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        lbl_produtos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_produtos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        comboBusca = new javax.swing.JComboBox<>();
        txt_busca = new javax.swing.JTextField();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btIncluir.setText("Incluir");
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btDeletar.setText("Excluir");
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        jButton4.setText("Relatório");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btNovo.setText("Novo / Limpar");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDeletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Informações do Produto"));

        jLabel2.setText("Nome do Álbum:");

        jLabel3.setText("Compositor:");

        jLabel4.setText("Tipo de Mídia:");

        comboMidia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CD", "DVD", "Blue Ray", "Vinil", "Cassete" }));
        comboMidia.setSelectedIndex(-1);
        comboMidia.setToolTipText("");
        comboMidia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMidiaActionPerformed(evt);
            }
        });

        jLabel5.setText("Gênero:");

        comboGenero.setMaximumRowCount(10);
        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alternativo", "Axé", "Blues", "Bolero", "Bossa Nova", "Brega", "Clássico", "Country", "Cuarteto", "Cumbia", "Dance", "Disco", "Eletrônica", "Emocore", "Fado", "Folk", "Forró", "Funk", "Funk Internacional", "Gospel/Religioso", "Grunge", "Guarânia", "Gótico", "Hard Rock", "Hardcore", "Heavy Metal", "Hip Hop/Rap", "House", "Indie", "Industrial", "Infantil", "Instrumental", "J-Pop/J-Rock", "Jazz", "Jovem Guarda", "K-Pop/K-Rock", "MPB", "Mambo", "Marchas/Hinos", "Mariachi", "Merengue", "Música andina", "New Age", "New Wave", "Pagode", "Pop", "Pop Rock", "Post-Rock", "Power-Pop", "Psicodelia", "Punk Rock", "R&B", "Ranchera", "Reggae", "Reggaeton", "Regional", "Rock", "Rock Progressivo", "Rock and Roll", "Rockabilly", "Romântico", "Salsa", "Samba", "Samba Enredo", "Sertanejo", "Ska", "Soft Rock", "Soul", "Surf Music", "Tango", "Tecnopop", "Trova", "Velha Guarda", "World Music", "Zamba", "Zouk" }));
        comboGenero.setSelectedIndex(-1);
        comboGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGeneroActionPerformed(evt);
            }
        });

        jLabel6.setText("Preço:");

        jLabel9.setText("Registro:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(44, 44, 44)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboMidia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 168, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_album)
                            .addComponent(txt_compositor))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_album, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_compositor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboMidia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Vladimir Script", 0, 18)); // NOI18N
        jLabel7.setText("SocaSom");

        lbl_produtos.setText("0");

        jLabel8.setText("Produtos Listados.");

        tabela_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Album", "Compositor", "Midia", "Genero", "Preco"
            }
        ));
        tabela_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_produtos);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Busca por:"));

        jButton5.setText("Localizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        comboBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "album", "compositor", "midia", "genero" }));
        comboBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBuscaActionPerformed(evt);
            }
        });

        txt_busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(comboBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_produtos)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed

        if (camposVazios() == true) {
            Ferramentas.alerta("Preencha os campos necessários para inserção.");
        } else {
            Produto p = new Produto();

            p.setAlbum(txt_album.getText());
            p.setCompositor(txt_compositor.getText());
            p.setMidia((String) comboMidia.getSelectedItem());
            p.setGenero((String) comboGenero.getSelectedItem());
            Double d = Double.parseDouble(txt_preco.getText());
            p.setPreco(d);

            bd.insereProduto(p);
            atualizarTabela();
            limparCampos();
        }

    }//GEN-LAST:event_btIncluirActionPerformed

    private void comboGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGeneroActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        atualizarTabela2();
        btIncluir.setEnabled(false);
        btAlterar.setEnabled(true);
        btDeletar.setEnabled(true);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void tabela_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtosMouseClicked
        Produto p = new Produto();

        int index = tabela_produtos.getSelectedRow();
        p = bd.listaProdutos().get(index);

        txt_id.setText(String.valueOf(p.getId()));
        txt_album.setText(p.getAlbum());
        txt_compositor.setText(p.getCompositor());
        comboMidia.setSelectedItem(p.getMidia());
        comboGenero.setSelectedItem(p.getGenero());
        txt_preco.setText(String.valueOf(p.getPreco()));

        ativaCampos();
        btIncluir.setEnabled(false);
        btAlterar.setEnabled(true);
        btDeletar.setEnabled(true);

    }//GEN-LAST:event_tabela_produtosMouseClicked


    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (camposVazios() == true) {
            Ferramentas.alerta("Preencha os campos necessários para inserção.");
        } else {
            Produto p = new Produto();

            int index = tabela_produtos.getSelectedRow();//retorna linha selecionada
            p = bd.listaProdutos().get(index);//retorna objeto no array pelo index

            switch (JOptionPane.showConfirmDialog(null, "ALTERAÇÃO DE DADOS:\n Album : " + p.getAlbum()
                    + "\nCompositor : " + p.getCompositor() + "\nMidia : " + p.getMidia() + "\nGenero : " + p.getGenero()
                    + "\nPreço : " + p.getPreco() + "\nALTERAÇÃO SERÁ :\n Album : " + txt_album.getText()
                    + "\nCompositor : " + txt_compositor.getText() + "\nMidia : " + comboMidia.getSelectedItem()
                    + "\nGenero : " + comboGenero.getSelectedItem() + "\nPreço : " + txt_preco.getText() + "\nDeseja fazer a alteração?",
                    "Alteração de Dados", JOptionPane.YES_NO_OPTION)) {
                case 0:

                    //sets de novas infos para update do objeto
                    p.setAlbum(txt_album.getText());
                    p.setCompositor(txt_compositor.getText());
                    p.setMidia((String) comboMidia.getSelectedItem());
                    p.setGenero((String) comboGenero.getSelectedItem());
                    Double d = Double.parseDouble(txt_preco.getText());
                    p.setPreco(d);
                    int i = Integer.parseInt(txt_id.getText());
                    p.setId(i);

                    //altera no bd.
                    bd.updateProduto(p);
                    atualizarTabela();
                    limparCampos();
                    desativaBotoes();
                    desativaCampos();
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }


    }//GEN-LAST:event_btAlterarActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        Produto p = new Produto();

        int index = tabela_produtos.getSelectedRow();
        p = bd.listaProdutos().get(index);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o produto abaixo?: \nRegistro : " + p.getId() + "\nAlbum : "
                + p.getAlbum() + "\nCompositor : " + p.getCompositor() + "\nMidia : " + p.getMidia() + "\nGenero : " + p.getGenero()
                + "\nPreço : " + p.getPreco(), "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {

            case 0:
                bd.excluirProduto(p);
                atualizarTabela();
                limparCampos();
                desativaBotoes();
                break;

            case 1:
                JOptionPane.showMessageDialog(null, "Nennhuma exclusão foi feita", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                break;
        }


    }//GEN-LAST:event_btDeletarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ativaBotoes();
        ativaCampos();
        atualizarTabela();
        limparCampos();
        btAlterar.setEnabled(false);
        btDeletar.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Ro: Trycatch pq senão o Jasper Reclama
        newReport();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void comboMidiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMidiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMidiaActionPerformed

    private void txt_buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscaActionPerformed

    private void comboBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBuscaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox<String> comboBusca;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JComboBox<String> comboMidia;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_produtos;
    private javax.swing.JTable tabela_produtos;
    private javax.swing.JTextField txt_album;
    private javax.swing.JTextField txt_busca;
    private javax.swing.JTextField txt_compositor;
    private javax.swing.JTextField txt_id;
    private javax.swing.JFormattedTextField txt_preco;
    // End of variables declaration//GEN-END:variables
}
