package lesson7.homework;

import lesson7.materials.GraphImpl;

import java.util.List;

public class Main {

    /**
     * Идея
     * 1. Введено понятие ребра Edge, выделено в отдельный класс для удобного хранения, у ребра есть точка ОТ и ДО, а также вес
     * 2. Введена boolean переменная weighed (взвешенный) в классе GraphImpl для оптимизации единого класса, чтобы старый отладочный код с урока тоже работал
     * 3. Создан метод searchWays(String startLabel, String endLabel) поиска маршрутов из точки А в точку Б,
     *      возвращаем список Маршрутов - это вершины через пробел, например: Москва Тула Липецк Воронеж
     * 4. Обрабатываем маршруты в методе indBestRoute(List<String> waysName), где поочередно для каждого маршрута высчитывается длина ребра между точками и суммируется
     *      в результате выводим маршрут с минимальным значением
     *
     * Пример вывода:
     * Маршрут : Москва Тула Липецк Воронеж :: Длина пути : 585
     * Маршрут : Москва Рязань Тамбов Саратов Воронеж :: Длина пути : 600
     * Маршрут : Москва Калуга Орёл Курск Воронеж :: Длина пути : 535
     * Маршрут : Москва Нижний Новгород Тверь Воронеж :: Длина пути : 590
     * ============================================
     * Оптимальный маршрут : Москва Калуга Орёл Курск Воронеж с длиной пути 535 единиц
     *
     */
    public static void main(String[] args) {

        GraphImpl graph = new GraphImpl(12, true);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орёл");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Нижний Новгород");
        graph.addVertex("Тверь");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 120);
        graph.addEdge("Москва", "Рязань", 230);
        graph.addEdge("Москва", "Калуга", 180);
        graph.addEdge("Москва", "Нижний Новгород", 190);

        graph.addEdge("Тула", "Липецк", 290);
        graph.addEdge("Рязань", "Тамбов", 135);
        graph.addEdge("Калуга", "Орёл", 115);
        graph.addEdge("Нижний Новгород", "Тверь", 315);

        graph.addEdge("Липецк", "Воронеж", 175);
        graph.addEdge("Тамбов", "Саратов", 135);
        graph.addEdge("Орёл", "Курск", 75);

        graph.addEdge("Саратов", "Воронеж", 100);
        graph.addEdge("Курск", "Воронеж", 165);
        graph.addEdge("Тверь", "Воронеж", 275);

        List<String> allWaysFromTo = graph.searchWays("Москва", "Воронеж");

        graph.findBestRoute(allWaysFromTo);
    }
}
