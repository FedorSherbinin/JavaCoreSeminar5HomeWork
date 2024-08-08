package Task3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Указываем файл для чтения и для записи
        try (FileInputStream fis = new FileInputStream("src/main/resources/test2.txt");
             FileOutputStream fos = new FileOutputStream("src/main/resources/test2.new.txt")) {

            int i;
            char what = ' ';  // Символ, который нужно заменить
            char to = '!';    // Символ, на который нужно заменить

            // Читаем файл побайтово
            while ((i = fis.read()) != -1) {
                // Если текущий символ совпадает с искомым
                if (i == what) {
                    // Заменяем на указанный символ
                    fos.write(to);
                } else {
                    // Иначе записываем оригинальный символ
                    fos.write(i);
                }
            }

        } catch (IOException e) {
            // Обработка возможных исключений
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
