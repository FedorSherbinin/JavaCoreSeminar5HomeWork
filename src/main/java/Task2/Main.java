package Task2;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Имя файла для чтения
        String filename = "src/main/resources/test.txt";

        // Создаем список для хранения чисел
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Читаем весь файл в строку
            String line = reader.readLine();

            if (line != null && line.startsWith("[") && line.endsWith("]")) {
                // Удаляем квадратные скобки
                line = line.substring(1, line.length() - 1);

                // Разбиваем строку по символу '0'
                String[] parts = line.split("0");

                // Преобразуем строки в целые числа и добавляем в список
                for (String part : parts) {
                    part = part.trim();  // Удаляем лишние пробелы
                    if (!part.isEmpty()) {
                        numbers.add(Integer.parseInt(part));
                    }
                }
            }

            // Преобразуем список в массив
            int[] digits = numbers.stream().mapToInt(Integer::intValue).toArray();

            // Печатаем массив для проверки
            System.out.print("Считанный массив: [");
            for (int i = 0; i < digits.length; i++) {
                System.out.print(digits[i]);
                if (i < digits.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

        } catch (IOException e) {
            // Обработка ошибок ввода/вывода
            System.err.println("Ошибка при чтении из файла: " + e.getMessage());
        }
    }
}
