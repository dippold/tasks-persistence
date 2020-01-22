
package org.builderforce.tasks.persistence.enums;

import java.util.LinkedList;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-11
 *
 */
public enum RULES {

    PROJECT_MANAGER(1L,"Gerente de projetos"),
    TASK_ADMIN(2L,"Administrador de tarefas"),
    PROJECT_TEAM(3L,"Equipe do projeto"),
    PROJECT_STAKEHOLDER(4L,"Stakeholder do projeto");

    public static String[] getDescriptions() {
        java.util.LinkedList<String> list = new LinkedList<>();
        for (RULES o : RULES.values()) {
            list.add(o.getDescription());
        }

        return list.toArray(new String[list.size()]);
    }
    
    public static String[] getIds() {
        java.util.LinkedList<String> list = new LinkedList<>();
        for (RULES o : RULES.values()) {
            list.add(Long.toString(o.getId()));
        }

        return list.toArray(new String[list.size()]);
    }    
    
    private final Long id;
    private final String description;
    
    RULES(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
        
}
