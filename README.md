### Поучительные или не очень примеры кода из разных источников. Пробы пера на разные темы. Решения задач и т.д. и т.п.

1. #### Джошуа Блох. Effective Java. Item 78: Synchronize access to shared mutable data

Конкурентный доступ к данным см здесь: 
* ConcurencyWithVolatile
* ConcurrncyWithSynchronized

2. #### DisemvowelTrolls от CodeWars и тесты производительности методов с JMH.
   
Задача

* mio68.lab.tryit.codewars.DisemvowelTrolls

Использование аннтоаций для бэнчмарков 

* DisemvowelTrollsBenchmark
       
Нашел полезный **jmh-maven-plugin** см. в **pom.xml**. Запуск тестов производительности ниже.
   
  ` mvn jmh:benchmark`

3. #### You're a square! от CodeWars 

Задача

* mio68.lab.tryit.codewars.SquareNumber

Кроме решения на основе вычисления квадратного корня пытался 
найти решение на основе признаков(логических условий) того что 
целое число является точным квадратом целого числа и не нашел! Удивлен!

4. #### Detect Pangram от CodeWars

Задача

* mio68.lab.tryit.codewars.PangramChecker

Обработка символов строки с помощью Stream. Дешево и сердито...

5. #### Сортировка слов в предложении от CodeWars

Задача

* mio68.lab.tryit.codewars.Order

Среди вариантов предложенных другими понравился тот, где для выделения цифры включенной в 
слово используются метод замены по регулярному выражению, убирающий все не цифровые символы.

`        return Arrays.stream(words.split(" "))
                .sorted( Comparator.comparing( w -> w.replaceAll("\\D","")))
                .collect(Collectors.joining(" "));
`

Для тестирования используется Hamcrest см https://www.baeldung.com/java-junit-hamcrest-guide

6. #### Create Phone Number от CodeWars

* mio68.lab.tryit.codewars.Kata

Простая задача дающая много решений. Простое решение - некрасивый код, красивый код - 
но скорее всего не эффективный по производительности. Остановился на варианте 3.
В итоге понравилось чужое решение с преобразованием массива int в массив Integer (см вариант 5 в классе Kata)

`public static String createPhoneNumber(int[] numbers) {
return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
}`

Ну и про Java varargs посмотрел заодно https://javarush.ru/groups/posts/2733-java-varargs

7. ##### Maximum subarray sum от CodeWars

* mio68.lab.tryit.codewars.Max

Решил но несколько витиевато. Можно было обойтись без флага и использовать текущюю сумму со значением 
0 как индиктор фазы накопления. Но мое решение мне кажется более прозрачным и документированным.
Проголосовал за следующее решение

`public static int sequence(int[] arr) {
int max_ending_here = 0, max_so_far = 0;
for (int v : arr) {
max_ending_here = Math.max(0, max_ending_here + v);
max_so_far = Math.max(max_so_far, max_ending_here);
}
return max_so_far;
}`