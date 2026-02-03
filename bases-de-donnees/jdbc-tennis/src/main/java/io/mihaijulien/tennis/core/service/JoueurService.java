package io.mihaijulien.tennis.core.service;

import io.mihaijulien.tennis.core.entity.Joueur;
import io.mihaijulien.tennis.core.respository.JoueurRepositoryImpl;

public class JoueurService {

    private JoueurRepositoryImpl joueurRepository;

    public JoueurService(){
        this.joueurRepository = new JoueurRepositoryImpl();
    }

    public void createJoueur(Joueur joueur){
        joueurRepository.create(joueur);
    }
}
