package de.iHex.SoundKicker;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * SoundKickerPlayer.java
 *
 * Copyright (c) 2015 Michael Behrendt
 * All Rights Reserved.
 *
 * @version 0.0 - 07 May 2015 - Beh - inertial: Controller und Key-Listener des SoundKickers
 */

/**
 * Controller und Key-Listener des SoundKickers. Tasten(Pedal)-Klicks werden
 * registriert und entsprechend mp3-Player gestartet oder gestoppt. Hinzu kommt
 * eine Visualisierung in der View. <br>
 * <code><b>[iHex]</b></code>
 *
 * @author iHex
 * @version 0.0 - 07. May 2015
 */
public class SoundKickerMain implements KeyListener {

    /** Grafik-Fenster zur Darstellung der "Pedale" und ihren Status. */
    private static SoundKickerView view;

    /** Der Key-Code des rechten Pedals. */
    private int right = KeyEvent.VK_R;

    /** Der Key-Code des linken Pedals. */
    private int left = KeyEvent.VK_L;

    /** Indikator, ob rechte Pedale schon gedrückt ist.*/
    private int rightCounter;

    /** Indikator, ob linke Pedale schon gedrückt ist.*/
    private int leftCounter;


    /** Player des rechten Songs. */
    private SoundKickerPlayer rightPlayer;

    /** Player des linken Songs. */
    private SoundKickerPlayer leftPlayer;

    /** Pfad des "rechten" Songs. */
    private String rightSong = "rightSong.mp3";

    /** Pfad des "linken" Songs. */
    private String leftSong = "leftSong.mp3";

    /**
     * Main-Methode des SoundKickers.
     * Es wird nur das Visualisierungsfenster geöffnet.
     * @param args not used in this project
     */
    public static void main(String[] args) {
        view = new SoundKickerView();
    }

    /**
     * Ereignis-Methode, die beim KeyTyped-Event (wenn ein gültiges Unicode-Zeichen getippt wurde)
     * ausgeführt wird.
     * */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Ereignis-Methode, die beim Pressed-Event (wenn eine Taste gedrückt wurde)
     * ausgeführt wird.
     * */
    @Override
    public void keyPressed(KeyEvent e) {

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

    /**
     * Ereignis-Methode, die beim Released-Event (wenn eine Taste losgelassen wurde)
     * ausgeführt wird.
     * */
    @Override
    public void keyReleased(KeyEvent e) {

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
