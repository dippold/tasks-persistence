package org.builderforce.tasks.persistence.entities;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-9
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Task.findall.by.project",
            query = "SELECT o FROM Task o WHERE o.projectId = :projectId ORDER BY o.sequenceId")
})

public class Task extends AbstractEntity {

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long projectId = 1L; 
    
    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long projectManagerId = 1L;

    @Column(nullable = false, columnDefinition = "INT(1)")
    private Long sequenceId = 99L;    

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, columnDefinition = "DATE")    
    private java.util.Date plannedStart;

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, columnDefinition = "DATE")    
    private java.util.Date plannedCompletion;

    @Column(nullable = false, columnDefinition = "INT(1)")
    private int completenessPercentage = 0;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(Long projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public Long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
    }

    public Date getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(Date plannedStart) {
        this.plannedStart = plannedStart;
    }

    public Date getPlannedCompletion() {
        return plannedCompletion;
    }

    public void setPlannedCompletion(Date plannedCompletion) {
        this.plannedCompletion = plannedCompletion;
    }

    public int getCompletenessPercentage() {
        return completenessPercentage;
    }

    public void setCompletenessPercentage(int completenessPercentage) {
        this.completenessPercentage = completenessPercentage;
    }

    
    
    
}
