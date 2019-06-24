/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.List;
import model.*;

import utils.ConnectionFactory;
import utils.Ferramentas;

/**
 *
 * @author sirab
 */
public class DaoItemVenda {

    public void insertItem(List<Produto> produtos, Venda venda) throws SQLException {
        String sql = "INSERT INTO item_venda (produto_id, venda_id) "
                + "VALUES (?, ?);";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepStatement = connection.prepareStatement(sql);
        try {
            connection.setAutoCommit(false);
            for (Produto produto : produtos) {
                prepStatement.setInt(1, produto.getId());
                prepStatement.setInt(2, venda.getId());
                prepStatement.execute();
                connection.commit();
                System.out.println("Item salvo com sucesso!");
            }

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println("Ocorreu algum erro no metodo salvar(Aluno aluno)");
            e.printStackTrace();
            Ferramentas.erro("Houve um erro ao inserir um item.");
            System.err.println(e);
            throw new RuntimeException(e);
        } finally {
            prepStatement.close();
            connection.close();

        }
    }
}
