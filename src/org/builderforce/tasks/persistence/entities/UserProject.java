
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
    @NamedQuery(name = "UserProject.find.by.user.and.by.project",
            query = "SELECT o FROM UserProject o WHERE o.userId = :userId AND o.projectId = :projectId"),
    @NamedQuery(name = "UserProject.find.all.users.by.project",
            query = "SELECT o FROM UserProject o WHERE o.projectId = :projectId"),
    @NamedQuery(name = "UserProject.find.all.projects.by.user",
            query = "SELECT o FROM UserProject o WHERE o.userId = :userId")
})

public class UserProject  extends AbstractEntity {

    private static final long serialVersionUID = 3731693908133364150L;

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long userId;  
    
    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long projectId;
    
    @Column(nullable = false, columnDefinition = "default 1")
    private int ruleId = 1;    

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }    

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }
    
}
