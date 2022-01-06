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

public class WinScreen extends JPanel {

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


    public WinScreen(String played_time) {

        setLayout(null);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(BACKGROUND_COLOR);

        JTextField win_text = new JTextField(WIN_TEXT);

        win_text.setEditable(false);
        win_text.setFocusable(false);
        win_text.setForeground(WIN_TEXT_COLOR);
        win_text.setBackground(BACKGROUND_COLOR);
        win_text.setBorder(null);
        win_text.setFont(new Font(WIN_TEXT_FONT, WIN_TEXT_STYLE, WIN_TEXT_SIZE));
        win_text.setHorizontalAlignment(JTextField.CENTER);
        win_text.setBounds((WIDTH - WIN_TEXT_WIDTH) / 2, WIN_TEXT_Y, WIN_TEXT_WIDTH, WIN_TEXT_HEIGHT);

        add(win_text);

        JTextField play_time_text = new JTextField(played_time);

        play_time_text.setEditable(false);
        play_time_text.setFocusable(false);
        play_time_text.setForeground(PLAY_TIME_TEXT_COLOR);
        play_time_text.setBackground(BACKGROUND_COLOR);
        play_time_text.setBorder(null);
        play_time_text.setFont(new Font(PLAY_TIME_TEXT_FONT, PLAY_TIME_TEXT_STYLE, PLAY_TIME_TEXT_SIZE));
        play_time_text.setHorizontalAlignment(JTextField.CENTER);
        play_time_text.setBounds((WIDTH - PLAY_TIME_TEXT_WIDTH) / 2, PLAY_TIME_TEXT_Y, PLAY_TIME_TEXT_WIDTH, PLAY_TIME_TEXT_HEIGHT);

        add(play_time_text);

        JButton play_again_button = new JButton();

        play_again_button.setBounds((WIDTH - BUTTON_WIDTH) / 2, (HEIGHT - BUTTON_HEIGHT) / 2 - (BUTTON_HEIGHT + GAP_BETWEEN_BUTTONS) / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        play_again_button.setBackground(BUTTON_COLOR);
        play_again_button.setModel(new FixedStateButtonModel());
        play_again_button.setText("Play again");
        play_again_button.setFont(new Font(BUTTON_FONT, BUTTON_STYLE, BUTTON_TEXT_SIZE));
        play_again_button.setForeground(BUTTON_TEXT_COLOR);
        play_again_button.setFocusPainted(false);

        play_again_button.addActionListener(event -> {

            getParent().add(new Game());

            setVisible(false);
            getParent().remove(this);

        });

        add(play_again_button);

        JButton menu_button = new JButton();

        menu_button.setBounds((WIDTH - BUTTON_WIDTH) / 2, (HEIGHT - BUTTON_HEIGHT) / 2 + (BUTTON_HEIGHT + GAP_BETWEEN_BUTTONS) / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        menu_button.setBackground(BUTTON_COLOR);
        menu_button.setModel(new FixedStateButtonModel());
        menu_button.setText("Menu");
        menu_button.setFont(new Font(BUTTON_FONT, BUTTON_STYLE, BUTTON_TEXT_SIZE));
        menu_button.setForeground(BUTTON_TEXT_COLOR);
        menu_button.setFocusPainted(false);

        menu_button.addActionListener(event -> {

            getParent().add(new MainMenu());

            setVisible(false);
            getParent().remove(this);

        });

        add(menu_button);

    }

}
