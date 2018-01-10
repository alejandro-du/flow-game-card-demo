/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.demo.helloworld;

import com.vaadin.router.Route;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.html.Label;
import com.vaadin.ui.layout.HorizontalLayout;
import com.vaadin.ui.layout.VerticalLayout;

import java.util.Random;

/**
 * The main view contains a button and a template element.
 */
@HtmlImport("styles.html")
@Route("")
public class MainView extends VerticalLayout {

    private Label label = new Label("Pick two cards:");
    private GameCard card1;
    private boolean gameOver = false;

    public MainView() {
        label.setClassName("title");
        add(label);
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < 2; i++) {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            add(horizontalLayout);

            for (int j = 0; j < 5; j++) {
                GameCard card = new GameCard();
                card.setSymbol(GameCard.SYMBOLS[random.nextInt(GameCard.SYMBOLS.length)]);
                card.setRank(GameCard.RANKS[random.nextInt(GameCard.RANKS.length)]);
                card.setFlippable(true);
                card.setUnrevealed(true);

                card.getElement().addEventListener("click", e -> cardClicked(card));
                horizontalLayout.add(card);
            }
        }
    }

    private void cardClicked(GameCard card) {
        card.setFlippable(false);

        if (card1 == null || card1.equals(card)) {
            card1 = card;
        } else if (!gameOver) {
            if (card1.getSymbol().equals(card.getSymbol())) {
                label.setText("You win!!!");
            } else {
                label.setText("Refresh the browser and try again!");
            }
            gameOver = true;
        }
    }

}
