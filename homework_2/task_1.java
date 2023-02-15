package homework_2;

import java.util.Random;
/**
 * task_1
 * 
 */
import java.util.Scanner;// Ипортируем метод для считывания данных с консоли
import java.io.File; // Импортируем метод для работы с файлом
// import java.io.IOException;
import java.io.FileWriter;
// import java.io.Writer;
import java.lang.reflect.Array;

public class task_1 {
    private static Scanner input = new Scanner(System.in);// через input.nextInt(); будем считывать данные

    public static void main(String[] args) {
        // boolean d = newFile.createNewFile();
        // File newFile = new File("22.txt");

        int numberA = getNumberByUser("Введите число которое хотите возвести в степень");
        int numberB = getNumberByUser("Введите  степень в которую хотите возвести число " + numberA);
        System.out.println("Вы ввели а = " + numberA + ", b = " + numberB);
        String[] data = convertInput(numberA, numberB);
        WriteData(data);
    }

    /**
     * Функция запрашивает упользователя ввод числа int
     * 
     * @param text сообщение которое будет выведено пользователю перед вводом числа
     * @return возвращает число введеное пользователем
     */
    public static int getNumberByUser(String text) {
        System.out.println(text);
        int num = input.nextInt();
        return num;
    }

    /**
     * Функция записывает данны из ввода пользователя
     * 
     * @param numA то что возводим в степень
     * @param numB в какую степень возводим
     * @return
     */
    public static File WriteData(String[] data) {
        File newFile = new File("C:/Users/Andrey/Desktop/GB/WEB_developer/Java/homework_2/input.txt");
        try {
            if (newFile.createNewFile()) {
                System.out.println("yes write");
                FileWriter writer = new FileWriter(newFile); // ссылается на файл
                for (String string : data) {
                    System.out.println(string + "\n");
                    writer.write(string);
                }
                writer.flush();

            } else {
                System.out.println("the file contains the valuse 'a' and 'b'. File overwritten");
                FileWriter writer = new FileWriter(newFile); // ссылается на файл
                for (String string : data) {
                    System.out.println(string);
                    writer.write(string + "\n");
                }
                writer.flush();
            }

        } catch (Exception e) {
            System.out.println("Not write. Catch Exeption");
        }
        return newFile;
    }

    public static String[] convertInput(int numA, int numB) {
        String aNum = Integer.toString(numA);
        String bNum = Integer.toString(numB);
        String row1 = "a " + aNum;
        String row2 = "b " + bNum;
        String[] arrayRow = new String[] { row1, row2 };
        return arrayRow;
    }
}