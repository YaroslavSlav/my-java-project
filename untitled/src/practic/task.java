package practic;

import java.util.Scanner;

class M {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения данных с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Выводим сообщение пользователю для ввода числа
        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        // Выводим введенное число на экран
        System.out.println("Вы ввели число: " + number);

        // Запрашиваем у пользователя первое число
        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();

        // Запрашиваем у пользователя второе число
        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();

        // Вычисляем сумму двух чисел
        int sum = number1 + number2;

        // Выводим сумму на экран
        System.out.println("Сумма двух чисел: " + sum);

        // Закрываем Scanner
        scanner.close();
    }
}
