
// Написать программу вычисления n-ого треугольного числа Tn = (n*(n+1))/2
import java.util.Scanner; // Метод ожидает ввод данных пользователем в терминал 

public class task_1 {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int num = getNumberByUser("Введите число: ");
        System.out.println("Вы ввели: " + num);
        int result = CalcTreangular(num);
        System.out.println("Треугольное число = " + result);
    }

    /**
     * Функция запрашивает у пользователя любое число int
     * 
     * @param текст предлагающий пользователю ввести число
     * @return возвращает число int
     */
    public static int getNumberByUser(String text) {
        System.out.printf(text);
        int num = input.nextInt();
        return num;
    }

    /**
     * Функция высчитывает треугольное число
     * 
     * @param принимает число int из функции getNumberByUser
     * @return возвращает результат вычислений int
     */
    private static int CalcTreangular(int num) {
        int result = (num * (num + 1)) / 2;
        return result;
    }

}
