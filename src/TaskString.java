import java.util.*;
import java.util.stream.Collectors;

public class TaskString {

    //1.Перевернуть строку
    public static void task1(String str) {
        System.out.println(new StringBuilder(str).reverse());
    }

    //2.Заменить символ в строке
    public static void task2(String str) {
        System.out.println(str.replace("с", "в"));
    }

    //3.удалить определенный символ в строке
    public static void task3(String str) {
        System.out.println(new StringBuilder(str).delete(2, 3));
    }

    //4.подсчитать сколько раз символ встречается в строке, учитывая различные раскладки
    public static void task4(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x' || str.charAt(i) == 'х')
                count++;
        }
        System.out.print(count);
    }

    //5.вывести строку указанное число раз с разделителем
    public static String mas(String word, String sep, int count) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(word);
            if (i + 1 != count) {
                s.append(sep);
            }
        }
        return s.toString();
    }

    //6.написать метод который определяет является ли строка палиндромом
    public static String reverseString(String s) {
        String r = "";
        for (int i = s.length() - 1; i >= 0; --i)
            r += s.charAt(i);
        return r;
    }

    public static Boolean isPalindrome(String s) {
        if (s.equals(reverseString(s))) {
            System.out.println("Полиндром");
        } else {
            System.out.println("Не полиндром");
        }
        return s.equals(reverseString(s));

    }

    //8.вычислить число Фибоначчи
    public static void task8() {
        int[] array = new int[15];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
            System.out.print(array[i] + " ");
        }
    }

    //9. Вычислить факториал
    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    //10Создать коллекцию целых чисел, написать методы:
    // Который отрицательные числа делает положительными и возвращает коллекцию ([1, 5, -3, 7] -> [1, 5, 3, 7])
    public static void coll() {
        List<Integer> numbers = Arrays.asList(1, -2, -3, 4, 5, -6, 7, -8, 9, 10);
        numbers.stream()
                .map(Math::abs)
                .forEach(System.out::println);
    }

    //11Который четные числа умножает на 100, а от нечетных отнимает 100 и возвращает коллекцию.
    // Количество принимаемых и возвращаемых элементов коллекций должно совпадать


    public static void coll1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().map(i -> i % 2 != 0 ? i - 100 : i * 100)
                .forEach(System.out::println);
    }

    //12Есть стринговый лист фамилий, нужно пройтись по списку, вытащить фамилии которые начинаются на А
    // и поместить их в другой список для дальнейшей работы с ними
    public static void coll2() {
        List<String> numbers = new ArrayList<String>();
        Collections.addAll(numbers, "Аск", "Ава", "Ирк", "Ерк", "Урк");
        List<String> filter = numbers.stream().filter(i -> i.contains("А")).collect(Collectors.toList());
        System.out.println(filter);
    }


    public static void main(String[] args) {
        coll2();

    }
}
