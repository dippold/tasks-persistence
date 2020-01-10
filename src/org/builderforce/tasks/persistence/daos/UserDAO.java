package org.builderforce.tasks.persistence.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.builderforce.tasks.persistence.entities.User;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-06
 * 
 */
public class UserDAO extends UserJpaController {
    
    public UserDAO(EntityManagerFactory emf) {
        super(emf);
    }

    public User find(Long id) {
        return super.findUser(id);
    }    
    
    public User findUser(String email, String passwd) throws NoResultException {
        EntityManager em = getEntityManager();
        try {
            return (User) em.createNamedQuery("User.authenticate")
                    .setParameter("email", email)
                    .setParameter("passwd", passwd)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public User findUser(String email) throws NoResultException {
        EntityManager em = getEntityManager();
        try {
            return (User) em.createNamedQuery("User.findby.email")
                    .setParameter("email", email)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public User findUserByName(String name) throws NoResultException {
        EntityManager em = getEntityManager();
        try {
            return (User) em.createNamedQuery("User.findby.name")
                    .setParameter("name", name)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }    
    
    public List<User> findAll() {
        return super.findUserEntities();
    }
    
    public List<User> findUserByKeyword(String keyword) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("User.findby.keyword");
            q.setParameter("keyword", "%" + keyword + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<User> findUserByRule(Long ruleId) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("User.findby.rule");
            q.setParameter("ruleId", ruleId);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<User> findAllUserOrderByName() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("User.findall.order.by.name");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
}
