package com.ebkir.jpa;

import com.ebkir.datasource.UserDatabase;

import javax.persistence.*;
import java.util.List;

public class JPAImpl implements UserDatabase<JpaUser> {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("jpadatabase");

    public JPAImpl() {
    }

    @Override
    public void create(JpaUser jpaUser) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(jpaUser);
            em.getTransaction().commit();
        }
        catch(Exception e) {
            System.out.println("Something went wrong with creation");
        }
        finally {
            em.close();
        }
    }

    @Override
    public List<JpaUser> read() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT user FROM JpaUser user where user.id is not null";
        TypedQuery<JpaUser> tq = em.createQuery(query, JpaUser.class);
        List<JpaUser> lists = null;

        try {
            lists =  tq.getResultList();
        }
        catch (Exception e) {
            System.out.println("Something went wrong with reading");
        }
        finally {
            em.close();
        }
        return lists;
    }

    @Override
    public void update(int id, JpaUser userJpa) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        JpaUser jpaUser = em.find(JpaUser.class, id);
        em.getTransaction().begin();
        jpaUser.setFirstName("changedUsername");
        em.getTransaction().commit();
    }

    @Override
    public void remove(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        JpaUser jpaUser = em.find(JpaUser.class, id);
        em.getTransaction().begin();
        em.remove(jpaUser);
        em.getTransaction().commit();
    }
}
