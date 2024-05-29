package controller;
//buat CRUD playlist
import java.util.List;
import DAOmusic.DAOMusic;
import DAOimplement.MusicImplement;
import java.util.ArrayList;
import model.*;
import view.Playlist;
import javax.swing.JOptionPane;
import view.PlaylistEdit;

public class MusicController {
    PlaylistEdit frame;
    MusicImplement implMusic;
    List<DataMusic> dm;
    ArrayList<String> songPaths;
    
    private String deleteValue;
    private boolean insertError = false;
    private boolean updateError = false;
    private boolean deleteError = false;

    private boolean isFormValid() {
        return !frame.getjTextFieldJudul().getText().isEmpty()
            && !frame.getjTextFieldNama().getText().isEmpty()
            && !frame.getjTextFieldArtis().getText().isEmpty()
            && !frame.getjTextFieldLink().getText().isEmpty();
   
    }
    
    public MusicController (PlaylistEdit frame){
    this.frame = frame; 
    implMusic = new DAOMusic();
    dm = implMusic.getAll();
    }
    
    public void isitable(){
        dm = implMusic.getAll();
        ModelTabelMusic mt = new ModelTabelMusic(dm);
        frame.getjTablePlaylistupdate().setModel(mt);
        frame.getjTablePlaylistupdate().getColumnModel().getColumn(0).setMaxWidth(30);
    }
    public void insert() 
    { 
    }
    
     public void update() {
          if (isFormValid()) {
            try {
                DataMusic music = new DataMusic();
                music.setId(Integer.parseInt(frame.getjTextFieldId().getText()));
                music.setNama(frame.getjTextFieldNama().getText());
                music.setJudul(frame.getjTextFieldJudul().getText());
                music.setArtis(frame.getjTextFieldArtis().getText());
                music.setLink(frame.getjTextFieldLink().getText());     
                implMusic.update(music);
                updateError = false;
                JOptionPane.showMessageDialog(null, "Data Updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                // Tampilkan pesan bahwa ada input kosong
                JOptionPane.showMessageDialog(null, "Invalid input!", "Warning", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
                updateError = true;
            }
        } else {
            // Tampilkan pesan peringatan bahwa data belum diisi
            JOptionPane.showMessageDialog(null, "Please Fill the form!", "Warning", JOptionPane.WARNING_MESSAGE);
            updateError = true;
        }
    }
    
    public void delete() {
        if (isFormValid()) {
            try {
                DataMusic music = new DataMusic();
                 int deleteValue= Integer.parseInt(frame.getjTextFieldId().getText());
                implMusic.delete(deleteValue);
                deleteError = false;
                JOptionPane.showMessageDialog(null, "Data Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                // Tampilkan pesan bahwa ada input kosong
                JOptionPane.showMessageDialog(null, "Invalid Input!", "Warning", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
                deleteError = true;
            }
        } else {
            // Tampilkan pesan peringatan bahwa data belum diisi
            JOptionPane.showMessageDialog(null, "Please fill the form!", "Warning", JOptionPane.WARNING_MESSAGE);
            deleteError = true;
        }
    }

    public boolean isInsertError() {
        return insertError;
    }

    public boolean isUpdateError() {
        return updateError;
    }

    public boolean isDeleteError() {
        return deleteError;
    }
}
