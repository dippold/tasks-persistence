package org.builderforce.tasks.persistence.enums;

import java.util.LinkedList;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-06
 *
 */
public enum RulesEnum {
    System_Admin, 
    Project_Admin, 
    Task_Admin, 
    Task_Performance, 
    Project_Stakeholder,
    Portifolio_Admin,
    Portifolio_Stakeholder;

    public static String[] getNames() {
        java.util.LinkedList<String> list = new LinkedList<>();
        for (RulesEnum o : RulesEnum.values()) {
            list.add(o.name());
        }

        return list.toArray(new String[list.size()]);
    }
    
}
