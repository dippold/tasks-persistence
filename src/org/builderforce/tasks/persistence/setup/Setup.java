package org.builderforce.tasks.persistence.setup;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.builderforce.tasks.persistence.daos.LogDAO;
import org.builderforce.tasks.persistence.entities.Log;
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
//            System.out.println(createRulesMasterData());
        }
        
        System.out.println(showRules());
        System.out.println(showLogs());

    }         
    
//    private static void updateInRuleTest(String ruleName) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        RuleDAO dao = new RuleDAO(factory);
//        Rule rule;        
//        try {
//            rule = dao.findByName(ruleName);
//            rule.setIsBlocked(true);
//            Date date = new Date();
//            rule.setUpdatedIn(date);
//            dao.edit(rule);
//            System.out.println("updateInRuleTest(String ruleName): Updated Rule: " + ruleName);
//        } catch(Exception e) {
//            System.out.println("updateInRuleTest(String ruleName): " + e.getMessage());
//        }         
//    }
         
    
    private static String showRules() {
        String out = "listEnumRules() invoked...";
        String[] lst = RULES.getDescriptions();
     
        for (int i=0;i<lst.length;i++) {
            out += "\n" + lst[i];
        }
        
        return out;
    }

//    private static void updateInRuleTest(String ruleName) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        RuleDAO dao = new RuleDAO(factory);
//        Rule rule;        
//        try {
//            rule = dao.findByName(ruleName);
//            rule.setIsBlocked(true);
//            Date date = new Date();
//            rule.setUpdatedIn(date);
//            dao.edit(rule);
//            System.out.println("updateInRuleTest(String ruleName): Updated Rule: " + ruleName);
//        } catch(Exception e) {
//            System.out.println("updateInRuleTest(String ruleName): " + e.getMessage());
//        }         
//    }
    
    /* CREATE MEMBERS... */
    private static String showLogs() {
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        StringBuilder sb = new StringBuilder("  + ");
        sb.append(methodName);
        sb.append("...");
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        LogDAO dao = new LogDAO(factory);
        List<Log> lst = dao.findAll();
        for (Log o : lst) {
            sb.append("/n");
            sb.append(o);
        }
        sb.append("\n  + ");
        sb.append(methodName);
        sb.append(" finish!\n");

        return sb.toString();
    }    
    
    /* UTILS MEMBERS... */
    private static String getFirstName(String name) {
        String[] splited = name.split(" ");

        return splited[0];
    }

    private static String getLastName(String name) {
        String[] splited = name.split(" ");

        return splited[splited.length - 1];
    }     
    
}
