package de.iHex.SoundKicker;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

public class SoundKickerView extends JFrame {
    private static final long serialVersionUID = 100;
    private JPanel contentPane;
    private SoundKickerMain controller = new SoundKickerMain();
    
    private JPanel panelWest;
    private JPanel panelEast;

    /**
     * Create the frame.
     */
    public SoundKickerView() {
        setTitle("SoundKicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 441, 411);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panelNorth = new JPanel();
        contentPane.add(panelNorth, BorderLayout.NORTH);
        
        JLabel lblSoundkicker = new JLabel("SoundKicker");
        panelNorth.add(lblSoundkicker);
        lblSoundkicker.setFont(new Font("Tahoma", Font.PLAIN, 38));
        
        panelWest = new JPanel();
        panelWest.setBackground(Color.GREEN);
        contentPane.add(panelWest, BorderLayout.WEST);
        
        JLabel lblLeftKick = new JLabel("L");
        lblLeftKick.setFont(new Font("Tahoma", Font.PLAIN, 200));
//        lblLeftKick.setOpaque(true);
        lblLeftKick.setBackground(Color.GREEN);
        panelWest.add(lblLeftKick);
        
        panelEast = new JPanel();
        panelEast.setBackground(Color.GREEN);
        contentPane.add(panelEast, BorderLayout.EAST);
        
        JLabel lblRightKick = new JLabel("R");
        lblRightKick.setFont(new Font("Tahoma", Font.PLAIN, 200));
        panelEast.add(lblRightKick);
        
        JPanel panelCenter = new JPanel();
        contentPane.add(panelCenter, BorderLayout.CENTER);
        this.addKeyListener(controller);
        
        this.setResizable(false);
        
        this.setVisible(true);
    }

    /**
     * @return the panelWest
     */
    public JPanel getPanelWest() {
        return panelWest;
    }

    /**
     * @return the panelEast
     */
    public JPanel getPanelEast() {
        return panelEast;
    }
    
    
}
