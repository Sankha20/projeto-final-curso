package utilidades;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import model.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Guarda as conexões entre o modelo Cliente e a tabela cliente no banco
 * @author Victor Pontes
 */
public class DaoClientes {
    
    /**
     * Busca todos os clientes do banco e retorna em forma de ArrayList
     * @return <code>ArrayList</code>
     * de todos os clientes.
     */
    public ArrayList<Cliente> selectAll() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        String query = String.format("SELECT * FROM cliente ORDER BY nome;");
        
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepStatement.executeQuery();
            
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.addPontos(resultSet.getInt("pontos"));
                
                clientes.add(cliente);
            }
            
            resultSet.close();
            prepStatement.close();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
         
        return clientes;
    }
    
    /**
     * Deleta um cliente pelo cpf
     * @param cpf o cpf do cliente
     * @return <code>boolean</code>
     * indicando se deu certo ou não
     */
    public boolean delete (String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?;";
        try {
            Connection connection = ConnectionFactory.getConnection();
            
            PreparedStatement prepStatement = connection.prepareStatement(sql);
            prepStatement.setString(1, cpf);
            
            prepStatement.execute();
            
            prepStatement.close();
            connection.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return false;
    }
      
    /**
     * Atualiza o cliente no banco
     * @param cliente modelo do cliente preenchido
     * @return <code>boolean</code>
     * indicando se deu certo ou não.
     */
    public boolean update (Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, pontos = ? "
                + "WHERE cpf = ?;";
        try {
            Connection connection = ConnectionFactory.getConnection();
            
            PreparedStatement prepStatement = connection.prepareStatement(sql);
            prepStatement.setString(1, cliente.getNome());
            prepStatement.setString(2, cliente.getEmail());
            prepStatement.setInt(3, cliente.getPontos());
            prepStatement.setString(4, cliente.getCpf());
            
            prepStatement.execute();
            
            prepStatement.close();
            connection.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return false;
    }
    
    
    /**
     * Insere novo cliente no banco
     * @param cliente O novo cliente a ser inserido
     * @return <code>boolean</code>
     * Indicando se deu certo ou não.
     */
    public boolean insert (Cliente cliente) {
        String sql = "INSERT INTO cliente (cpf, nome, email, pontos) "
                + "VALUES (?, ?, ?, ?);";  
        
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(sql);
            
            prepStatement.setString(1, cliente.getCpf());
            prepStatement.setString(2, cliente.getNome());
            prepStatement.setString(3, cliente.getEmail());
            prepStatement.setInt(4, cliente.getPontos());
            
            prepStatement.execute();
            prepStatement.close();
            connection.close();
            
            return true;
            
        } catch (MySQLIntegrityConstraintViolationException e) {
            Ferramentas.erro("CPF já cadastrado.");
            
        } catch (SQLException e) {
            Ferramentas.erro("Houve um erro ao tentar adicionar novo cliente.");
            System.err.println(e);
        }

        return false;
    }
}
