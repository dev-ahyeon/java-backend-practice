// 애플리케이션 관점의 클라이언트
package chapter04.server_client_basics_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {
    public static void main(String[] args) throws Exception {
        // API 요청 URL
        URL url = new URL("http://localhost:9090/api/user");

        // 연결 생성
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // GET 요청

        // 응답 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("API 응답: " + line);
        }
        br.close();
    }
}
