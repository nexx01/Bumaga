package Generics;

import java.util.List;

public class MainGenerics {

    public static void main(String[] args) {

    }





/*
*  Копирование из одной коллекции в другую
* https://coderoad.ru/18176594/Когда-использовать-универсальные-методы-и-когда-использовать-wild-card
*Здесь вы можете быть уверены, что и dest , и src имеют одинаковый параметризованный тип для List .
*  Таким образом, безопасно копировать элементы из src в dest .
* */
    public static <T extends Number> void copy(List<T> dest, List<T> src){
                for (int i=0; i<src.size(); i++)
                dest.set(i,src.get(i)); // error: illegal argument types
    }





    /*   Копирование из одной коллекции в другую
     * http://www.angelikalanger.com/GenericsFAQ/FAQSections/TypeArguments.html#FAQ203
     *The problem is that the get() method of a List<?> returns a reference pointing to an object of unknown type.
     * References pointing to objects of unknown type are usually expressed as a reference of type Object .
     *  Hence List<?>.get() returns an Object .
     *
     *On the other hand, the set() method of a List<?> requires something unknown, and "unknown" does not mean
     * that the required argument is of type Object . Requiring an argument of type Object would mean
     * accepting everything that is derived of Object . That's not what the set() method of a List<?> is asking for.
     * Instead, "unknown" in this context means that the argument must be of a type that matches the type that
     *  the wildcard ? stands for. That's a much stronger requirement than just asking for an Object .
     *
     * */
    public static void copyCollection1(List<?> dest, List<?> src) {  // uses unbounded wildcards
//        for (int i=0; i<src.size(); i++)
//            dest.set(i,src.get(i)); // error: illegal argument types
    }

    /*   Копирование из одной коллекции в другую
     * http://www.angelikalanger.com/GenericsFAQ/FAQSections/TypeArguments.html#FAQ203
     *The problem is that the get() method of a List<?> returns a reference pointing to an object of unknown type.
     * References pointing to objects of unknown type are usually expressed as a reference of type Object .
     *  Hence List<?>.get() returns an Object .
     *
     * это не сработает так, как ожидалось. Во втором случае вы можете передать List<Integer> и
     * List<Float> как dest и src . Таким образом, перемещение элементов из src в dest больше
     * не будет типобезопасным. Если вам не нужно такое отношение,то вы можете вообще не
     * использовать параметры типа.
     * https://coderoad.ru/18176594/Когда-использовать-универсальные-методы-и-когда-использовать-wild-card
     * */
    public static void copyCollection2(List<? extends Number> dest, List<? extends Number> src) {
//        for (int i=0; i<src.size(); i++)
//            dest.set(i,src.get(i)); // error: illegal argument types
    }


    public static <T> void copyCollection3( List<? super T> dest, List<? extends T> src) { // uses bounded wildcards
        for (int i = 0; i < src.size(); i++)
            dest.set(i, src.get(i));
    }


}
