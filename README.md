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


