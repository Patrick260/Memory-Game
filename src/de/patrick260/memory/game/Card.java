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

    private final int WIDTH;
    private final int HEIGHT;

    private final Color COLOR;

    private int x;
    private int y;


    public Card(int x, int y, int width, int height, Color color) {

        this.WIDTH = width;
        this.HEIGHT = height;

        this.x = x;
        this.y = y;

        setBounds(x, y, width, height);

        this.COLOR = color;

        setBackground(COLOR);

        setModel(new FixedStateButtonModel());

    }

}
