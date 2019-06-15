/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.sql.*;
import java.util.*;
import model.Produto;

/**
 *
 * @author sirab
 */
public class DaoProdutos {

    private static Connection conexao;
    private static PreparedStatement stm;
    private static ResultSet res;
    private static final String SELECT_PRODUTOS = "select * from produto";

    public DaoProdutos() {
    }

    public static void getConnection() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = ConnectionFactory.getConnection();
            }
        } catch (Exception e) {
            System.out.println("erro ao tentar abrir a conexao com o CursoDao");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static List<Produto> findAll() {
        List<Produto> produtos = new ArrayList<>();
        getConnection();
        try {

            stm = conexao.prepareStatement(SELECT_PRODUTOS);
            res = stm.executeQuery();
            while (res.next()) {
                Produto produto = new Produto();
                produto.setId(res.getInt("id"));
                produto.setCompositor(res.getString("compositor"));
                produto.setAlbum(res.getString("album"));
                produto.setMidia(res.getString("midia"));
                produto.setPreco(res.getDouble("preco"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            Ferramentas.erro("erro ao tentar carregar tabela: " + e);
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao = null;
            ConnectionFactory.closeAll(conexao, stm, res);
        }

        return produtos;
    }

}
