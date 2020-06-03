package factory;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class LogThread implements Runnable {

    private boolean isActive = true;

    public void disable() {
        isActive = false;
    }

    public void run() {

        File file = new File("log.0.0.txt");
        System.out.println("Введите периодичность вывода логов (в секундах)");
        int n = new Scanner(System.in).nextInt();;

        while (isActive) {
            if (file.length() == 0) {
                Date date = new Date();
                System.out.println(date + " Файл с логами пуст за последние " + n + " секунд");
                sleepNSeconds(n);
            } else {
                BufferedReader in = null;
                try {
                    in = new BufferedReader(new FileReader("log.0.0.txt"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String line = null;
                    while (true) {
                        try {
                            if (!((line = in.readLine()) != null)) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(line);
                    }
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("log.0.0.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                writer.print("");
                    writer.close();
                    sleepNSeconds(5);
            }
        }
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}