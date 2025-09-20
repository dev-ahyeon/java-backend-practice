// 간단한 HTTP 클라이언트 예제
package chapter04.server_client_basics_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHttpClient {
    public static void main(String[] args) throws Exception {
        // 요청 보낼 URL 지정
        URL url = new URL("http://localhost:9090/hello");

        // 연결 열기
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // GET 요청

        // 서버 응답 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("서버 응답: " + line);
        }
        br.close();
    }
}
