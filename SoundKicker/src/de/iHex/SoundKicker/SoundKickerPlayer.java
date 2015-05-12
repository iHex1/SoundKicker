package de.iHex.SoundKicker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/*
 * SoundKickerPlayer.java
 *
 * Copyright (c) 2015 Michael Behrendt
 * All Rights Reserved.
 *
 * @version 0.0 - 07 May 2015 - Beh - inertial: abspielen, stoppen einer mp3-datei
 */

/**
* Klasse zum Abspielen und Stoppen einer mp3-Datei.
* Gestartet wird durch Erzeugen des Threads und Übergabe des Pfads der mp3-Datei.
* Gestoppt wird durch Schliessen des Players und interrupten des Threads.
* <br><code><b>[iHex]</b></code>
*
* @author   iHex
* @version  0.0 - 07. May 2015
*/
public class SoundKickerPlayer extends Thread {

    /** Der eigendliche Player. */
    private AdvancedPlayer adPl;

    /** FileStream zur mp3-Datei. */
    private FileInputStream inMp3;

    /**
     * Konstruktor des Players.
     * @param mp3Path der Pfad zur mp3-Datei
     */
    public SoundKickerPlayer(String mp3Path) {
        try {
            inMp3 = new FileInputStream(mp3Path);
            adPl = new AdvancedPlayer(inMp3);
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Die überschriebene Run-Methode eines Threads.
     * Hier wird nur "auf Play gedrückt".
     */
    @Override
    public void run() {
        try {
            adPl.play();
        } catch (JavaLayerException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * Beendet das Abspielen der mp3-Datei durch Schließen des Players
     * und durch Interruptanfrage des Threads.
     */
    public void close() {
        adPl.close();
        this.interrupt();
    }
}
