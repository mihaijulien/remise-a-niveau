package io.mihaijulien.tennis.core.respository;

import io.mihaijulien.tennis.core.HibernateUtil;
import io.mihaijulien.tennis.core.entity.Joueur;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class JoueurRepositoryImplwHibernate {

    public void create(Joueur joueur){

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(joueur);
            tx.commit();

            System.out.println("Joueuer créé");

        } catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void renom(Long id, String nouveauNom){
        Joueur joueur = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            joueur = session.get(Joueur.class, id);
            joueur.setNom(nouveauNom);

            tx.commit();

            System.out.println("Joueuer lu");

        } catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void delete(Long id){
        Joueur joueur = getById(id);
        Session session = null;

        session = HibernateUtil.getSessionFactory().openSession();

        session.remove(joueur);

        System.out.println("Joueuer suprimé");
    }

    public Joueur getById(Long id){
        Joueur joueur = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            joueur = session.get(Joueur.class, id);

            System.out.println("Joueuer lu");

        } catch (Throwable t){
            t.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
        }

        return joueur;
    }
}
