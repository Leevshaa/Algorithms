package app;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {10, 23, 69, 30, 18, 53, 27,
                83, 5, 68, 1, 7, 64, 57, 24};

        //Виводимо початковий вигляд масиву
        System.out.println("\nПочатковий вигляд масиву: " + Arrays.toString(numbers));

        for (int i = 1; i < numbers.length; i++){
            int key = numbers[i]; //змінна-ключ, яку "беремо" для порівняння
            int j = i - 1; //попередній індекс перед key, з яким порівнюємо змінну key

            while (j >= 0 && numbers[j] > key){
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = key;
        }
        System.out.println("\nВідсортований масив: " + Arrays.toString(numbers));

        //Створюємо сканер, для отримання користувацього значення
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведіть число для пошуку: ");
        int dataSearch = scanner.nextInt();

        //Визначаємо змінними межі масиву
        int left = 0;
        int right = numbers.length - 1;
        int index = -1; //<-за замовчуванням вважаємо, що значення відсутнє в масиві

        while (left <= right){
            int mid = right - left / 2; //<-знаходимо середину масиву

            if (numbers[mid] == dataSearch){
                index = mid;
                break;
            } else if (numbers[mid] > dataSearch){
                right = mid - 1; //якщо введене значення менше, ніж значення в середині масиву, то переміщуємо праву межу за середину - 1
            } else {
                left = mid + 1; //навпаки
            }
        }
        if (index == -1)
            System.out.println("\nЧисло " + dataSearch + " відсутнє у масиві :(");
        else
            System.out.println("\nІндекс числа " + dataSearch + " у відсортованому масиві: " + index);
    }
}