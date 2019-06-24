/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import model.Venda;
import utils.Ferramentas;

/**
 *
 * @author sirab
 */
public class DaoVendas {

    public Venda insert(Venda venda) throws SQLException {
   
        String query = "INSERT INTO venda(forma_pagamento,id_cliente, total, data_venda) VALUES (?,?,?,?)";
        System.out.println(venda.getTotal());
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepStatement = null;

        try {
            prepStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            connection.setAutoCommit(false);

            prepStatement.setString(1, venda.getFormaPagamento());
            prepStatement.setInt(2, venda.getCliente().getId());
            prepStatement.setBigDecimal(3, venda.getTotal());
            prepStatement.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
            prepStatement.executeUpdate();
            
            connection.commit();
            final ResultSet rs = prepStatement.getGeneratedKeys();
            if (rs.next()) {
                venda.setId(rs.getInt(1));
            }
            prepStatement.close();
            connection.close();

            return venda;
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
