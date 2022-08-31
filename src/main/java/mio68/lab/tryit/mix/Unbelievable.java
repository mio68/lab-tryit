package mio68.lab.tryit.mix;

/*
Почти всегда при смешивании обычных и упакованных примитивных типов в одной операции
упакованный примитивный тип автоматически распаковывается.
При автоматической распаковке нулевого объекта генерируется исключение NullPointerException.
*/
public class Unbelievable {
    static Integer i;

    public static void main(String[] args) {
        if (i ==  42) // throws NullPointerException
            System.out.println("Невероятно");
    }
}