package DAOmusic;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.Connector;
import DAOimplement.MusicImplement;
import model.DataMusic;
import javax.swing.JOptionPane;

public class DAOMusic implements MusicImplement {

    Connection connection;
    final String select = "SELECT * FROM playlist;";
    final String insert = "INSERT INTO playlist (nama ,judul, artis, link) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE playlist SET nama = ?, judul = ?, artis = ?, link = ? WHERE id = ?;";
    final String delete = "DELETE FROM playlist WHERE id= ?";

    public DAOMusic() {
        connection = Connector.connection();
    }

    public void insert (DataMusic dm){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dm.getNama()); 
            statement.setString(2, dm.getJudul());          
            statement.setString(3, dm.getArtis()); 
            statement.setString(4, dm.getLink());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan: Data dengan primary key tersebut sudah ada.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
   
    
    public void update (DataMusic dm){
        if (dm == null) {
            JOptionPane.showMessageDialog(null, "DataMusic tidak boleh null!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, dm.getNama());
            statement.setString(2, dm.getJudul());
            statement.setString(3, dm.getArtis());
            statement.setString(4, dm.getLink());
            statement.setInt(5, dm.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public void delete (int  id){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void select (DataMusic dm){}
    public List<DataMusic> getAll(){
        List<DataMusic> dm = null;
        try {
            dm = new ArrayList<DataMusic>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            while (resultSet.next()) {
                DataMusic music = new DataMusic();
                music.setId(resultSet.getInt("id"));
                music.setNama(resultSet.getString("nama"));
                music.setJudul(resultSet.getString("judul"));
                music.setArtis(resultSet.getString("artis"));
                music.setLink(resultSet.getString("link"));
                dm.add(music);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOMusic.class.getName()).log(Level.SEVERE, null, ex);
        }
    return dm;
    }
}
