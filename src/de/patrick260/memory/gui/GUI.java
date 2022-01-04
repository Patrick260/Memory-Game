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
