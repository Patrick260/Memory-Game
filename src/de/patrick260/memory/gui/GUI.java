package de.patrick260.memory.gui;

import de.patrick260.memory.menu.MainMenu;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public final int WIDTH = 500;
    public final int HEIGHT = 500;


    public GUI() {

        setTitle("Memory");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        add(new MainMenu(WIDTH, HEIGHT, Color.DARK_GRAY));

        pack();

    }

}
