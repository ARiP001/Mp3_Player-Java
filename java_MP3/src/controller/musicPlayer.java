package controller;
//buat play lagu
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.*;
import model.songData;

public class musicPlayer extends PlaybackListener {//playback == jlayer
    private MPcontroller MPcon;
    private boolean isPaused;
    private boolean songFinished;
    
    // digunakan untuk mengupdate isPause supaya lebih syncronous
    private static final Object playSignal = new Object();
    // mengambil data lagu dari songData class
    private songData currentSong;

    //Jlayer library untuk menghandle play music
    private AdvancedPlayer advancedPlayer;

    //menyimpan frame terakhir ketika playback selesai (untuk  pause dan resume)
    private int currentFrame;
   
    //meng-track berapa miliseconds lagu telah dimainkan (untuk update slider)
    private int currentTimeInMilli;

    // constructor
    public musicPlayer(MPcontroller MPcon){
        this.MPcon = MPcon;
    }
    
    public void setCurrentFrame(int frame){
        currentFrame = frame;
    }
    
    public void setCurrentTimeInMilli(int timeInMilli){
        currentTimeInMilli = timeInMilli;
    }
    
    public void loadSong(songData song){
        currentSong = song;

        //stop pemutar lagu (pause/ selesai)
        if(!songFinished)
            stopSong();

        //setelah ambil dari filechooser, lagu akan not null dan akan dimainkan
        if(currentSong != null){
            // reset frame
            currentFrame = 0;

            // reset current time in milli
            currentTimeInMilli = 0;

            // update tampilan slider
            MPcon.setPlaybackSliderValue(0);

            playCurrentSong();
        }
    }
    
    //untuk pause lagu
    public void pauseSong(){
        if(advancedPlayer != null){
            // update flag
            isPaused = true;
            stopSong();
        }
    }

    //untuk pause/stop lagu
    public void stopSong(){
        if(advancedPlayer != null){
            advancedPlayer.stop();
            advancedPlayer.close();
            advancedPlayer = null;
        }
    }
    
    //untuk play lagu dari path yang diambil diawal
    public void playCurrentSong(){
        try{
            // baca mp3 file dari file path
            FileInputStream fileInputStream = new FileInputStream(currentSong.getFilePath());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            //buat advanced player
            advancedPlayer = new AdvancedPlayer(bufferedInputStream);
            advancedPlayer.setPlayBackListener(this);

            // start music
            startMusicThread();

            // start playback slider thread
            startPlaybackSliderThread();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // buat thread untuk menghandle play lagu
    private void startMusicThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    if(isPaused){
                        synchronized(playSignal){
                            // update flag
                            isPaused = false;

                            // notify the other thread to continue (makes sure that isPaused is updated to false properly)
                            //memberi notif ke thread lain tuntuk continue 
                            //(memastikan isPaused sudah update ke false dengan benar)
                            playSignal.notify();
                        }

                        // resume music from last frame
                        advancedPlayer.play(currentFrame, Integer.MAX_VALUE);
                    }else{
                        // play music from the beginning
                        advancedPlayer.play();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // create a thread that will handle updating the slider
    private void startPlaybackSliderThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(isPaused){
                    try{
   
                       // menunggu sampai mendapat notif dari thread lain untuk continue
                        // memastikan isPaused boolean flag sudah terupdate ke false sebelum continue
                        synchronized(playSignal){
                            playSignal.wait();
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                while(!isPaused && !songFinished){
                    try{
                        // inkremen current time 
                        currentTimeInMilli++;

                        // menghitung jumlah frame
                        int calculatedFrame = (int) ((double) currentTimeInMilli * 2.08 * currentSong.getFrameRatePerMilliseconds());

                        // update tampilan slider
                        MPcon.setPlaybackSliderValue(calculatedFrame);

                        // mimic 1 millisecond using thread.sleep
                        Thread.sleep(1);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void playbackStarted(PlaybackEvent evt) {
        System.out.println("Playback Started");
        songFinished = false;
    }

    @Override
    public void playbackFinished(PlaybackEvent evt) {
        // this method gets called when the song finishes or if the player gets closed
        System.out.println("Playback Finished");
        if(isPaused){
            currentFrame += (int) ((double) evt.getFrame() * currentSong.getFrameRatePerMilliseconds());
        }
            //SEHARUSNYA FITUR REPEAT SONG
            // when the song ends
//            if (MPcon.isRepeatMode && currentFrame == Integer.MAX_VALUE){
//            currentFrame = 0;
//            // reset current time in minglli
//            currentTimeInMilli = 0;
//            // update gui
//            MPcon.setPlaybackSliderValue(0);
//
//            playCurrentSong();
//            }
            
            songFinished = true;
            MPcon.enablePlayButtonDisablePauseButton();
        
    }
    
    public songData getCurrentSong(){
        return currentSong;
    }
}