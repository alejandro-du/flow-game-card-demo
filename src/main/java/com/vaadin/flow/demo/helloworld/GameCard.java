package com.vaadin.flow.demo.helloworld;

import com.vaadin.flow.model.TemplateModel;
import com.vaadin.ui.Tag;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.polymertemplate.PolymerTemplate;

/**
 * @author Alejandro Duarte.
 */
@Tag("game-card")
@HtmlImport("bower_components/game-card/game-card.html")
public class GameCard extends PolymerTemplate<GameCard.Model> implements TemplateModel {

    public static final String[] SYMBOLS = {"♠", "♣", "♥", "♦"};
    public static final String[] RANKS = {"a", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};

    public interface Model extends TemplateModel {
        String getSymbol();

        void setSymbol(String symbol);

        String getRank();

        void setRank(String rank);

        void setFlippable(Boolean flippable);

        void setUnrevealed(Boolean unrevealed);
    }

    public String getSymbol() {
        return getModel().getSymbol();
    }

    public void setSymbol(String symbol) {
        getModel().setSymbol(symbol);
    }

    public String getRank() {
        return getModel().getRank();
    }

    public void setRank(String rank) {
        getModel().setRank(rank);
    }

    public void setFlippable(Boolean flippable) {
        getModel().setFlippable(flippable);
    }

    public void setUnrevealed(Boolean unrevealed) {
        getModel().setUnrevealed(unrevealed);
    }

}
