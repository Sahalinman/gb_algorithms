package lesson5.homework;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Задание №1

        System.out.println(recursiveDegree(2, 4)); // 16
        System.out.println(recursiveDegree(2, 9)); // 512

        // Задание №2

        List<Stuff> stuffs = new ArrayList<>();
        stuffs.add(new Stuff("Смартфон", 0.2, 350));
        stuffs.add(new Stuff("Ноутбук", 3.5, 1750));
        stuffs.add(new Stuff("Игровая приставка", 4.7, 1900));
        stuffs.add(new Stuff("Драгоценности", 1.1,750));
        stuffs.add(new Stuff("Чайник", 0.7,70));
        stuffs.add(new Stuff("Наручные часы", 0.1,600));
        stuffs.add(new Stuff("Настенные часы", 3.1,300));

        Backpack backpack = new Backpack(5);
        backpack.getBestStaff(stuffs);

        System.out.println(backpack.getBestStuff());
        // Вывод: [Смартфон {ВЕС = 0.2, ЦЕНА = 350}, Ноутбук {ВЕС = 3.5, ЦЕНА = 1750},
        // Драгоценности {ВЕС = 1.1, ЦЕНА = 750}, Наручные часы {ВЕС = 0.1, ЦЕНА = 600}]
    }

    /**
     * Программа по возведению числа в степень с помощью рекурсии
     */
    public static int recursiveDegree(int number, int degree) {
        if (degree == 1) {
            return number;
        }
        return number * recursiveDegree(number, degree - 1);
    }
}
