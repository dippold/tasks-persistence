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
    @NamedQuery(name = "Log.find.all.desc",
            query = "SELECT o FROM Log o WHERE o.projectId = :projectId ORDER BY o.createdIn DESC"),
    @NamedQuery(name = "Log.find.all.by.project",
            query = "SELECT o FROM Log o WHERE o.projectId = :projectId ORDER BY o.createdIn DESC"),
        @NamedQuery(name = "Log.find.all.by.user",
            query = "SELECT o FROM Log o WHERE o.userId = :userId ORDER BY o.createdIn DESC")
})
public class Log extends AbstractEntity {

    private static final long serialVersionUID = -7220897685477631248L;
   
    @Column(nullable = false, columnDefinition = "BIGINT(20) default 0")
    private Long companyId = 0L;    

    @Column(nullable = false, columnDefinition = "BIGINT(20) default 0")
    private Long userId = 0L;

    @Column(nullable = false, columnDefinition = "BIGINT(20) default 0")
    private Long projectId = 0L;
    
    @Column(nullable = false, columnDefinition = "BIGINT(20) default 0")
    private Long entityId = 0L;

    @Column(unique = false, nullable = false, length = 15)
    private String userAction;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

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

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getUserAction() {
        return userAction;
    }

    public void setUserAction(String userAction) {
        this.userAction = userAction;
    }

    
    
}
