package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ShapeService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main method Starts!");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);

        System.out.println(shapeService.getCircle().getName());
        shapeService.getCircle().setName("Ranjita is a Beautiful");
//        System.out.println(shapeService.getCircle().getName());


    }
}