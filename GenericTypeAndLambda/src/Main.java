import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Box<String> myStringBox = new Box<>();
        Box<Integer> myIntegerBox = new Box<>();
        Box<Double> myDoubleBox = new Box<>();

        myStringBox.set("Abraham");
        myIntegerBox.set(53);
        myDoubleBox.set(Math.random());

        List<Box> myBoxes = new ArrayList<>();
        myBoxes.add(myStringBox);
        myBoxes.add(myIntegerBox);
        myBoxes.add(myDoubleBox);

        for (Box currentBox : myBoxes) {
            System.out.println(currentBox.get());
        }

        System.out.println("--------------------");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(8);
        numbers.add(9);
        numbers.add(1);

        numbers.forEach( (n) -> System.out.println(n) );

        System.out.println("--------------------");

        /* Lambda expressions can be stored in variables if the variable's Type
           is an interface which has only one method like a Consumer<> interface */
        Consumer<Integer> methodOne = (n) -> { n = n * 10; n = n * n; System.out.println(n);
                                            n = n + 5; System.out.println(n); };

        numbers.forEach( methodOne );

        System.out.println("--------------------");

        List<String> words = new ArrayList<>();
        words.add("Bertus");
        words.add("Arno");
        words.add("Belinda");
        words.add("Jan");
        words.add("Petra");

        Consumer<String> methodTwo = (a) -> { a = a.concat("nus"); System.out.println(a); };

        words.forEach( methodTwo );

    }
}

// T for Type (String, Integer or Double in this example)
class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
