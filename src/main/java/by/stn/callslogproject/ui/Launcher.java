package by.stn.callslogproject.ui;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String args[]) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-context.xml");
        UICreator uiCreator = (UICreator) context.getBean("uiCreator");
        uiCreator.create();
    }
}