package Task1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        // Шаг 1: Создайте массив из 9 цифр
        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Шаг 2: Откройте файл для записи
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/test.txt"))) {
            // Записываем начало массива
            writer.print("[");

            // Записываем элементы массива
            for (int i = 0; i < digits.length; i++) {
                writer.print(digits[i]);
                // Добавляем число 0 после каждой цифры, кроме последней
                if (i < digits.length - 1) {
                    writer.print("0");
                }
            }

            // Записываем конец массива
            writer.print("]");

            // Печатаем сообщение о завершении записи
            System.out.println("Массив записан в файл test.txt");
        } catch (IOException e) {
            // Обработка ошибок ввода/вывода
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
