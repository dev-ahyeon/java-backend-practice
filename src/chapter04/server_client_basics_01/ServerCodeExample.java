// 서버 코드 변경 시 영향 범위를 확인하는 예제
package chapter04.server_client_basics_01;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ServerCodeExample {
    public static void main(String[] args) throws IOException {
        // 7070번 포트에서 실행
        HttpServer server = HttpServer.create(new InetSocketAddress(7070), 0);

        // 서버 응답 스펙 변경 (이메일 필드 추가됨)
        server.createContext("/api/user", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "{\"id\":1, \"name\":\"Alice\", \"email\":\"alice@test.com\"}";
                exchange.getResponseHeaders().add("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            }
        });

        System.out.println("서버 코드 변경됨: http://localhost:7070/api/user");
        server.start();
    }
}
