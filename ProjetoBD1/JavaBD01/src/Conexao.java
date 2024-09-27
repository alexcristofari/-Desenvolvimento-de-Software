import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bdaula01?useTimezone=true&serverTimezone=UTC",
                "root", "1234"
            );
            System.out.println("Conexão realizada com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no BD: " + e.getMessage());
            return null;
        }
    }
}
