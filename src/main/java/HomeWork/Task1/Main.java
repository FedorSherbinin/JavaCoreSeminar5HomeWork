package HomeWork.Task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void backupFiles(String srcDir) {
        // Указываем путь к папке для резервного копирования
        Path backupDir = Paths.get("src/main/resources/backup");

        // Создаем папку для резервной копии, если она не существует
        if (!Files.exists(backupDir)) {
            try {
                Files.createDirectory(backupDir);
            } catch (IOException e) {
                System.err.println("Не удалось создать папку для резервной копии: " + e.getMessage());
                return;
            }
        }

        // Получаем список всех файлов в исходной директории
        File sourceFolder = new File(srcDir);
        File[] files = sourceFolder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Копируем файл в папку backup
                    try {
                        Files.copy(file.toPath(), backupDir.resolve(file.getName()));
                    } catch (IOException e) {
                        System.err.println("Ошибка при копировании файла: " + file.getName() + " - " + e.getMessage());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Пример использования
        String sourceDirectory = "src/main/resources";
        backupFiles(sourceDirectory);
    }
}
