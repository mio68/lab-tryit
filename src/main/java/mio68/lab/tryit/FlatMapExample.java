package mio68.lab.tryit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Урма Рауль-Габриэль, Фуско Марио, Майкрофт Алан
 * Современный язык Java. Лямбда-выражения, потоки и функциональное программирование.
 *
 * Контрольное задание 5.2. Отображение
 * 2. По двум заданным спискам чисел вернуть все их попарные сочетания. Например,
 * при получении списков [1, 2, 3] и [3, 4] нужно вернуть [(1, 3), (1, 4), (2, 3), (2, 4),
 * (3, 3), (3, 4)]. Для простоты можно представить каждую пару в виде массива из двух
 * элементов.
 */
class FlatMapExample {
    /**
     * Выводит в консоль пары все парные сочетания для списков [1, 2, 3] и [3, 4]
     *
     * @param args params are ignored
     */
    public static void main(String[] args) {

        List<Integer> listA = Arrays.asList(1,2,3);
        List<Integer> listB = Arrays.asList(3,4);

//        List<int[]> pairs = listA.stream()
//                .map(i -> listB.stream().map(j-> new int[]{i,j}).collect(Collectors.toList()))
//                .flatMap(List::stream)
//                .collect(Collectors.toList());

        List<int[]> pairs = listA.stream().flatMap(i -> listB.stream().map(j -> new int[]{i,j}))
                .collect(Collectors.toList());

        for(int [] pair: pairs)
            System.out.print( Arrays.toString(pair)+" ");
    }
}