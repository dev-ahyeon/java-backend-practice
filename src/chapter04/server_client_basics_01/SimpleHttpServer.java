// 간단한 HTTP 서버 예제
package chapter04.server_client_basics_01;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        // HTTP 서버 생성 (포트 9090에서 실행)
        HttpServer server = HttpServer.create(new InetSocketAddress(9090), 0);

        // "/hello" 경로로 들어온 요청을 처리하는 핸들러 등록
        server.createContext("/hello", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "Hello, Client!"; // 응답 메시지
                exchange.sendResponseHeaders(200, response.getBytes().length); // 200 OK + 길이 지정
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes()); // 클라이언트에게 응답 전송
                }
            }
        });

        System.out.println("HTTP 서버 시작: http://localhost:9090/hello");
        server.start(); // 서버 시작
    }
}
