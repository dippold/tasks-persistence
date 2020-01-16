package org.builderforce.tasks.persistence.daos;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.builderforce.tasks.persistence.entities.Project;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-16
 * 
 */
public class ProjectDAO extends ProjectJpaController {
    
    public ProjectDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
    List<Project> findAll() {
        
        return super.findProjectEntities();
    }
    
}
