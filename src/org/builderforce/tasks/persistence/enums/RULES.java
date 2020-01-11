
package org.builderforce.tasks.persistence.enums;

import java.util.LinkedList;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-11
 *
 */
public enum RULES {

    PROJECT_MANAGER(1,"Gerente de projetos"),
    TASK_ADMIN(2,"Administrador de tarefas"),
    PROJECT_TEAM(3,"Equipe do projeto"),
    PROJECT_STAKEHOLDER(4,"Stakeholder do projeto");

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
            list.add(Integer.toString(o.getId()));
        }

        return list.toArray(new String[list.size()]);
    }    
    
    private final int id;
    private final String description;
    
    RULES(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
        
}
