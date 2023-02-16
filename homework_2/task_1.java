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
        String[] data = convertInputToArr(numberA, numberB);
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
            FileWriter writer = new FileWriter(newFile); // ссылается на файл
            if (newFile.createNewFile()) {
                for (String string : data) {
                    writer.write(string + "\n");
                }
            } else {
                for (String string : data) {
                    writer.write(string + "\n");
                }
            }
            writer.flush();
        } catch (Exception e) {
            System.out.println("Not write. Catch Exeption");
        }
        return newFile;
    }

    /**
     * Функция получает на вход два числа a b , приводит их к виду строки a 20 b 30
     * после чего создает и возвращает массив из 2ух элементов где первым элементом
     * массива может быть любая из строк или a или b
     * 
     * @param numA число a, которое ввел пользователь для возведения в степень b
     * @param numB число b, которое ввел пользователь, степень в которую нужно
     *             возвести число a
     * @return масси из 2 строчных элементов arr = {"a randomNumber", "b
     *         randomNumber"} или arr = {"b randomNumber", "a randomNumber"}
     */
    public static String[] convertInputToArr(int numA, int numB) {
        String aNum = Integer.toString(numA);
        String bNum = Integer.toString(numB);
        String row1 = "a " + aNum;
        String row2 = "b " + bNum;
        int numRandom = new Random().nextInt(7);
        String[] arrayRow = new String[2];
        if (numRandom < 3) {
            arrayRow[0] = row1;
            arrayRow[1] = row2;
        } else {
            arrayRow[1] = row1;
            arrayRow[0] = row2;
        }
        return arrayRow;
    }
}