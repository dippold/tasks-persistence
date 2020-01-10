package org.builderforce.tasks.persistence.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import org.builderforce.tasks.persistence.entities.Rule;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-04
 * 
 */
public class RuleDAO extends RuleJpaController {
    
    public RuleDAO(EntityManagerFactory emf) {
        super(emf);
    }

    public Rule find(Long id) {
        return  super.findRule(id);
    }    
    
    public Rule findByName(String name) throws NoResultException {
        EntityManager em = getEntityManager();
        try {
            return (Rule) em.createNamedQuery("Rule.findby.name")
                    .setParameter("name", name)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }    
    
    public List<Rule> findAll() {
        return findRuleEntities();
    }
    
}
