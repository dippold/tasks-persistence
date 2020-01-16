package org.builderforce.tasks.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-16
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Project.findall.by.company",
            query = "SELECT o FROM Project o WHERE o.companyId = :companyId ORDER BY o.name")
})
public class Project extends AbstractEntity {

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long companyId = 1L;
    
    @Column(unique = true, nullable = false, length = 6)
    private String initials;    

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }    
    
}
