
import java.sql.Connection;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Caio César Atenas Gomes
 */
public class ConexaoDAO {
    
    public Connection conectaBD(){
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://";
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        return conn;
    }
    
}
