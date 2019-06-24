/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import model.*;
import dao.*;
import java.util.*;

/**
 *
 * @author França
 */
public class VendasController {

    public static Cliente buscarPorCpf(String cpf) {

        return DaoClientes.buscarClientePorCpf(cpf);
    }

    public static void gravarVenda(Venda venda, List<Produto> produtos) {
        DaoClientes dc = new DaoClientes();
        
        try {
            DaoVendas daoVendas = new DaoVendas();
            Venda vendaRealizada = daoVendas.insert(venda);
            Cliente c = venda.getCliente();
            
            DaoItemVenda daoItemVenda = new DaoItemVenda();
            daoItemVenda.insertItem(produtos, vendaRealizada);
            
            // VIC: Adcionado sistema de pontos
            c.addPontos(produtos.size() * 5);
            dc.update(c);
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
