**По вопросам проверки и переноса обращаться к Игорю tg: @inchestnov**

###1. Прочитать в книге "Грокаем алгоритмы" или в предложенных материалах про алгоритмы и О-большое.

###2. Определить сложность следующих алгоритмов:

-. Поиск элемента массива с известным индексом

    Ответ: Поиск элемента по индексу заранее известная операция и будет выполняться за 1 итерацию, например int result = array[251].
    Сложность в данном случае будет равнa O(1) - константная 

-. Дублирование одномерного массива через foreach

-. Удаление элемента массива с известным индексом без сдвига

    Ответ: Необходима будет реализация своего метода, например, removeByIndex(int[] array, int index) или воспользоваться подключаемой библиотекой ArrayUtils.removeElement()
    В любом случае, нам необходимо пройти по N элементам массива, я думаю сложность в данном случае будет равна O(n) - линейная

-. Удаление элемента массива с неизвестным индексом без сдвига

    Ответ: Решение предполагает то, что нужно скопировать массив в новый (длиной меньше единицы), пропустив элемент, который мы хотели бы удалить.
    Я думаю сложность в данном случае будет равна O(n) - линейная

-. Удаление элемента массива с неизвестным индексом со сдвига

###3. Определить сложность следующих алгоритмов. Сколько произойдет итераций?

a)

```
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                arrayList.add(i * j);
            }
        }
```
    Ответ: 
b)

```
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            for (int j = i; j < n; j++) {
                arrayList.add(i * j);
            }
        }
```
    Ответ:

с)

```
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                arrayList.add(i * j);
				n--;
            }
        }
```
     Ответ: 

d)
```	
    factorial(BigInteger.valueOf(10000))
	
    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return n;
        }
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
    }
```
     Ответ: 

e)
```
    fib(BigInteger.valueOf(50));

    public static BigInteger fib(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ZERO;
        }
        if (n.equals(BigInteger.TWO)) {
            return BigInteger.ONE;
        }
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));
    }
```
     Ответ: 