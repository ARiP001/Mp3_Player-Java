package controller;
//nyimpen void void yang bakal dipake buat play music
import java.io.File;
import java.util.Hashtable;
import javax.swing.JLabel;
import model.*;
import view.MainView;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MPcontroller {
    MainView frame;
    boolean isRepeatMode = false;
    
    //constructor
    public MPcontroller (MainView frame){
    this.frame = frame; 
    }
    
    // mengecek status repeat mode
    public boolean isRepeatMode(){
        return isRepeatMode;
    }
    
    // Mengubah status mode pengulangan menjadi kebalikan dari nilai saat ini
    public void toggleRepeatMode() {
        isRepeatMode = !isRepeatMode; 
    }
    
    public void setfileChooser(){
        //filter pemilihan lagu
        frame.getjFileChooser1().setCurrentDirectory(new File("src/assets"));
        frame.getjFileChooser1().setFileFilter(new FileNameExtensionFilter("MP3", "mp3"));
    }
    
    // untuk set update slider
    public void setPlaybackSliderValue(int frameSong){
        frame.getjSliderPlayBack().setValue(frameSong);
    }
    
    //untuk updata judul lagu dan artis
    public void updateSongTitleAndArtist(songData song){
        frame.getjLabelJudul().setText(song.getSongTitle());
        frame.getjLabelArtis().setText(song.getSongArtist());
    }
    public void updatePlaybackSlider(songData song){
        // update max count untuk slider
        frame.getjSliderPlayBack().setMaximum(song.getMp3File().getFrameCount());

        // create the song length label 
        //kenapa hash ? di gpt seperti itu
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();

        frame.getjLabelAwal().setText("00:00");
        frame.getjLabelAkhir().setText(song.getSongLength());
        labelTable.put(0, frame.getjLabelAwal());
        labelTable.put(song.getMp3File().getFrameCount(), frame.getjLabelAkhir());
        
        frame.getjSliderPlayBack().setLabelTable(labelTable);
        frame.getjSliderPlayBack().setPaintLabels(true);
    }
    
    //menampilkan tombol pause dan menghide tombol continue
    public void enablePauseButtonDisablePlayButton(){
        frame.getjButtonContinue().setVisible(true);
        frame.getjButtonContinue().setEnabled(true);

        frame.getjButtonPause().setVisible(false);
        frame.getjButtonPause().setEnabled(false);  
        
    }

    //menampilkan tombol continue dan menghide tombol pause
    public void enablePlayButtonDisablePauseButton(){
        frame.getjButtonContinue().setVisible(false);
        frame.getjButtonContinue().setEnabled(false);
        
        frame.getjButtonPause().setVisible(true);
        frame.getjButtonPause().setEnabled(true);
    }
}