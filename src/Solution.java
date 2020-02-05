
/*
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
        TreeSet<Double> tSet = new TreeSet<>();

        while (fr.ready()) {
            String[] array = fr.readLine().split(" ");
            for (int i = 0; i < array.length; i += 2) {
                if (map.containsKey(array[i])) {
                    map.put(array[i], map.get(array[i]) + Double.parseDouble(array[i+1]));
                }
                else
                    map.put(array[i], Double.parseDouble(array[i+1]));
            }
        }
        fr.close();

        tSet.addAll(map.values());
        double d = tSet.pollLast();

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue().equals(d)) {
                System.out.println(pair.getKey());
            }
        }
    }
}
