// 간단한 캐시 예제 (DB 접근 대신 캐시 사용)
package chapter04.server_client_basics_01;

import java.util.HashMap;
import java.util.Map;

public class CacheExample {
    // 캐시 저장소 (key: String, value: String)
    private static final Map<String, String> cache = new HashMap<>();

    // DB 조회를 흉내내는 메서드
    private static String getFromDatabase(String key) {
        System.out.println("DB에서 데이터 조회: " + key);
        return "DB_VALUE_FOR_" + key;
    }

    // 캐시 우선 조회
    private static String getData(String key) {
        if (cache.containsKey(key)) {
            System.out.println("캐시 히트! " + key);
            return cache.get(key); // 캐시에서 바로 반환
        } else {
            String value = getFromDatabase(key); // DB 조회
            cache.put(key, value); // 캐시에 저장
            return value;
        }
    }

    public static void main(String[] args) {
        // 첫 번째 호출 → DB 조회 발생
        System.out.println(getData("user:1"));

        // 두 번째 호출 → 캐시에서 응답
        System.out.println(getData("user:1"));

        // 다른 키 조회 → DB 접근
        System.out.println(getData("user:2"));

        // 다시 같은 키 → 캐시 히트
        System.out.println(getData("user:2"));
    }
}
