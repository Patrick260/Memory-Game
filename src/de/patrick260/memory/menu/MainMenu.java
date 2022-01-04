/*
    Copyright (C) 2022  Patrick260

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

package de.patrick260.memory.menu;

import de.patrick260.memory.game.Game;
import de.patrick260.memory.gui.FixedStateButtonModel;

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
        play_button.setModel(new FixedStateButtonModel());
        play_button.setText("Play");
        play_button.setForeground(Color.black);

        play_button.addActionListener(event -> {

            setVisible(false);
            getParent().add(new Game(WIDTH, HEIGHT, BACKGROUND_COLOR));

        });

        add(play_button);

        JButton exit_button = new JButton();

        exit_button.setBounds((WIDTH - BUTTON_WIDTH) / 2, (HEIGHT - BUTTON_HEIGHT) / 2 + (BUTTON_HEIGHT + GAP_BETWEEN_BUTTONS) / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        exit_button.setBackground(BUTTON_COLOR);
        exit_button.setModel(new FixedStateButtonModel());
        exit_button.setText("Exit");
        exit_button.setForeground(Color.black);

        exit_button.addActionListener(event -> System.exit(0));

        add(exit_button);

    }

}
