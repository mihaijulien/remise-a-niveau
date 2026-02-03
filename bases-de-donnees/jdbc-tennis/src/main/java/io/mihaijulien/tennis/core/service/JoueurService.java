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

    public void getJoueur(Long id){
        joueurRepository.getById(id);
    }

    //  Un service transactionnel avec les DAO (Data Access Object)

    /*
    // !! Comment ne pas faire:

        public void createJoueur(Joueur joueur){

            DataSource dataSource =  DataSourceProvider.getSingleDataSourceInstance();
            Connection conn = dataSource.getConnection();
            conn.setAutoCommit(false);

            joueurRepository.create(joueur, conn);
            conn.commit();
        }

       Utilisant le DAO:

       private JoueurDaoImpl joueurDao;

       public JoueurService(){
            this.joueurDao = new JoueurDaoImpl();
        }

        public void createJoueur(Joueur joueur){
            joueurDao.ajouterJoueur(joueur);
        }

     */
}
