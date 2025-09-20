# 서버와 클라이언트 이해하기

네트워크와 애플리케이션 전반에서 **서버(Server)**와 **클라이언트(Client)**는 기본 개념이다. 이 장에서는 네트워크 관점, 애플리케이션 관점, 소스코드 관점에서 서버와 클라이언트를 다룬다. 또한 **로드 밸런싱**, **캐시** 개념도 함께 살펴보자.

---

## 1. 네트워크에서의 서버와 클라이언트

### ✅ 개념
- **서버(Server)** : 서비스를 제공하는 주체 (예: 웹 서버, DB 서버)
- **클라이언트(Client)** : 서비스를 요청하는 주체 (예: 웹 브라우저, 모바일 앱)
- 네트워크 통신은 기본적으로 클라이언트 요청 → 서버 응답 흐름으로 이루어짐

### 💡 예시
- 사용자가 웹 브라우저(클라이언트)에서 `www.example.com`을 요청하면, 웹 서버가 HTML을 응답
- 모바일 앱이 API 서버에 JSON 요청 → 서버가 데이터를 반환

### 🧑‍💻 예제 코드 1 - [SimpleHttpServer.java](../../src/chapter04/server_client_basics_01/SimpleHttpServer.java)
### 🧑‍💻 예제 코드 2 - [SimpleHttpClient.java](../../src/chapter04/server_client_basics_01/SimpleHttpClient.java)

---

## 1-1. 로드 밸런싱 (Load Balancing)

### ✅ 개념
- 여러 서버에 요청을 분산시켜 처리 성능과 안정성을 높이는 기술
- 단일 서버에 과부하가 걸리지 않도록 함
- 보통 L4/L7 로드 밸런서를 사용

### 💡 예시
- 대형 쇼핑몰은 웹 서버를 여러 대 두고, 로드 밸런서가 사용자 요청을 나눠줌
- 한 서버가 다운되면 다른 서버가 자동으로 요청을 처리하여 서비스 지속

### 🧑‍💻 예제 코드 - [LoadBalancerExample.java](../../src/chapter04/server_client_basics_01/LoadBalancerExample.java)

---

## 1-2. 캐시 (Cache)

### ✅ 개념
- 자주 사용하는 데이터를 빠르게 제공하기 위해 임시 저장소에 보관
- 네트워크, 브라우저, 애플리케이션, DB 등 다양한 계층에서 활용 가능

### 💡 예시
- 브라우저 캐시: 동일한 이미지 파일을 서버에 재요청하지 않고 캐시에서 바로 로드
- 서버 캐시: Redis, Memcached 같은 인메모리 DB를 활용하여 DB 부하 감소

### 🧑‍💻 예제 코드 - [CacheExample.java](../../src/chapter04/server_client_basics_01/CacheExample.java)

---

## 4. 애플리케이션에서의 서버와 클라이언트

### ✅ 개념
- 애플리케이션 아키텍처에서도 서버/클라이언트 구조가 존재
- 서버는 비즈니스 로직과 데이터를 처리하고, 클라이언트는 UI와 사용자 입력 담당

### 💡 예시
- 웹 애플리케이션에서 브라우저(클라이언트)가 API 호출
- API 서버(서버)가 DB와 연동하여 결과를 반환

### 🧑‍💻 예제 코드 1 - [ApiServer.java](../../src/chapter04/server_client_basics_01/ApiServer.java)
### 🧑‍💻 예제 코드 2 - [ApiClient.java](../../src/chapter04/server_client_basics_01/ApiClient.java)

---

## 5. 소스코드에서의 서버와 클라이언트

### ✅ 개념
- 실제 코드 구현에서도 서버/클라이언트 역할을 구분해야 함
- 서버 코드가 바뀌는 경우와 클라이언트 코드가 바뀌는 경우의 영향 범위가 다름

### 💡 예시
- **클라이언트 코드 변경**: 서버 API는 그대로 두고, 화면(UI)이나 요청 방식을 바꾸는 경우 → 서버 영향 없음
- **서버 코드 변경**: API의 응답 스펙이 바뀌면 클라이언트 코드도 반드시 수정 필요

### 🧑‍💻 예제 코드 1 - [ServerCodeExample.java](../../src/chapter04/server_client_basics_01/ServerCodeExample.java)
### 🧑‍💻 예제 코드 2 - [ClientCodeExample.java](../../src/chapter04/server_client_basics_01/ClientCodeExample.java)

---

## 📌 정리
- **네트워크**: 서버는 서비스 제공자, 클라이언트는 요청자
- **로드 밸런싱**: 요청을 분산해 성능과 안정성 확보
- **캐시**: 반복 요청을 줄이고 성능 향상
- **애플리케이션**: 서버는 데이터·로직, 클라이언트는 UI·입력
- **소스코드**: 서버 변경은 클라이언트에 영향, 클라이언트 변경은 서버에 영향 없음
