package homework_2;

/**
 * task_1
 * 
 */
import java.util.Scanner;// Ипортируем метод для считывания данных с консоли
import java.io.File; // Импортируем метод для работы с файлом
// import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;

public class task_1 {
    private static Scanner input = new Scanner(System.in);// через input.nextInt(); будем считывать данные

    public static void main(String[] args) {
        // boolean d = newFile.createNewFile();
        // File newFile = new File("22.txt");

        int numberA = getNumberByUser("Введите число которое хотите возвести в степень");
        int numberB = getNumberByUser("Введите  степень в которую хотите возвести число " + numberA);
        System.out.println("Вы ввели а = " + numberA + ", b = " + numberB);
        WriteData(numberA, numberB);
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

    public static File WriteData(int numA, int numB) {
        File newFile = new File("C:/Users/Andrey/Desktop/GB/WEB_developer/Java/homework_2/input.txt");

        try {
            if (newFile.createNewFile()) {
                System.out.printf("yes write");
                // FileWriter writer = new FileWriter(
                // "C:/Users/Andrey/Desktop/GB/WEB_developer/Java/homework_2/input.txt");
                // для записи используем FileWriter. writer ссылается на путь к файлу или файл
                FileWriter writer = new FileWriter(newFile); // ссылается на файл
                writer.write(Integer.toString(numA, numB));// записыаем то что ввел пользовалеть предварительно поменяв
                                                           // тип в строку
                writer.flush();
            } else {
                FileWriter writer = new FileWriter(newFile, true);
                writer.write(Integer.toString(numA, numB));
                System.out.println("else");
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("not write");
        }
        return newFile;
    }

}
