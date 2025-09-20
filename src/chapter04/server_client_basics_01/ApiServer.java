// 애플리케이션 관점의 서버
package chapter04.server_client_basics_01;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ApiServer {
    public static void main(String[] args) throws IOException {
        // 9090번 포트에서 API 서버 실행
        HttpServer server = HttpServer.create(new InetSocketAddress(9090), 0);

        // "/api/user" 경로 처리
        server.createContext("/api/user", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // JSON 응답 (사용자 정보)
                String response = "{\"id\":1, \"name\":\"Alice\"}";
                exchange.getResponseHeaders().add("Content-Type", "application/json"); // JSON 타입 지정
                exchange.sendResponseHeaders(200, response.getBytes().length); // 응답 코드 + 길이
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes()); // 응답 전송
                }
            }
        });

        System.out.println("API 서버 시작: http://localhost:9000/api/user");
        server.start();
    }
}
