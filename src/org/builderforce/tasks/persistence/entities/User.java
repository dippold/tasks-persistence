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
    @NamedQuery(name = "User.authenticate",
            query = "SELECT o FROM User o WHERE o.email = :email AND o.passwd = :passwd"),
    @NamedQuery(name = "User.findby.name",
            query = "SELECT o FROM User o WHERE o.name = :name"),
    @NamedQuery(name = "User.findby.email",
            query = "SELECT o FROM User o WHERE o.email = :email"),
    @NamedQuery(name = "User.findby.keyword",
            query = "SELECT o FROM User o WHERE o.name LIKE :keyword ORDER BY o.name"),
    @NamedQuery(name = "User.findby.rule",
            query = "SELECT o FROM User o WHERE o.ruleId = :ruleId ORDER BY o.name"),
    @NamedQuery(name = "User.findall.order.by.name",
            query = "SELECT o FROM User o ORDER BY o.name")
})

public class User extends AbstractEntity {
    
    @Column(unique = true, nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 20)
    private String passwd;
   
    @Column(nullable = false, columnDefinition = "BIGINT(20) default 1")
    private Long ruleId = 1L;     

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }
    
}
