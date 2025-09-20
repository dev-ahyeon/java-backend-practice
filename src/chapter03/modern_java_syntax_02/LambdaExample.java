// 람다 표현식 예제: 함수형 인터페이스 활용
package chapter03.modern_java_syntax_02;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // 파라미터 1개, 명령문 1개
        names.forEach(n -> System.out.println(n));

        // 파라미터 1개, 명령문 2개 이상
        names.forEach(n -> {
            System.out.println("이름: " + n);
            System.out.println("길이: " + n.length());
        });

        // 파라미터 2개 이상, 명령문 1개
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.apply(5, 3));

        // 파라미터 2개 이상, 명령문 2개 이상
        BiConsumer<String, Integer> printer = (name, age) -> {
            System.out.println("이름: " + name);
            System.out.println("나이: " + age);
        };
        printer.accept("Alice", 25);
    }
}