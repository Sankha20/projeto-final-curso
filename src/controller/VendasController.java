/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Cliente;
import utilidades.ConnectionFactory;
import utilidades.Ferramentas;

/**
 *
 * @author sirab
 */
public class VendasController {
    
    public static Cliente buscarClientePorCpf(String cpf) {
        Cliente cliente = new Cliente();
        final String SELECT_BY_NAME = "select * from cliente where nome like'" + cpf + "%' ";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stm = conn.prepareStatement(SELECT_BY_NAME);
//            stm.setBoolean(1, true);
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                Ferramentas.alerta("nao tem nada");
            }
            while (rs.next()) {
                
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
            }
            
        } catch (Exception e) {
            Ferramentas.erro("erro ao tentar carregar tabela: " + e);
            e.printStackTrace();
            throw new RuntimeException();
        }
        
        return cliente;
    }
    
}
