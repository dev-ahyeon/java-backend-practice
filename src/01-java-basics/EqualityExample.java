// 동일성과 동등성 예제: == vs equals, hashCode()

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // 동등성 비교를 위해 equals와 hashCode 오버라이딩
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 동일성
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id); // id 같으면 동등
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + name + "'}";
    }
}

public class EqualityExample {
    public static void main(String[] args) {
        User u1 = new User("100", "Alice");
        User u2 = new User("100", "Alice");
        User u3 = u1;

        // 동일성 비교 (==)
        System.out.println("u1 == u2 ? " + (u1 == u2)); // false (다른 객체)
        System.out.println("u1 == u3 ? " + (u1 == u3)); // true (같은 객체 참조)

        // 동등성 비교 (equals)
        System.out.println("u1.equals(u2) ? " + u1.equals(u2)); // true (id 같음)

        // HashSet 테스트
        Set<User> set = new HashSet<>();
        set.add(u1);
        set.add(u2); // id 같으므로 중복 제거됨
        System.out.println("HashSet 크기: " + set.size()); // 1
        System.out.println("HashSet 내용: " + set);
    }
}
