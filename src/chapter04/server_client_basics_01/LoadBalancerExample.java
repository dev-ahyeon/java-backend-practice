// 간단한 로드 밸런싱 시뮬레이션
package chapter04.server_client_basics_01;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadBalancerExample {
    public static void main(String[] args) {
        // 서버 3대라고 가정
        String[] servers = {"Server-1", "Server-2", "Server-3"};

        // 스레드 풀 (동시에 5개의 요청 처리 가능)
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Random random = new Random();

        // 요청 10개 발생
        for (int i = 1; i <= 10; i++) {
            int requestId = i;
            executor.submit(() -> {
                // 랜덤하게 서버 선택 (라운드 로빈 같은 다른 알고리즘도 가능)
                String server = servers[random.nextInt(servers.length)];
                System.out.println("요청 " + requestId + " → " + server + " 처리 중...");
                try {
                    Thread.sleep(500); // 처리 시간 시뮬레이션
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("요청 " + requestId + " → " + server + " 처리 완료!");
            });
        }

        executor.shutdown();
    }
}
