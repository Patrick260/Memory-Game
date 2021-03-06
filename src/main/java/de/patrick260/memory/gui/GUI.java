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

public final class GUI extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public static final String TITLE = "Memory";

    public static final Color BACKGROUND_COLOR = new Color(129, 129, 129);


    public GUI() {

        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        add(new MainMenu());

        pack();

        setLocationRelativeTo(null);

    }

}
