package org.builderforce.tasks.persistence.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-04
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "ENTITY_GEN", sequenceName = "ENTITY_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = false, nullable = false, length = 100)
    private String name;

    @Column(unique = false, nullable = true, length = 255)
    private String description;    
    
    @Column(columnDefinition = "TINYINT(1) NOT NULL DEFAULT false")
    private Boolean isMasterData = false;

    @Column(columnDefinition = "TINYINT(1) NOT NULL DEFAULT false")
    private Boolean isBlocked = false;

    @Column(columnDefinition = "TINYINT(1) NOT NULL DEFAULT false")
    private Boolean wasDeleted = false;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")    
    private java.util.Date createdIn = new Date();

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.util.Date updatedIn = new Date();  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }    

    public Boolean getIsMasterData() {
        return isMasterData;
    }

    public void setIsMasterData(Boolean isMasterData) {
        this.isMasterData = isMasterData;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Date getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(Date createdIn) {
        this.createdIn = createdIn;
    }

    public Date getUpdatedIn() {
        return updatedIn;
    }

    public void setUpdatedIn(Date updatedIn) {
        this.updatedIn = updatedIn;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }

    public void setWasDeleted(Boolean wasDeleted) {
        this.wasDeleted = wasDeleted;
    }
        
    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        return this.getClass().getSimpleName()
                + " [ Id:" + id + " | Name:" + name
                + " | Masterdata:" + isMasterData + " | Blocked:" + isBlocked + " | Deleted:" + wasDeleted
                + " | CreatedIn:" + dateFormat.format(createdIn) 
                + " | UpdatedIn:" + dateFormat.format(updatedIn) 
                + " ]";
    }    

    
}
