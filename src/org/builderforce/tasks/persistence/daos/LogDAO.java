package org.builderforce.tasks.persistence.daos;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.builderforce.tasks.persistence.entities.Log;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-05
 * 
 */
public class LogDAO extends LogJpaController {
    
    public LogDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
    public List<Log> findAll() {
        return findLogEntities();
    }    
    
}
