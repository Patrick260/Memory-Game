package de.patrick260.memory.gui;

import de.patrick260.memory.menu.MainMenu;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    private final Color BACKGROUND_COLOR = Color.orange;


    public GUI() {

        setTitle("Memory");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        add(new MainMenu(WIDTH, HEIGHT, BACKGROUND_COLOR));

        pack();

    }

}
