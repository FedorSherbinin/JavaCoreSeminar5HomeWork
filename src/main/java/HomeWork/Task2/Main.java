package HomeWork.Task2;

public class Main {

    public static void main(String[] args) {
        // Пример игрового поля
        int[] board = {1, 0, 2, 0, 1, 2, 2, 0, 1};

        // Отобразим игровое поле в консоли
        printBoard(board);
    }

    // Метод для отображения игрового поля
    public static void printBoard(int[] board) {
        // Проверяем, что массив имеет 9 элементов
        if (board.length != 9) {
            System.out.println("Неверный размер игрового поля.");
            return;
        }

        // Перебираем каждую ячейку на поле
        for (int i = 0; i < board.length; i++) {
            // Определяем символ в зависимости от значения
            char symbol;
            switch (board[i]) {
                case 1:
                    symbol = 'X'; // крестик
                    break;
                case 2:
                    symbol = 'O'; // нолик
                    break;
                default:
                    symbol = ' '; // пустая ячейка
                    break;
            }

            // Печатаем символ
            System.out.print(symbol);

            // Разделение столбцов
            if ((i + 1) % 3 != 0) {
                System.out.print(" | ");
            }

            // Разделение строк
            if ((i + 1) % 3 == 0 && i != board.length - 1) {
                System.out.println("\n---------");
            }
        }

        // Переход на новую строку после вывода поля
        System.out.println();
    }
}
