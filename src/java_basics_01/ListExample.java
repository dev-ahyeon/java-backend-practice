// List 컬렉션 예제: 순서 유지, 중복 허용

package java_basics_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        // ArrayList: 조회 빠른 경우 적합
        List<String> users = new ArrayList<>();
        users.add("Alice");
        users.add("Bob");
        users.add("Charlie");
        users.add("Bob"); // 중복 허용

        System.out.println("사용자 목록 (ArrayList): " + users);
        System.out.println("2번 인덱스 사용자: " + users.get(2));

        // LinkedList: 삽입/삭제가 많은 경우 적합
        List<String> messages = new LinkedList<>();
        messages.add("안녕하세요");
        messages.add("반갑습니다");
        messages.add(1, "어서오세요"); // 중간 삽입

        System.out.println("메시지 목록 (LinkedList): " + messages);

        // 중복 확인
        System.out.println("Bob 등장 횟수: " + users.stream().filter(u -> u.equals("Bob")).count());
    }
}
