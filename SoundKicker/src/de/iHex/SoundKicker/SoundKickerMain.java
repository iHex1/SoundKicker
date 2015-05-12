package de.iHex.SoundKicker;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SoundKickerMain implements KeyListener{
    
    private static SoundKickerView view;
    
    private int right = KeyEvent.VK_R;
    private int rightCounter = 0;
    private SoundKickerPlayer rightPlayer;
    private String rightSong = "rightSong.mp3";
    
    private int left = KeyEvent.VK_L;
    private int leftCounter = 0;
    private SoundKickerPlayer leftPlayer;
    private String leftSong = "leftSong.mp3";

    public static void main(String[] args) {
        view = new SoundKickerView();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("keyTyped-Event");
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("Key-Code-Press: " + e.getKeyCode());
        
        if (e.getKeyCode() == left && leftCounter == 0) {
            leftCounter = 1;
            view.getPanelWest().setBackground(Color.RED);
            leftPlayer = new SoundKickerPlayer(leftSong);
            leftPlayer.start();
        } else if (e.getKeyCode() == right && rightCounter == 0) {
            rightCounter = 1;
            view.getPanelEast().setBackground(Color.RED);
            rightPlayer = new SoundKickerPlayer(rightSong);
            rightPlayer.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("Key-Code-Release: " + e.getKeyCode());
        
        if (e.getKeyCode() == left && leftCounter != 0) {
            leftCounter = 0;
            view.getPanelWest().setBackground(Color.GREEN);
            leftPlayer.close();
        } else if (e.getKeyCode() == right && rightCounter != 0) {
            rightCounter = 0;
            view.getPanelEast().setBackground(Color.GREEN);
            rightPlayer.close();
        }
    }
}
