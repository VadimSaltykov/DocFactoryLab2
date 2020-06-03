package factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

class FactoryPatternExample {

    public static void main(String[] args) {

        LogThread logThread = new LogThread();
        Thread thread = new Thread(logThread);
        thread.start();
        boolean state = true;

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        ApplicationContext context =
                new ClassPathXmlApplicationContext("aop-developer-annotations-config.xml");

        UIProcessing ui = (UIProcessing) context.getBean("ui");

        while (state) {
            ui.showMenu();
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1: {
                        ui.addDocument(ctx);
                    }
                    break;
                    case 2: {
                        ui.changeDocument();
                        break;
                    }
                    case 3: {
                        ui.deleteDocument();
                        break;
                    }
                    case 4: {
                        ui.showDocuments();
                        break;
                    }
                    case 5: {
                        state = false;
                        logThread.disable();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Ошибка");
        }
        }
    }
}