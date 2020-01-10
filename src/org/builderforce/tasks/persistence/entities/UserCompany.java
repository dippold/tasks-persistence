
package org.builderforce.tasks.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-06
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "UserCompany.authenticate",
            query = "SELECT o FROM UserCompany o WHERE o.userId = :userId AND o.companyId = :companyId"),
    @NamedQuery(name = "UserCompany.find.all.users.from.company",
            query = "SELECT o FROM UserCompany o WHERE o.companyId = :companyId"),
    @NamedQuery(name = "UserCompany.find.all.company.from.user",
            query = "SELECT o FROM UserCompany o WHERE o.userId = :userId")
})

public class UserCompany  extends AbstractEntity {

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long userId;  
    
    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long companyId;      

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    
    
}
