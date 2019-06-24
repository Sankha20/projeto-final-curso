package utils;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Cliente;

public class DaoClientes {

    private final String SELECT_CLIENTES = "select * from cliente";

    public DaoClientes() {
    }

    public List<Cliente> carregarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stm = conn.prepareStatement(SELECT_CLIENTES);
//            stm.setBoolean(1, true);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                clientes.add(cliente);
            }

        } catch (Exception e) {
            Ferramentas.erro("erro ao tentar carregar tabela: " + e);
            e.printStackTrace();
            throw new RuntimeException();
        }
        return clientes;
    }

    public static Cliente buscarClientePorCpf(String cpf) {
        Cliente cliente = new Cliente();
        String query = "select * from cliente where cpf = " + cpf;
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stm = conn.prepareStatement(query);
//            stm.setBoolean(1, true);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            Ferramentas.erro("erro ao tentar carregar cliente: " + e);
            e.printStackTrace();
            throw new RuntimeException();
        }

        return cliente;
    }

}
