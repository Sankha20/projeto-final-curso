package dao;


import java.sql.*;

public abstract class ConnectionFactory {

    private static final String USER = "root";
    private static final String PASS = "798451";
    private static final String PORT = "3307";
    private static final String URL = String.format(
            "jdbc:mysql://localhost:%s/socasom?useUnicode=true&"
            + "useJDBCCompliantTimezoneShift=true&"
            + "useLegacyDatetimeCode=false&serverTimezone=UTC&"
            + "useSSL=false", PORT);

    /**
     *
     * @return Conexão com o banco de dados
     */
    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (Exception e) {
            System.out.println("ERRO: utilidades.getConnection. " + e);
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    public static void closeAll(Connection conexao, PreparedStatement stm, ResultSet res) {
        try {
            if (res != null && !res.isClosed()) {
                res.close();
                System.out.println("ResultSet Fechado");
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
                System.out.println("PreparedStatement Fechado");
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                //conexao = null;
                System.out.println("Connection Fechado");
                //System.out.println("Connection Null");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro no closeAll" + e);
            e.printStackTrace();
        }
    }

}
