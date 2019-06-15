package utilidades;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Cliente;
import utilidades.Conexao;

public class DaoClientes {

    private final String SELECT_CLIENTES = "select * from cliente";
    Conexao conexao = new Conexao();

    public DaoClientes() {
    }

    public List<Cliente> carregarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        try {
            Connection conn = conexao.criarConexao();
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
}
