package de.patrick260.memory.menu;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    private final int WIDTH;
    private final int HEIGHT;

    private final Color BACKGROUND_COLOR;


    public MainMenu(int width, int height, Color background_color) {

        this.WIDTH = width;
        this.HEIGHT = height;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);

        this.BACKGROUND_COLOR = background_color;

        setBackground(BACKGROUND_COLOR);

    }

}
