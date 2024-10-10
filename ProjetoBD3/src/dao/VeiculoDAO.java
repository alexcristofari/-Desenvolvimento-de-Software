package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Veiculo;

public class VeiculoDAO {

    // Método para adicionar um veículo
    public void adicionarVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (modelo, marca, placa, pessoa_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getPlaca());
            stmt.setInt(4, veiculo.getPessoa().getId()); // ID da pessoa associada

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para editar um veículo pelo ID
    public void editarVeiculo(Veiculo veiculo) {
        String sql = "UPDATE veiculo SET modelo = ?, marca = ?, placa = ?, pessoa_id = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getPlaca());
            stmt.setInt(4, veiculo.getPessoa().getId()); // ID da pessoa associada
            stmt.setInt(5, veiculo.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um veículo pelo ID
    public void excluirVeiculo(int id) {
        String sql = "DELETE FROM veiculo WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
