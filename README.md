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

8. ##### Stream API. Пример использования flatMap

* mio68.lab.tryit.FlatMapExample

Урма Рауль-Габриэль, Фуско Марио, Майкрофт Алан
Современный язык Java. Лямбда-выражения, потоки и функциональное программирование.

 Контрольное задание 5.2. Отображение
 По двум заданным спискам чисел вернуть все их попарные сочетания. Например,
 при получении списков [1, 2, 3] и [3, 4] нужно вернуть [(1, 3), (1, 4), (2, 3), (2, 4),
 (3, 3), (3, 4)]. Для простоты можно представить каждую пару в виде массива из двух
 элементов.

9. ##### Count IP Addresses от CodeWars

* mio68.lab.tryit.codewars.CountIPAddresses

Первый вариант решения - опять Stream API.   
Во втором варианте пробовал использовать скриптовый движок.

10. #### Valid Parentheses от CodeWars

* mio68.lab.tryit.codewars.Solution

Почему то никто не решал с использованием Stream API, решения не впечатлили. В варинте 2 использовал
switch с лямбдами в стиле Java 12. 

11. #### parseInt() reloaded от CodeWars

* mio68.lab.tryit.codewars.Solution

Среди прочих решений не увидел поучительных. Не было и значительно более коротких. Скучновато.

12. #### Common Denominators от CodeWars

* mio68.lab.tryit.codewars.Fracts

Коротких решений не было. Кода у всех много. Узнал английские варианты для 
НОК(наименьшее общее кратное) - LCM, НОД(наибольший общий делитель) - GCD. 
Пример с рекурсией:


`private static long gcd(long a, long b) {
return b == 0 ? a : gcd(b, a % b);
}
private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
}
`

Пример с лямбдами:

`class Fracts {
static LongBinaryOperator gcd = (a, b) -> valueOf(a).gcd(valueOf(b)).longValue();
static LongBinaryOperator lcm = (a, b) -> b / gcd.applyAsLong(a, b) * a;
...
 ...Fracts.lcm::applyAsLong...
...`

13. ##### Greed is Good  от CodeWars

* mio68.lab.tryit.codewars.Greed

Попрактиковал Stream API (grouping and conunting). Из предложенных другими проголосовал за короткий вариант
, в частности этот вариант легко реализовать на любых языках:

`public static int greedy(int[] dice) {
int n[] = new int[7];
for (int d : dice) n[d]++;
return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
}`

14. #### Simple Pig Latin от CodeWars

* mio68.lab.tryit.codewars.PigLatin

Регулярные выражения рулят! Разузнал как делать ссылки группы в регулярных выражениях. В выражении определяющем 
замену это $n где n - номер группы ( не забудь про нумерацию, 0 - это номер всего match) 

` Pattern.compile("(\\w)(\\w*)").matcher(str).replaceAll("$2$1ay");`

15. #### Рауль Урма, Марио Фуско, Алан Майкрофт Современный язык Java. 2 издание. Глава Параллельная обработка данных и производительность

Суммируем числа от 1 до 10 000 000. Тремя способами - 
* mio68.lab.tryit.concurrency.SequenceSum.iterativeSum - при помощи цикла for(внешняя итерация)  
* mio68.lab.tryit.concurrency.SequenceSum.rangedSum - с использованием Stream API (внутренняя итераци)
* mio68.lab.tryit.concurrency.SequenceSum.parallelRangedSum - с использованием Stream API и распараллеливанием (внутренняя итераци)
* mio68.lab.tryit.concurrency.SequenceSumBenchmarkTest - тест производительности с использованием JMH 
Результаты
<pre>
    Benchmark                                   Mode  Cnt  Score   Error  Units
    SequenceSumBenchmarkTest.iterativeSum       avgt   10  5,480 ? 3,123  ms/op
    SequenceSumBenchmarkTest.parallelRangedSum  avgt   10  1,105 ? 0,006  ms/op
    SequenceSumBenchmarkTest.rangedSum          avgt   10  7,121 ? 0,010  ms/op
</pre>
Также наблюдал загрузку процессора в диспетчере задач 
* mio68.lab.tryit.concurrency.SequenceSum.iterativeSum ~10%
* mio68.lab.tryit.concurrency.SequenceSum.rangedSum ~10% 
* mio68.lab.tryit.concurrency.SequenceSum.parallelRangedSum ~50%

При включении parаllel процессор задействован больше в 5 раз!