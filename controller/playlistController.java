package controller;
//buat 
import DAOimplement.MusicImplement;
import DAOmusic.DAOMusic;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.DataMusic;
import model.songData;
import view.Playlist;

public class playlistController extends JDialog {//array songpath bakal bisa ditampilin di jendela terminal
    private MPcontroller mpcontroller;
    ArrayList<String> songPaths;
    private Playlist frame;
    MusicImplement implMusic;
    
    public playlistController(Playlist frame) {
        this.frame = frame;
        songPaths = new ArrayList<>();
        implMusic = new DAOMusic();
    }

    public playlistController(MPcontroller mpcontroller) {
        this.mpcontroller = mpcontroller;
        songPaths = new ArrayList<>();
    }
    
    public void tambahLagu() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new FileNameExtensionFilter("MP3", "mp3"));
        jFileChooser.setCurrentDirectory(new File("src/assets"));
        int result = jFileChooser.showOpenDialog(playlistController.this);

        File selectedFile = jFileChooser.getSelectedFile();
        if (result == JFileChooser.APPROVE_OPTION && selectedFile != null) {
            
            songPaths.add(selectedFile.getPath());
            DefaultTableModel tableModel = (DefaultTableModel) frame.getjTableLagu().getModel();
            tableModel.addRow(new Object[]{selectedFile.getPath()});
            
        }
    }

    
    public void insert() {
//        System.out.println("songpath"+ songPaths);
            try {
                String listName = frame.getjTextFieldListname().getText(); // Mendapatkan nama playlist dari JTextField
        
        for (String songPath : songPaths) {
            songData song = new songData(songPath);
            DataMusic music = new DataMusic();
            music.setNama(listName); // Mengatur nama playlist
            music.setJudul(song.getSongTitle()); // Mengatur nama playlist
            music.setArtis(song.getSongArtist()); // Mengatur nama playlist
            music.setLink(songPath); // Mengatur jalur lagu
            
            implMusic.insert(music); // Memasukkan lagu ke dalam playlist
        }
        
            } catch (NumberFormatException ex) {
                // Tampilkan pesan bahwa ada input kosong
                JOptionPane.showMessageDialog(null, "Invalid input!", "Warning", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
            }
        }
    }

    