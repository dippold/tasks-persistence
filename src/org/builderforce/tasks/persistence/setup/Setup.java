package org.builderforce.tasks.persistence.setup;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        
//        updateInRuleTest("Project Admin");
        
//        System.out.println(showRules());
//        
        System.out.println(showRules());
//        
//        System.out.println("Tasks Mng Setup finish!");        
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
    
    /* CREATE MEMBERS... */
//    private static String createRulesMasterData() {
//        final String methodName = new Object() {
//        }.getClass().getEnclosingMethod().getName();
//        StringBuilder sb = new StringBuilder("  + ");
//        sb.append(methodName);
//        sb.append("...");
//        String[] names = {
//            "System Admin", 
//            "Project Admin", 
//            "Task Admin",
//            "Task Performance",
//            "Project Stakeholder",
//            "Portifolio Admin",
//            "Portifolio Stakeholder"
//        };
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        RuleDAO dao = new RuleDAO(factory);
//        for (String name : names) {
//            Rule o = new Rule();
//            o.setName(name);
//            o.setIsMasterData(true);
//            dao.create(o);
//        }
//        sb.append("\n  + ");
//        sb.append(methodName);
//        sb.append(" finish!\n");
//
//        return sb.toString();
//    }    
    
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
