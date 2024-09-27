import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/escola?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root"; // Seu usuário MySQL
    private static final String PASSWORD = "1234"; // Sua senha MySQL

    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão realizada com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no BD: " + e.getMessage());
            return null;
        }
    }
}
