package factory;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Logger extends UIProcessing{

    static java.util.logging.Logger LOGGER;

    static {
        FileInputStream ins = null;
        try {
            ins = new FileInputStream("C:\\Users\\log.config");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            LogManager.getLogManager().readConfiguration(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER = java.util.logging.Logger.getLogger(Doc.class.getName());
    }

    @After("execution(* addDocument(..))")
    public void afterAddDocument() {
        LOGGER.log(Level.INFO, "Создался документ " + docName + " и полем ID со значением " + doc.getId() + " \nКласс созданного объекта: " + doc.getDocName());
    }

    @After("execution(* changeDocument(..))")
    public void afterChangeDocument() {
        LOGGER.log(Level.INFO, "Была отредактирована запись под номером "
                + slot + " Класс отредактированного объекта: "
                + myArrayList.get(slot - 1).getDocName()
                + " Предыдущее значение ID: " + test
                + " Новое значение ID: "
                + myArrayList.get(slot - 1).getId());
    }

    @After("execution(* deleteDocument(..))")
    public void afterDeleteDocument() {
        LOGGER.log(Level.INFO, "Была удалена запись под номером "
                + slot + " Класс удаленного объекта: "
                + idName + " Значение ID: " + id);
    }

}