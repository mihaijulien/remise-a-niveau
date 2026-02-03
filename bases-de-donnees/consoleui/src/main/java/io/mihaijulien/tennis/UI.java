package io.mihaijulien.tennis;

import io.mihaijulien.tennis.controller.JoueurController;

public class UI {
    public static void main(String args[]){
        JoueurController controller = new JoueurController();
        controller.afficheDetailsJoueuer();
    }
}
