
package org.builderforce.tasks.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-05
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "CompanyGroup.findby.name",
            query = "SELECT o FROM CompanyGroup o WHERE o.name = :name")
})

public class CompanyGroup extends AbstractEntity {
    
}
