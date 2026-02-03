package io.mihaijulien.tennis.core.dao;

import io.mihaijulien.tennis.core.entity.Joueur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JoueurDaoImpl {

    private DataSource dataSource;

    public JoueurDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Méthode pour ajouter un joueur avec transaction
    public void ajouterJoueur(Joueur joueur) throws SQLException {
        String sql = "INSERT INTO joueurs (nom, prenom, sexe) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false); // Démarre la transaction
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, joueur.getNom());
                statement.setString(2, joueur.getPrenom());
                statement.setObject(3, joueur.getSexe());
                statement.executeUpdate();
                connection.commit(); // Valide la transaction
            } catch (SQLException e) {
                connection.rollback(); // Annule la transaction en cas d'erreur
                throw e;
            }
        }
    }

    // Méthode pour obtenir un joueur par son ID
    public Joueur obtenirJoueurParId(long id) throws SQLException {
        String sql = "SELECT * FROM joueurs WHERE id = ?";
        Joueur joueur = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                joueur = new Joueur();
                joueur.setId(rs.getLong("id"));
                joueur.setNom(rs.getString("nom"));
                joueur.setPrenom(rs.getString("prenom"));
                joueur.setSexe(rs.getObject("sexe", Character.class));
            }
        }
        return joueur;
    }

    // Méthode pour lister tous les joueurs
    public List<Joueur> listerJoueurs() throws SQLException {
        List<Joueur> joueurs = new ArrayList<>();
        String sql = "SELECT * FROM joueurs";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Joueur joueur = new Joueur();
                joueur.setId(rs.getLong("id"));
                joueur.setNom(rs.getString("nom"));
                joueur.setPrenom(rs.getString("prenom"));
                joueur.setSexe(rs.getObject("sexe", Character.class));
                joueurs.add(joueur);
            }
        }
        return joueurs;
    }

    // Méthode pour mettre à jour un joueur avec transaction
    public void mettreAJourJoueur(Joueur joueur) throws SQLException {
        String sql = "UPDATE joueurs SET nom = ?, prenom = ?, sexe = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false); // Démarre la transaction
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, joueur.getNom());
                statement.setString(2, joueur.getPrenom());
                statement.setObject(3, joueur.getSexe());
                statement.setLong(4, joueur.getId());
                statement.executeUpdate();
                connection.commit(); // Valide la transaction
            } catch (SQLException e) {
                connection.rollback(); // Annule la transaction en cas d'erreur
                throw e;
            }
        }
    }

    // Méthode pour supprimer un joueur par son ID avec transaction
    public void supprimerJoueur(long id) throws SQLException {
        String sql = "DELETE FROM joueurs WHERE id = ?";

        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false); // Démarre la transaction
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                statement.executeUpdate();
                connection.commit(); // Valide la transaction
            } catch (SQLException e) {
                connection.rollback(); // Annule la transaction en cas d'erreur
                throw e;
            }
        }
    }
}

