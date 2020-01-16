package org.builderforce.tasks.persistence.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.builderforce.tasks.persistence.entities.Task;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-16
 * 
 */
public class TaskDAO extends TaskJpaController {
    
    public TaskDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
    List<Task> findAll() {
        
        return super.findTaskEntities();
    }
    
    List<Task> findAllByProject(Long projectId) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Task.findall.by.project");
            q.setParameter("projectId", projectId);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
}
