package factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class UIProcessing {

    static ArrayList<Doc> myArrayList = new ArrayList<Doc>();
    static int slot, newId, test, id;
    static String docName, idName;
    static Doc doc;

    public void addDocument(AnnotationConfigApplicationContext ctx) {
        System.out.print("Введите название документа (Passport, Contract): ");
        docName = new Scanner(System.in).nextLine();
        doc = ctx.getBean(docName, Doc.class);
        System.out.println();
        System.out.print("Введите ID документа: ");
        doc.setId(new Scanner(System.in).nextInt());
        System.out.println();
        myArrayList.add(doc);
    }

    public void changeDocument() {
        if (myArrayList.size() == 0) {
            System.out.println("Ошибка, документ ещё не создан, введите \"1\"");
            return;
        } else {
            System.out.print("Введите ячейку в списке которую хотите изменить: ");
            slot = new Scanner(System.in).nextInt();
            System.out.print("Введите новое значение: ");
            newId = new Scanner(System.in).nextInt();
            test = myArrayList.get(slot - 1).getId();
            myArrayList.get(slot - 1).setId(newId);
        }
    }

    public void deleteDocument() {
        if (myArrayList.size() == 0) {
            System.out.println("Ошибка, документ ещё не создан, введите \"1\"");
            return;
        }
        System.out.print("Введите номер ячейки которую хотите удалить: ");
        slot = new Scanner(System.in).nextInt();

        id = myArrayList.get(slot - 1).getId();
        idName = myArrayList.get(slot - 1).getDocName();
        myArrayList.remove(slot - 1);
    }

    public void showDocuments() {
        if (myArrayList.size() == 0) {
            System.out.println("Список пуст введите \"1\"");
            return;
        }
        System.out.println("Вывожу список документов");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print((i + 1) + ": ");
            System.out.print(myArrayList.get(i));
            System.out.println(" ID: " + myArrayList.get(i).getId());
        }
    }

    public void showMenu() {
        System.out.print("Доступные команды:\n" +
                "1) Создать новый документ\n" +
                "2) Редактировать документ\n" +
                "3) Удалить документ\n" +
                "4) Вывести список документов\n" +
                "5) Выйти из программы\n" +
                "Введите номер команды: ");
        System.out.println();
    }
}