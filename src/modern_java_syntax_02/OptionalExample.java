// Optional 예제: null-safe 코드 작성
package modern_java_syntax_02;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Alice");
        Optional<String> empty = Optional.empty();

        // 값이 있으면 출력
        name.ifPresent(System.out::println);

        // 값이 없으면 기본값 제공
        System.out.println(empty.orElse("기본 이름"));

        // 값이 없으면 예외 던지기
        System.out.println(name.orElseThrow(() -> new RuntimeException("이름 없음")));

        // map: 값이 있으면 변환
        Optional<Integer> nameLength = name.map(String::length);
        System.out.println("이름 길이: " + nameLength.orElse(0));
    }
}