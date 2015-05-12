package de.iHex.SoundKicker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class SoundKickerPlayer extends Thread{
    private AdvancedPlayer adPl;
    private FileInputStream inMp3;
    private String mp3Path;

   
    public SoundKickerPlayer(String mp3Path) {
        
        this.mp3Path = mp3Path;
        
        try {
            inMp3 = new FileInputStream(mp3Path);
            adPl = new AdvancedPlayer(inMp3);
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            adPl.play();
        } catch (JavaLayerException e1) {
            e1.printStackTrace();
        }
    }
    
    public void close(){
        adPl.close();
        this.interrupt();
    } 
}
