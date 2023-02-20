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
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class task_1 {
    private static Scanner input = new Scanner(System.in);// через input.nextInt(); будем считывать данные

    public static void main(String[] args) throws FileNotFoundException {
        String nameFileInput = "C:/Users/Andrey/Desktop/GB/WEB_developer/Java/homework_2/input.txt";
        String nameFileOutput = "C:/Users/Andrey/Desktop/GB/WEB_developer/Java/homework_2/output.txt";
        double numberA = getNumberByUser("Введите число которое хотите возвести в степень");
        double numberB = getNumberByUser("Введите степень в которую хотите возвести число " + numberA);
        System.out.println("Вы ввели а = " + numberA + numberA + ", b = " + numberB);
        String[] data = convertInputToArr(numberA, numberB);
        WriteData(data, nameFileInput);
        String[] res = readFileInput(nameFileInput); // хранит массив состоящий из строк файла input.txt
        Double[] valuesBandA = getValueNumber(res);
        double a = valuesBandA[0];
        double b = valuesBandA[1];
        Double result = exponentiation(a, b, nameFileOutput); // вычисляем результат возведения в стпень
        System.out.printf("%f в степени %f = %s", a, b, result);

    }

    /**
     * Функция запрашивает упользователя ввод числа int
     * 
     * @param text сообщение которое будет выведено пользователю перед вводом числа
     * @return возвращает число введеное пользователем
     */
    public static Double getNumberByUser(String text) {
        System.out.println(text);
        Double num = input.nextDouble();
        return num;
    }

    /**
     * Функция записывает данные из ввода пользователя
     * 
     * @param numA то что возводим в степень
     * @param numB в какую степень возводим
     * @return
     */
    public static File WriteData(String[] data, String nameFile) {
        // File newFile = new
        // File("C:/Users/Andrey/Desktop/GB/WEB_developer/Java/homework_2/input.txt");
        File newFile = new File(nameFile);
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
    public static String[] convertInputToArr(Double numA, Double numB) {
        String aNum = Double.toString(numA);
        String bNum = Double.toString(numB);
        String row1 = "a " + aNum;
        String row2 = "b " + bNum;
        Double numRandom = new Random().nextDouble(7);
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

    /**
     * Функция считывает построчно файл input.txt и записывает строки в массив
     * 
     * @param nameFile путь к файлу
     * @return возвращет массив где элементы каждая строка файла input.txt
     * @throws FileNotFoundException
     */

    public static String[] readFileInput(String nameFile) {
        File file = new File(nameFile);
        String line = "";
        String[] resultArr = new String[2];
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = line.concat(scanner.nextLine() + ";");
            }
            resultArr = line.split(";");
            line = "";
        } catch (FileNotFoundException e) {
            System.out.println("readFileInput");
        }

        return resultArr;
    }

    /**
     * Функция извлекает из массива, который получается в результате работы функции
     * readFileInput значения a и b
     * arr =[a,b];
     * 
     * @param Array принимает массив из строк arr = ["a 23', "b 34"]
     * @return возвращает массив int с значениями a и b arr =[a,b];
     */
    public static Double[] getValueNumber(String[] Array) {
        double a = 0;
        double b = 0;
        String[] val = new String[2];
        Double[] arr = new Double[2];

        try {
            for (String str : Array) {
                if (str.contains("b")) {
                    val = str.split(" ");
                    b = Double.parseDouble(val[1]);
                } else {
                    val = str.split(" ");
                    a = Double.parseDouble(val[1]);
                }
                arr[0] = a;
                arr[1] = b;
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(" exception getValueNumber");
        }

        return arr;

    }

    public static Double exponentiation(Double a, Double b, String nameFileOutput) {
        // Быстрое возведение в степень
        // if (b == 0) {
        // return 1.0;
        // }
        // if (b % 2 == 0) {
        // Double result = exponentiation(a, b / 2);
        // return result * result;
        // } else {
        // return a * exponentiation(a, b - 1);
        // }
        double res = Math.pow(a, b);
        String[] data = new String[1];
        data[0] = Double.toString(res);
        WriteData(data, nameFileOutput);
        return res;
    }

}