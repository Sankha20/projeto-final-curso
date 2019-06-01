/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexao {
    
    private final String USER = "usuario";
    private final String PASS = "usuario";
    private final String PORT = "3307";
    private final String URL = String.format(
            "jdbc:mysql://localhost:%s/socasom?useUnicode=true&"
                    + "useJDBCCompliantTimezoneShift=true&"
                    + "useLegacyDatetimeCode=false&serverTimezone=UTC&"
                    + "useSSL=false", PORT);
    
    
    /**
     * 
     * @return Conexão com o banco de dados
     */
    public Connection criarConexao() {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return connection;
    }
    
    
    /**
     * 
     * @param query String de query para update no banco
     * @return True = Deu certo | False = Deu errado
     */
    public boolean updateDB(String query) {
        boolean result = true;
        try {
            Connection connection = criarConexao();
            Statement statement = connection.createStatement();

            statement.executeUpdate(query);
            statement.close();

            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
            result = false;
        }

        return result;
    }
    
}
