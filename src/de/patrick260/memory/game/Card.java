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

import de.patrick260.memory.gui.FixedStateButtonModel;

import javax.swing.*;
import java.awt.*;

public class Card extends JButton {

    private static final int WIDTH = Game.CARD_WIDTH;
    private static final int HEIGHT = Game.CARD_HEIGHT;

    private static final Color BACKGROUND_COLOR = Game.CARD_COLOR;

    private final int pairID;


    public Card(int id, int pairID) {

        this.pairID = pairID;

        setSize(new Dimension(WIDTH, HEIGHT));

        setBackground(BACKGROUND_COLOR);

        setModel(new FixedStateButtonModel());

        setBorderPainted(false);
        setFocusPainted(false);

        addActionListener(event -> {

            if (!Game.getGame().blockCardSelecting) {

                setText(id + "-" + pairID);

                Game.getGame().selectCard(id);

            }

        });

    }


    public int getPairID() {

        return pairID;

    }

}
