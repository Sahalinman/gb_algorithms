package lesson6.homework;

import lesson6.materials.TreeImpl;

public class Main {

    private static int treeRandomValue;
    private static int min = -25;
    private static int max = 25;

    private static int balancedTreeCount = 0;
    private static int notBalancedTreeCount = 0;

    private static int treesCount = 50;

    /**
     * Результаты вывода разные:
     *
     * Количество сбалансированных деревьев : 9
     * Количество несбалансированных деревьев : 41
     *
     * Количество сбалансированных деревьев : 5
     * Количество несбалансированных деревьев : 45
     *
     * Количество сбалансированных деревьев : 2
     * Количество несбалансированных деревьев : 48
     */
    public static void main(String[] args) {

        TreeImpl<Integer> tree;

        for (int n = 0; n < treesCount; n++) {
            tree = new TreeImpl<>(4);
            for (int i = 0; i < 30; i++) {
                treeRandomValue = min + (int)(Math.random() * ((max - min) + 1));
                tree.add(treeRandomValue);
            }
            if (tree.isBalanced()) {
                tree.display();
                balancedTreeCount++;
            } else {
                notBalancedTreeCount++;
            }
        }

        System.out.println("Количество сбалансированных деревьев : " + balancedTreeCount);
        System.out.println("Количество несбалансированных деревьев : " + notBalancedTreeCount);
    }
}
