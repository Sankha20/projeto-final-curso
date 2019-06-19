package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}