package utilidades;

import java.sql.*;
import java.util.*;
import model.Produto;

/**
 *
 * @author França
 */
public class DaoProdutos {

    // Comentário Victor: Esta parte do código é desnecessária, mas vou deixar aqui e vocês resolvam entre vcs.
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
    
    /*
    Daqui p/ baixo: Código Rodrigo
    Eu, Victor, alterei algumas linhas para compatibilidade
    */
    
    public ArrayList<Produto> listaProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        
        String query = String.format("SELECT * FROM produto ORDER BY id;");
        
        try {
            // Victor: Mudei esta linha \/
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setAlbum(rs.getString("album"));
                produto.setCompositor(rs.getString("compositor"));
                produto.setMidia(rs.getString("midia"));
                produto.setGenero(rs.getString("genero"));
                produto.setPreco(rs.getDouble("preco"));
                
                produtos.add(produto);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
         
        return produtos;
    }
    
    public boolean insereProduto (Produto objProduto) {
        String sql = "INSERT INTO produto (album, compositor, midia, genero, preco) VALUES (?, ?, ?, ?, ?);";  
        
        try {
            // Victor: Mudei esta linha \/
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, objProduto.getAlbum());
            ps.setString(2, objProduto.getCompositor());
            ps.setString(3, objProduto.getMidia());
            ps.setString(4, objProduto.getGenero());
            ps.setDouble(5, objProduto.getPreco());
            
            ps.execute();
            ps.close();
            con.close();
            // Victor: Mudei esta linha \/
             Ferramentas.alerta("Adicionado com sucesso");
            return true;
            
        } catch (SQLException ErroSql) {
            // Victor: Mudei esta linha \/
            Ferramentas.erro("Erro ao adicionar no banco: "+ErroSql);
            System.err.println(ErroSql);
        }
        
        return false;
    }
    
    public boolean updateProduto (Produto objproduto) {
        String sql = "UPDATE produto SET album = ?, compositor = ?, midia = ?, genero = ?, preco = ? WHERE id = ?;";
        try {
            // Victor: Mudei esta linha \/
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, objproduto.getAlbum());
            ps.setString(2, objproduto.getCompositor());
            ps.setString(3, objproduto.getMidia());
            ps.setString(4, objproduto.getGenero());
            ps.setDouble(5, objproduto.getPreco());
            ps.setInt(6, objproduto.getId());
            
            ps.execute();
            
            ps.close();
            con.close();
            // Victor: Mudei esta linha \/
            Ferramentas.alerta("Alteração bem sucedida");
            return true;
        } catch (SQLException ErroSql) {
            // Victor: Mudei esta linha \/
            Ferramentas.erro("Erro ao adicionar no banco: "+ErroSql);
            System.err.println(ErroSql);
        }
        
        return false;
    }
    
    public boolean excluirProduto (Produto objProduto) {
        String sql = "DELETE FROM produto WHERE id = ?;";
        
        try {
            // Victor: Mudei esta linha \/
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, objProduto.getId());
            
            ps.execute();
            
            ps.close();
            con.close();
            
            // Victor: Mudei esta linha \/
            Ferramentas.alerta("Removido com sucesso");
            return true;
        } catch (SQLException ErroSql) {
            
            // Victor: Mudei esta linha \/
            Ferramentas.erro("Erro ao adicionar no banco: "+ErroSql);
            System.err.println(ErroSql);
        }
        
        return false;
    }
    
    public static ResultSet localizarProduto(String nome) {//Busca pelo Album, simples
      
      try{
            // Victor: Mudei esta linha \/
            Connection con = ConnectionFactory.getConnection();
            String query = "SELECT * FROM produto WHERE album LIKE '" +nome +"%'"; 
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
            }
    }
  
  
   public static ResultSet localizarProduto2(String nome) {//Busca pelo compositor, simples
        try{
            // Victor: Mudei esta linha \/
            Connection con = ConnectionFactory.getConnection();
            String query = "SELECT * FROM produto WHERE compositor LIKE '" +nome +"%'";
            
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return rs;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
            }
    }
   
    public static ResultSet localizarProduto3(String nome) {//Busca pela ID, simples
        try{
            // Victor: Mudei esta linha \/
            Connection con = ConnectionFactory.getConnection();
            String query = "SELECT * FROM produto WHERE id = '" +nome +"%'";
            
            PreparedStatement stmt= con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return rs;
        }catch (SQLException e){
            // Victor: Mudei esta linha \/
            System.out.println("Erro: localizarProduto3 = " + e.getMessage());
            return null;
            }
    }

}
