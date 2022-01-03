package de.patrick260.memory.game;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    private final int WIDTH;
    private final int HEIGHT;

    private final Color BACKGROUND_COLOR;


    public Game(int width, int height, Color background_color) {

        setLayout(null);

        this.WIDTH = width;
        this.HEIGHT = height;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);

        this.BACKGROUND_COLOR = background_color;

        setBackground(BACKGROUND_COLOR);

    }

}
