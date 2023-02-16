package homework_2;

/**
 * task_1
 * 
 */
import java.util.Random;
import java.util.Scanner;// Ипортируем метод для считывания данных с консоли
import java.io.File; // Импортируем метод для работы с файлом
import java.io.FileWriter;
import java.lang.reflect.Array;
// import java.io.IOException;
// import java.io.Writer;

public class task_1 {
    private static Scanner input = new Scanner(System.in);// через input.nextInt(); будем считывать данные

    public static void main(String[] args) {
        int numberA = getNumberByUser("Введите число которое хотите возвести в степень");
        int numberB = getNumberByUser("Введите степень в которую хотите возвести число " + numberA);
        System.out.println("Вы ввели а = " + numberA + ", b = " + numberB);
        String[] data = convertInput(numberA, numberB);
        // String[] randomData = getRandomElement(data);
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
     * Функция записывает данные из ввода пользователя
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
                // writer.flush();

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

    public static int getRandomElement() {
        int numRandom = new Random().nextInt(7);
        return numRandom;
    }

    public static String[] convertInput(int numA, int numB) {
        String aNum = Integer.toString(numA);
        String bNum = Integer.toString(numB);
        String row1 = "a " + aNum;
        String row2 = "b " + bNum;
        int rand = getRandomElement();
        String[] arrayRow = new String[2];
        if (rand < 3) {
            arrayRow[0] = row1;
            arrayRow[1] = row2;
        } else {
            arrayRow[1] = row1;
            arrayRow[0] = row2;
        }
        return arrayRow;
    }
}