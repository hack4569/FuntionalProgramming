package methodref;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRef1 {
    public static void main(String[] args) {
        BinaryOperator<Integer> sum = MethodRef1::add;

        Integer sum1 = sum.apply(1, 2);

        Person person1 = new Person("LEE");
        Person person2 = new Person("KIM");
        Person person3 = new Person("PARK");

        Function<Person, String> func1 = (Person person) -> person.introduce();
        Function<Person, String> func2 = Person::introduce;
        System.out.println(func1.apply(person1));
        System.out.println(func2.apply(person2));

        Supplier<String> staticMethod1 = Person::greeting;
        System.out.println(staticMethod1.get());

        Supplier<String> instanceMethod = person3::introduce;
        System.out.println(instanceMethod.get());

        Supplier<Person> newPerson = Person::new;
        System.out.println(newPerson.get());

        Person person = new Person("LEE");
        Function<Integer, String> instanceMethod1 = person::introduceWithNumber;
        System.out.println("instanceMethod1: " + instanceMethod1.apply(1));

        BiFunction<Person, Integer, String> instanceMethod2 = Person::introduceWithNumber;
        System.out.println("instanceMethod2: " + instanceMethod2.apply(person, 2));
    }

    static int add(int a, int b) {
        return a + b;
    }
}
