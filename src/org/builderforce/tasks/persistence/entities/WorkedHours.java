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
    @NamedQuery(name = "WorkedHours.findall.by.user",
            query = "SELECT o FROM WorkedHours o WHERE o.userId = :userId ORDER BY o.workedHoursDate DESC")
})

public class WorkedHours extends AbstractEntity {

    private static final long serialVersionUID = 654826100623562255L;

    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long taskId;     
    
    @Column(nullable = false, columnDefinition = "BIGINT(20)")
    private Long userId;  

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, columnDefinition = "DATE ")    
    private java.util.Date workedHoursDate;
    
    @Column(nullable = false, columnDefinition = "BIGINT(10)")
    private int workedHours;

    @Column(nullable = false, columnDefinition = "INT(1)")
    private int completenessPercentage = 0;    
    
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

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public Date getWorkedHoursDate() {
        return workedHoursDate;
    }

    public void setWorkedHoursDate(Date workedHoursDate) {
        this.workedHoursDate = workedHoursDate;
    }

    public int getCompletenessPercentage() {
        return completenessPercentage;
    }

    public void setCompletenessPercentage(int completenessPercentage) {
        this.completenessPercentage = completenessPercentage;
    }
    
}
