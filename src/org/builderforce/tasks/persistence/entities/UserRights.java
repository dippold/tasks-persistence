package org.builderforce.tasks.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-06
 * 
 */
@Entity
public class UserRights extends AbstractEntity {

    private static final long serialVersionUID = -8171888937428654607L;

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long userId;     

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long companyId;

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long projectId;

    @Column(unique = false, nullable = false, length = 50)
    private String userRight;

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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getUserRight() {
        return userRight;
    }

    public void setUserRight(String rule) {
        this.userRight = rule;
    }    
    
}
