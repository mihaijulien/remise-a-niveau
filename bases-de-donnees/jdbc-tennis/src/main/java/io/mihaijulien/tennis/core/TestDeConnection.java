package io.mihaijulien.tennis.core;

import java.sql.*;

public class TestDeConnection {
    public static void main(String[] args){
        Connection conn = null;

        try {
            //Seulement avant Java 7/JDBC 4
            //Class.forName(DRIVER_CLASS_NAME);

            //MySQL driver MySQL Connector
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","root","root");
            //Oracle Driver officiel OJDBC Thin
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:tennis","COURSDB","COURSDB");
            //Postgres Driver officiel
            //conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tennis","COURSDB","COURSDB");
            System.out.println("success");

            conn.setAutoCommit(false);


            /*
            On va maintenant tenter de lire des données au travers de la connexion que l'on vient d'ouvrir.
            Cela va se faire dans le bloc TRY juste après que la connexion ait été établie.
            Il va falloir transmettre une requête SQL au serveur.
            Et ça, ça se fait deux bases avec Java en deux étapes.
            Étape numéro un:
             - La création d'un objet de type statement à partir de la connexion.
             conn.createStatement();
             */
            Statement statement = conn.createStatement();
            /*
            Et à partir de cet objet statement, nous allons pouvoir invoquer une requête (une query en anglais) grâce
            à la méthode executeQuery().
             */
            ResultSet resultSet = statement.executeQuery("SELECT ID, NOM, PRENOM FROM TENNIS.JOUEUR WHERE ID=12");

            if (resultSet.next()){
                final int id = resultSet.getInt("id");
                final String nom = resultSet.getString("nom");
                final String prenom = resultSet.getString("prenom");
                System.out.println("Le joueur / la jouesse représenté(e) par le numéro " +id+ " est "+prenom+" " +nom);
            } else {
                System.out.println("Il n'y a pas d'enregistrement d'ID 12.");
            }

            /*
            Très souvent, on ne connaît pas à l'avance exactement la requête à effectuer.
            Le code actuel est un exemple parmi d'autres.
            On voudra sans doute plutôt lire un enregistrement dont l'identifiant est fourni par une
            interface utilisateur plutôt qu'un identifiant en dur.
            Et à ce moment là, cet identifiant sera fourni à un moment donné au travers d'une variable.
             */

            long identifiant = 43L;

            Statement statement2 = conn.createStatement();

            // Mais ceci est plutôt déconseillé pour plusieurs raisons, notamment parce que cela ouvre la porte à
            // ce que l'on appelle l'injection SQL.
            ResultSet resultSet2 = statement2.executeQuery("SELECT ID, NOM, PRENOM FROM TENNIS.JOUEUR WHERE ID=" +identifiant);

            // On va procéder différemment en utilisant un PreparedStatement plutôt qu'un Statement.

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT ID, NOM, PRENOM FROM TENNIS.JOUEUR WHERE ID=?");
            preparedStatement.setLong(1, identifiant);

            ResultSet resultSet3 = preparedStatement.executeQuery();

            if (resultSet3.next()){
                final int id = resultSet3.getInt("id");
                final String nom = resultSet3.getString("nom");
                final String prenom = resultSet3.getString("prenom");
                System.out.println("Le joueur / la jouesse représenté(e) par le numéro " +id+ " est "+prenom+" " +nom);
            } else {
                System.out.println("Il n'y a pas d'enregistrement d'ID 78.");
            }

            /*
            Alors pourquoi faut il passer la requête immédiatement ici lors de la préparation du statement?
            Eh bien, parce que le PreparedStatement a l'avantage de pré compiler la requête.
            Concrètement, cela veut dire qu'au moment ou vous créez le PreparedStatement, la requête va être
            envoyée telle quelle, sans les valeurs correspondantes au point d'interrogation.
            Et le moteur de base de données va préparer cette requête et la mettre tout simplement en attente de
            réception des paramètres et de l'ordre d'exécution de cette requête.
            Ce fonctionnement est plus performant que celui du statement, surtout lorsque l'on veut exécuter plusieurs
            fois la même requête successivement avec des valeurs différentes.
             */

            // UPDATE

            PreparedStatement preparedStatement2 = conn.prepareStatement("UPDATE TENNIS.JOUEUR NOM=?, PRENOM=? WHERE ID=?");
            preparedStatement2.setString(1, "Anderson");
            preparedStatement2.setString(2, "Kevin_modifier");
            preparedStatement2.setLong(3, 77L);

            int nbEnregistrementModifier = preparedStatement2.executeUpdate();

            resultSet.close();
            resultSet2.close();
            resultSet3.close();
            statement.close();
            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
            try{
                if(conn != null){
                    conn.rollback();
                }
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
