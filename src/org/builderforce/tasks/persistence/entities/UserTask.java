
package org.builderforce.tasks.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-9
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "UserTask.findall.by.task",
            query = "SELECT o FROM UserTask o WHERE o.taskId = :taskId"),
    @NamedQuery(name = "UserTask.findall.by.user",
            query = "SELECT o FROM UserTask o WHERE o.userId = :userId")
})

public class UserTask extends AbstractEntity {
    
    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long taskId;

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long userId;
    
    @Column(nullable = false, columnDefinition = "INT(1)")
    private int allocationPercentage = 50;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getAllocationPercentage() {
        return allocationPercentage;
    }

    public void setAllocationPercentage(int allocationPercentage) {
        this.allocationPercentage = allocationPercentage;
    }
    
    
}
