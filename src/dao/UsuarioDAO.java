/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    private final Connection connection;
    Long id;
    String carta;
    String edicao;
    String idioma;
    String foil;
    String valor;
    String qud;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Usuario objUsuario) {
        try {
            String sql;
            if (String.valueOf(objUsuario.getId()).isEmpty()) {
                sql = "INSERT INTO usuario(nome,cpf,email,telefone) VALUES(?,?,?,?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, objUsuario.getId());                    
                    stmt.setString(2, objUsuario.getCarta());
                    stmt.setString(3, objUsuario.getEdicao());
                    stmt.setString(4, objUsuario.getIdioma());
                    stmt.setString(5, objUsuario.getFoil());
                    stmt.setString(6, objUsuario.getValor());
                    stmt.setString(7, objUsuario.getQud());
                    stmt.execute();
                }

            } else {
                sql = "UPDATE usuario SET nome = ?, cpf = ?, email = ?, telefone = ? WHERE usuario.id = ?";

                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, objUsuario.getId());
                    stmt.setString(2, objUsuario.getCarta());
                    stmt.setString(3, objUsuario.getEdicao());
                    stmt.setString(4, objUsuario.getIdioma());
                    stmt.setString(5, objUsuario.getFoil());
                    stmt.setString(6, objUsuario.getValor());
                    stmt.setString(7, objUsuario.getQud());
                    
                    
                    stmt.execute();
                }

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList buscar(Usuario objUsuario) throws SQLException {
        try {
            String sql = "";
            if (!objUsuario.getCarta().isEmpty()) {
                sql = "SELECT * FROM usuario WHERE nome LIKE '%" + objUsuario.getCarta() + "%' ";

            } else if (!objUsuario.getEdicao().isEmpty()) {
                sql = "SELECT * FROM usuario WHERE cpf LIKE '%" + objUsuario.getEdicao() + "%' ";
            }
            ArrayList dado = new ArrayList();

            ResultSet rs;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                rs = ps.executeQuery();
                while (rs.next()) {
                    
                    dado.add(new Object[]{
                        rs.getInt("id"),
                        rs.getString("carta"),
                        rs.getString("edicao"),
                        rs.getString("idioma"),
                        rs.getString("foil"),
                        rs.getString("valor"),
                        rs.getString("qud"),
                    });
                    
                }
            }
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }

    }

    public void deletar(Usuario objUsuario) {
        try {
            String sql;
            if (!String.valueOf(objUsuario.getId()).isEmpty()) {
                sql = "DELETE FROM usuario WHERE usuario.id = ?";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, objUsuario.getId());
                    stmt.execute();
                }

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList listarTodos() {
        try {

            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("carta"),
                    rs.getString("edicao"),
                    rs.getString("idioma"),
                    rs.getString("foil"),
                    rs.getString("valor"),
                    rs.getString("qud")
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }
    }

    public static void testarConexao() throws SQLException {
        try (Connection objConnection = new ConnectionFactory().getConnection()) {
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso! ");
        }
    }

}
