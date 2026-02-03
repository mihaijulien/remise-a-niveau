package io.mihaijulien.tennis.controller;

import java.util.Scanner;

public class JoueurController {

    private JoueurService joueurService;

    public JoueurController(){
        this.joueurService = new JoueurService();
    }

    public void afficheDetailsJoueuer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("L'identifiant du joueur: ");
        long identifiant = scanner.nextLong();
        Joueur joueur = joueurService.getJoueur(identifiant);
        System.out.println("Le joueur s'apelle  "+ joueur.getNom());
    }
}
