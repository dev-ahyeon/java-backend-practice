// 클라이언트 코드 변경 시 영향 범위를 확인하는 예제
package chapter04.server_client_basics_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientCodeExample {
    public static void main(String[] args) throws Exception {
        // 서버 요청
        URL url = new URL("http://localhost:7070/api/user");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // 응답 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();

        String response = sb.toString();

        // 서버가 이메일을 추가했더라도, 클라이언트는 name만 사용한다고 가정
        if (response.contains("Alice")) {
            System.out.println("사용자 이름 확인 완료!");
        }
    }
}
