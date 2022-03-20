import java.util.HashMap;
import java.util.Map;

public class TechTask {
    public static Boolean testMethod(int[] array) {
        int counter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + 1 == array[i + 1]) {
                counter++;
                if (counter == 2) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    public static String testMethod1(String word, String separator, int count) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(word);
            if (i + 1 != count) {
                result.append(separator);
            }
        }
        return result.toString();
    }

    public static Map<Character, Boolean> testMethod2(char[] array) {
        final Map<Character, Boolean> map = new HashMap<>();
        for (char c : array) {
            map.put(c,map.containsKey(c));
        }
        return map;
    }
}
