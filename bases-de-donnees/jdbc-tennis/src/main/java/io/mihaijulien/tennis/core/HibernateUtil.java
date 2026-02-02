package io.mihaijulien.tennis.core;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
Nous avons un fichier de configuration Hibernate, CFG, PW, XML et nous avons à noter une première entité la classe joueur.
Pour commencer à travailler avec Aï Beney, il va falloir obtenir un objet de type SessionFactory que l'on pourrait
traduire en français par usine à session.
Si vous voulez, dans une application, on a besoin que d'un seul objet de ce type. Et comme en plus cela prend un peu de
temps pour l'obtenir.
En général, quand on a cet objet, on le conserve si bien que souvent vous verrez que les développeurs
créent une classe dédiée pour conserver cette information et cette classe s'appelle en général HibernateUtils.
Alors cette classe n'est pas fournie dans l'API Hibernate.
 */

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }
}
