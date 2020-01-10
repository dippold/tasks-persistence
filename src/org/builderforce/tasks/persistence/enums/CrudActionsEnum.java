package org.builderforce.tasks.persistence.enums;

import java.util.LinkedList;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-05
 *
 */
public enum CrudActionsEnum {

    LST, ADD, UPD, DEL, READ;

    public static String[] getNames() {
        java.util.LinkedList<String> list = new LinkedList<>();
        for (CrudActionsEnum o : CrudActionsEnum.values()) {
            list.add(o.name());
        }

        return list.toArray(new String[list.size()]);
    }

}
