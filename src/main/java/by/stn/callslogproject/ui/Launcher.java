package by.stn.callslogproject.ui;

import by.stn.callslogproject.personsinfo.UICreator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by EugenKrasotkin on 1/8/2018.
 */
public class Launcher {
    public static void main(String args[]) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-context.xml");
        UICreator uiCreator = (UICreator) context.getBean("uiCreator");
        uiCreator.create();
    }
}