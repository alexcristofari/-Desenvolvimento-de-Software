package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Professor;

public class ProfessorDAO {

    public List<Professor> getProfessors() {
        List<Professor> items = new ArrayList<>();
        String sql = "SELECT * FROM professor";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Professor item = new Professor();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setSexo(rs.getString("sexo"));
                item.setIdade(rs.getInt("idade"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void adicionarProfessor(Professor item) {
        String sql = "INSERT INTO professor (nome, sexo, idade) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getSexo());
            stmt.setInt(3, item.getIdade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
