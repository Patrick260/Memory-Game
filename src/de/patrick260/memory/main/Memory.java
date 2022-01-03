package de.patrick260.memory.main;

import de.patrick260.memory.gui.GUI;

import java.awt.*;

public class Memory {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> new GUI().setVisible(true));

    }

}
