package utilidades;

import classes.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DaoClientes {
    Conexao conexao = new Conexao();
    
    public ArrayList<Cliente> selectAll() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        String query = String.format("SELECT * FROM cliente ORDER BY nome;");
        
        try {
            Connection con = conexao.criarConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.addPontos(rs.getInt("pontos"));
                
                clientes.add(cliente);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
         
        return clientes;
    }
    
    public boolean delete (String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?;";
        try {
            Connection c = conexao.criarConexao();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cpf);
            
            ps.execute();
            
            ps.close();
            c.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return false;
    }
      
    public boolean update (Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, pontos = ? "
                + "WHERE cpf = ?;";
        try {
            Connection c = conexao.criarConexao();
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setInt(3, cliente.getPontos());
            ps.setString(4, cliente.getCpf());
            
            ps.execute();
            
            ps.close();
            c.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return false;
    }
    
    public boolean insert (Cliente cliente) {
        String sql = "INSERT INTO cliente (cpf, nome, email, pontos) "
                + "VALUES (?, ?, ?, ?);";  
        
        try {
            Connection c = conexao.criarConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEmail());
            ps.setInt(4, cliente.getPontos());
            
            ps.execute();
            ps.close();
            c.close();
            
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return false;
    }
}
