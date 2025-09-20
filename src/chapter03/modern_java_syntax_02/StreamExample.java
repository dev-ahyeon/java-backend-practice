// 스트림 API 예제: 선언형 데이터 처리
package chapter03.modern_java_syntax_02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Alice");

        // forEach: 각 요소 출력
        names.stream()
                .forEach(n -> System.out.println("이름: " + n));

        // filter: 길이가 3 초과인 이름만
        names.stream()
                .filter(n -> n.length() > 3)
                .forEach(System.out::println);

        // distinct: 중복 제거
        names.stream()
                .distinct()
                .forEach(System.out::println);

        // map: 변환 (대문자)
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // collect: 결과 모으기
        List<String> result = names.stream()
                .filter(n -> n.startsWith("A"))
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("결과 리스트: " + result);
    }
}
