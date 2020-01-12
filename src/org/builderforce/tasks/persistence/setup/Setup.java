package org.builderforce.tasks.persistence.setup;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.builderforce.tasks.persistence.daos.LogDAO;
import org.builderforce.tasks.persistence.daos.UserDAO;
import org.builderforce.tasks.persistence.entities.Log;
import org.builderforce.tasks.persistence.entities.User;
import org.builderforce.tasks.persistence.enums.RULES;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-04
 *
 */
public class Setup {

    private static final String PERSISTENCE_UNIT_NAME = "TasksPU";
    private static final boolean CREATE = Boolean.FALSE;

    public static void main(String[] args) {
        System.out.println("Tasks Mng 1.0.0 running...\n");
        if (CREATE) {
            System.out.println(createUsers());
        }
        System.out.println(createLog());
        System.out.println(showRules());
        System.out.println(showUsers());
        System.out.println(showLogs());
    }

    /* LIST MEMBERS */
    private static String showRules() {
        String out = "\nlistEnumRules() invoked...";
        String[] lst = RULES.getDescriptions();

        for (int i = 0; i < lst.length; i++) {
            out += "\n+ " + lst[i];
        }

        return out;
    }
    private static String showUsers() {
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        StringBuilder sb = new StringBuilder("\n");
        sb.append(methodName);
        sb.append("...");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);
        List<User> lst = dao.findAll();
        
        lst.forEach((o) -> {
            sb.append("\n+ ");
            sb.append(o);
        });

        sb.append("\n");
        sb.append(methodName);
        sb.append(" finish!");

        return sb.toString();
    }        
    private static String showLogs() {
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        StringBuilder sb = new StringBuilder("\n");
        sb.append(methodName);
        sb.append("...");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        LogDAO dao = new LogDAO(factory);
        List<Log> lst = dao.findAll();
        for (Log o : lst) {
            sb.append("\n+ ");
            sb.append(o);
        }
        sb.append("\n");
        sb.append(methodName);
        sb.append(" finish!");

        return sb.toString();
    }

    /* CREATE MEMBERS... */
    private static String createUsers() {
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        StringBuilder sb = new StringBuilder("  + ");
        sb.append(methodName);
        sb.append("...");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);
        User o = new User();
        o.setName("Fabio Tavares Dippold");
        o.setEmail("dippold.br@gmail.com");
        o.setPasswd("galateo2013");
        o.setRuleId(RULES.PROJECT_MANAGER.getId());
        dao.create(o);
        sb.append("\nCriado User: ");
        sb.append(o);

        sb.append("\n  + ");
        sb.append(methodName);
        sb.append(" finish!\n");

        return sb.toString();
    }
    private static String createLog() {
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        StringBuilder sb = new StringBuilder("\n");
        sb.append(methodName);
        sb.append("...");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        LogDAO dao = new LogDAO(factory);
        Log o = new Log();
        o.setName("RUN SETUP");
        o.setEntityName(Log.class.getSimpleName());
        o.setUserAction("LST LOGS");
        dao.create(o);
        sb.append("\n+Log registrado!");
        sb.append("\n");
        sb.append(methodName);
        sb.append(" finish!\n");

        return sb.toString();
    }
    
    /* UTILITIES MEMBERS... */
    private static String getFirstName(String name) {
        String[] splited = name.split(" ");

        return splited[0];
    }
    private static String getLastName(String name) {
        String[] splited = name.split(" ");

        return splited[splited.length - 1];
    }

}
