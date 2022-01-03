package de.patrick260.memory.menu;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    private final int WIDTH;
    private final int HEIGHT;

    private final Color BACKGROUND_COLOR;

    private final int BUTTON_WIDTH = 150;
    private final int BUTTON_HEIGHT = 50;

    private final int GAP_BETWEEN_BUTTONS = 10;

    private final Color BUTTON_COLOR = Color.DARK_GRAY;


    public MainMenu(int width, int height, Color background_color) {

        setLayout(null);

        this.WIDTH = width;
        this.HEIGHT = height;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);

        this.BACKGROUND_COLOR = background_color;

        setBackground(BACKGROUND_COLOR);

        JButton play_button = new JButton();

        play_button.setBounds((WIDTH - BUTTON_WIDTH) / 2, (HEIGHT - BUTTON_HEIGHT) / 2 - (BUTTON_HEIGHT + GAP_BETWEEN_BUTTONS) / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        play_button.setBackground(BUTTON_COLOR);
        play_button.setText("Play");
        play_button.setForeground(Color.black);

        play_button.addActionListener(event -> System.out.println("Play"));

        add(play_button);

        JButton exit_button = new JButton();

        exit_button.setBounds((WIDTH - BUTTON_WIDTH) / 2, (HEIGHT - BUTTON_HEIGHT) / 2 + (BUTTON_HEIGHT + GAP_BETWEEN_BUTTONS) / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        exit_button.setBackground(BUTTON_COLOR);
        exit_button.setText("Exit");
        exit_button.setForeground(Color.black);

        exit_button.addActionListener(event -> System.exit(0));

        add(exit_button);

    }

}
