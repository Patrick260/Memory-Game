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

package de.patrick260.memory.gui;

import de.patrick260.memory.game.Game;
import de.patrick260.memory.menu.MainMenu;

import javax.swing.*;
import java.awt.*;

public final class WinScreen extends JPanel {

    private static final int WIDTH = GUI.WIDTH;
    private static final int HEIGHT = GUI.HEIGHT;

    private static final Color BACKGROUND_COLOR = GUI.BACKGROUND_COLOR;

    private static final String WIN_TEXT = "You won!";

    private static final int WIN_TEXT_WIDTH = 600;
    private static final int WIN_TEXT_HEIGHT = 100;

    private static final int WIN_TEXT_Y = 100;

    private static final String WIN_TEXT_FONT = null;
    private static final int WIN_TEXT_STYLE = Font.BOLD;
    private static final int WIN_TEXT_SIZE = 100;

    private static final Color WIN_TEXT_COLOR = Color.YELLOW;

    private static final int PLAY_TIME_TEXT_WIDTH = 300;
    private static final int PLAY_TIME_TEXT_HEIGHT = 50;

    private static final int PLAY_TIME_TEXT_Y = WIN_TEXT_Y + PLAY_TIME_TEXT_HEIGHT * 2;

    private static final String PLAY_TIME_TEXT_FONT = null;
    private static final int PLAY_TIME_TEXT_STYLE = Font.BOLD;
    private static final int PLAY_TIME_TEXT_SIZE = 25;

    private static final Color PLAY_TIME_TEXT_COLOR = Color.BLACK;

    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 75;

    private static final int GAP_BETWEEN_BUTTONS = 10;

    private static final String BUTTON_FONT = null;
    private static final int BUTTON_STYLE = Font.BOLD;
    private static final int BUTTON_TEXT_SIZE = 25;

    private static final Color BUTTON_TEXT_COLOR = Color.BLACK;

    private static final Color BUTTON_COLOR = Color.DARK_GRAY;


    public WinScreen(final String played_time) {

        setLayout(null);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(BACKGROUND_COLOR);

        final JTextField winText = new JTextField(WIN_TEXT);

        winText.setEditable(false);
        winText.setFocusable(false);
        winText.setForeground(WIN_TEXT_COLOR);
        winText.setBackground(BACKGROUND_COLOR);
        winText.setBorder(null);
        winText.setFont(new Font(WIN_TEXT_FONT, WIN_TEXT_STYLE, WIN_TEXT_SIZE));
        winText.setHorizontalAlignment(JTextField.CENTER);
        winText.setBounds((WIDTH - WIN_TEXT_WIDTH) / 2, WIN_TEXT_Y, WIN_TEXT_WIDTH, WIN_TEXT_HEIGHT);

        add(winText);

        final JTextField playTimeText = new JTextField(played_time);

        playTimeText.setEditable(false);
        playTimeText.setFocusable(false);
        playTimeText.setForeground(PLAY_TIME_TEXT_COLOR);
        playTimeText.setBackground(BACKGROUND_COLOR);
        playTimeText.setBorder(null);
        playTimeText.setFont(new Font(PLAY_TIME_TEXT_FONT, PLAY_TIME_TEXT_STYLE, PLAY_TIME_TEXT_SIZE));
        playTimeText.setHorizontalAlignment(JTextField.CENTER);
        playTimeText.setBounds((WIDTH - PLAY_TIME_TEXT_WIDTH) / 2, PLAY_TIME_TEXT_Y, PLAY_TIME_TEXT_WIDTH, PLAY_TIME_TEXT_HEIGHT);

        add(playTimeText);

        final JButton playAgainButton = new JButton();

        playAgainButton.setBounds((WIDTH - BUTTON_WIDTH) / 2, (HEIGHT - BUTTON_HEIGHT) / 2 - (BUTTON_HEIGHT + GAP_BETWEEN_BUTTONS) / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        playAgainButton.setBackground(BUTTON_COLOR);
        playAgainButton.setModel(new FixedStateButtonModel());
        playAgainButton.setText("Play again");
        playAgainButton.setFont(new Font(BUTTON_FONT, BUTTON_STYLE, BUTTON_TEXT_SIZE));
        playAgainButton.setForeground(BUTTON_TEXT_COLOR);
        playAgainButton.setFocusPainted(false);

        playAgainButton.addActionListener(event -> {

            getParent().add(new Game());

            setVisible(false);
            getParent().remove(this);

        });

        add(playAgainButton);

        final JButton menuButton = new JButton();

        menuButton.setBounds((WIDTH - BUTTON_WIDTH) / 2, (HEIGHT - BUTTON_HEIGHT) / 2 + (BUTTON_HEIGHT + GAP_BETWEEN_BUTTONS) / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        menuButton.setBackground(BUTTON_COLOR);
        menuButton.setModel(new FixedStateButtonModel());
        menuButton.setText("Menu");
        menuButton.setFont(new Font(BUTTON_FONT, BUTTON_STYLE, BUTTON_TEXT_SIZE));
        menuButton.setForeground(BUTTON_TEXT_COLOR);
        menuButton.setFocusPainted(false);

        menuButton.addActionListener(event -> {

            getParent().add(new MainMenu());

            setVisible(false);
            getParent().remove(this);

        });

        add(menuButton);

    }

}
