package org.builderforce.tasks.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-04
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Rule.findby.name",
            query = "SELECT o FROM Rule o WHERE o.name = :name")
})

public class Rule extends AbstractEntity {
    
    private static final long serialVersionUID = 982737860034138359L;
    
}
