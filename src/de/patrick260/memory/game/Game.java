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

package de.patrick260.memory.game;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class Game extends JPanel {

    private final int WIDTH;
    private final int HEIGHT;

    private final int CARD_WIDTH = 100;
    private final int CARD_HEIGHT = 100;

    private final int CARD_BASE_X = 10;
    private final int CARD_BASE_Y = 10;
    private final int GAP_BETWEEN_CARDS = 10;

    private final Color CARD_COLOR = Color.GRAY;

    private final int CARD_AMOUNT = 16;

    private Card[] cards = new Card[CARD_AMOUNT];

    private Card[][] game_field = new Card[4][4];


    public Game(int width, int height, Color background_color) {

        setLayout(null);

        this.WIDTH = width;
        this.HEIGHT = height;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);

        setBackground(background_color);

        for (int i = 0; i < cards.length; i++) {

            if (i % 2 == 0) {

                cards[i] = new Card(CARD_WIDTH, CARD_HEIGHT, CARD_COLOR, i, i + 1);

            } else {

                cards[i] = new Card(CARD_WIDTH, CARD_HEIGHT, CARD_COLOR, i, i - 1);

            }

            add(cards[i]);

        }

        mixCards();

    }

    public void mixCards() {

        HashSet<Integer> alreadyAddedIDs = new HashSet<>();

        for (int i = 0; i < game_field.length; i++) {

            for (int j = 0; j < game_field[i].length; j++) {

                int random = (int) (Math.random() * CARD_AMOUNT);

                if (!alreadyAddedIDs.contains(random)) {

                    game_field[i][j] = cards[random];
                    cards[random].setLocation(CARD_BASE_X + ((CARD_WIDTH + GAP_BETWEEN_CARDS) * i), CARD_BASE_Y + ((CARD_HEIGHT + GAP_BETWEEN_CARDS) * j));
                    alreadyAddedIDs.add(random);

                } else {

                    j--;

                }

            }

        }

    }

}
