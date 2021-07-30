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