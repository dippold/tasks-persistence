package org.builderforce.tasks.persistence.entities;

import javax.persistence.Column;
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
    @NamedQuery(name = "Company.findby.name",
            query = "SELECT o FROM Company o WHERE o.name = :name")
})

public class Company extends AbstractEntity {
    
    @Column(nullable = false, columnDefinition = "BIGINT(20) default 1")
    private Long companyGroupId = 1L; 

    public Long getCompanyGroupId() {
        return companyGroupId;
    }

    public void setCompanyGroupId(Long companyGroupId) {
        this.companyGroupId = companyGroupId;
    }    
    
}
