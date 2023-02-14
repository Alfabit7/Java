package homework_2;

/**
 * task_1
 * 
 */
import java.util.Scanner;// Ипортируем метод для считывания данных с консоли

public class task_1 {
    private static Scanner input = new Scanner(System.in);// через input.nextInt(); будем считывать данные

    public static void main(String[] args) {
        int numberA = getNumberByUser("Введите число которое хотите возвести в степень");
        int numberB = getNumberByUser("Введите  степень в которую хотите возвести число " + numberA);
        System.out.println("Вы ввели а = " + numberA + ", b = " + numberB);
    }

    public static int getNumberByUser(String text) {
        System.out.println(text);
        int num = input.nextInt();
        return num;
    }

}