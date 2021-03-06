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

import de.patrick260.memory.gui.GUI;
import de.patrick260.memory.gui.WinScreen;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Scanner;

public final class Game extends JPanel {

    private static final int WIDTH = GUI.WIDTH;
    private static final int HEIGHT = GUI.HEIGHT;

    private static final Color BACKGROUND_COLOR = GUI.BACKGROUND_COLOR;

    static final int CARD_WIDTH = 100;
    static final int CARD_HEIGHT = 100;

    static final Color CARD_COLOR = Color.DARK_GRAY;

    private static final int CARD_AMOUNT = 36;

    private static final int CARD_AMOUNT_X = 6;
    private static final int CARD_AMOUNT_Y = 6;

    private static final int GAP_BETWEEN_CARDS = 10;

    private static final int CARD_BASE_X = (WIDTH - (CARD_WIDTH * CARD_AMOUNT_X + GAP_BETWEEN_CARDS * (CARD_AMOUNT_X - 1))) / 2;
    private static final int CARD_BASE_Y = (HEIGHT - (CARD_HEIGHT * CARD_AMOUNT_Y + GAP_BETWEEN_CARDS * (CARD_AMOUNT_Y - 1))) / 2;

    private static final int CARD_FLIP_DELAY = 1500;

    private static final int PLAY_TIME_TEXT_WIDTH = 80;
    private static final int PLAY_TIME_TEXT_HEIGHT = 50;
    
    private static final int PLAY_TIME_TEXT_X = WIDTH - PLAY_TIME_TEXT_WIDTH - 12;
    private static final int PLAY_TIME_TEXT_Y = 12;

    private static final String PLAY_TIME_TEXT_FONT = null;
    private static final int PLAY_TIME_TEXT_STYLE = Font.BOLD;
    private static final int PLAY_TIME_TEXT_SIZE = 25;

    private static final Color PLAY_TIME_TEXT_COLOR = Color.BLACK;

    private static Game game;

    private final Card[] cards = new Card[CARD_AMOUNT];

    private final String[] sets = {"alphabet"};

    private final ImageIcon[] icons = new ImageIcon[CARD_AMOUNT / 2];

    private int selectedCard = Integer.MIN_VALUE;

    private int pairsLeft = CARD_AMOUNT / 2;

    private final Timer playTimeTimer;

    private int playTime = 0;

    boolean blockCardSelecting;


    public Game() {

        game = this;

        setLayout(null);
        setBackground(BACKGROUND_COLOR);

        final JTextField playTimeText = buildPlayTimeText();

        add(playTimeText);

        playTimeText.setText(new SimpleDateFormat("mm:ss").format(playTime));

        playTimeTimer = new Timer(1000, event -> {

            playTime+=1000;

            playTimeText.setText(new SimpleDateFormat("mm:ss").format(playTime));

        });

        playTimeTimer.start();

        loadIcons();
        initCards();

        mixCards();

    }


    private JTextField buildPlayTimeText() {

        final JTextField playTimeText = new JTextField();

        playTimeText.setEditable(false);
        playTimeText.setFocusable(false);
        playTimeText.setForeground(PLAY_TIME_TEXT_COLOR);
        playTimeText.setBackground(BACKGROUND_COLOR);
        playTimeText.setBorder(null);
        playTimeText.setFont(new Font(PLAY_TIME_TEXT_FONT, PLAY_TIME_TEXT_STYLE, PLAY_TIME_TEXT_SIZE));
        playTimeText.setHorizontalAlignment(JTextField.CENTER);
        playTimeText.setBounds(PLAY_TIME_TEXT_X, PLAY_TIME_TEXT_Y, PLAY_TIME_TEXT_WIDTH, PLAY_TIME_TEXT_HEIGHT);

        return playTimeText;

    }


    private void initCards() {

        for (int i = 0; i < cards.length; i++) {

            if (i % 2 == 0) {

                cards[i] = new Card(i, i + 1, icons[i / 2]);

            } else {

                cards[i] = new Card(i, i - 1, icons[i / 2]);

            }

            add(cards[i]);

        }

    }

    private void loadIcons() {

        final int random = (int) (Math.random() * sets.length);

        final Scanner scanner = new Scanner(getClass().getResourceAsStream("/Sets/" + sets[random] + "/set.txt"));

        int i = 0;
        while (scanner.hasNext()) {

            icons[i] = new ImageIcon(getClass().getResource("/Sets/" + sets[random] + "/" + scanner.nextLine()));

            i++;

        }

    }

    private void mixCards() {

        final HashSet<Integer> alreadyAddedIDs = new HashSet<>();

        for (int i = 0; i < CARD_AMOUNT_X; i++) {

            for (int j = 0; j < CARD_AMOUNT_Y; j++) {

                final int random = (int) (Math.random() * CARD_AMOUNT);

                if (!alreadyAddedIDs.contains(random)) {

                    cards[random].setLocation(CARD_BASE_X + ((CARD_WIDTH + GAP_BETWEEN_CARDS) * i), CARD_BASE_Y + ((CARD_HEIGHT + GAP_BETWEEN_CARDS) * j));

                    alreadyAddedIDs.add(random);

                } else {

                    j--;

                }

            }

        }

    }

    public void selectCard(final int id) {

        if (selectedCard != Integer.MIN_VALUE && selectedCard != id) {

            blockCardSelecting = true;

            final Timer timer = new Timer(CARD_FLIP_DELAY, event -> {

                if (selectedCard == cards[id].getPairId()) {

                    cards[selectedCard].setVisible(false);
                    cards[id].setVisible(false);

                    remove(cards[selectedCard]);
                    remove(cards[id]);

                    pairsLeft--;

                    if (pairsLeft == 0) {

                        playTimeTimer.stop();

                        getParent().add(new WinScreen("Your playtime: " + new SimpleDateFormat("mm:ss").format(playTime)));

                        setVisible(false);
                        getParent().remove(this);

                    }

                } else {

                    cards[selectedCard].setIcon(null);
                    cards[id].setIcon(null);

                }

                selectedCard = Integer.MIN_VALUE;

                blockCardSelecting = false;

            });

            timer.setRepeats(false);
            timer.start();

        } else {

            selectedCard = id;

        }

    }


    public static Game getGame() {

        return game;

    }

}
