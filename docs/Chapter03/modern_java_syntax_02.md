# 모던 자바 문법 다지기 (Java 8+)

자바 8 이상에서 추가된 **람다 표현식(Lambda Expression)**, **스트림 API(Stream API)**, **Optional**을 다뤄보자.

---

## 1. 람다 표현식 (Lambda Expression)

### ✅ 개념
- **익명 함수(Anonymous Function)** : 이름 없는 메서드처럼 동작
- **간결한 문법**으로 함수형 인터페이스(추상 메서드 1개 가진 인터페이스)를 구현
- 코드의 중복을 줄이고, 가독성을 높임

### 💡 예시
- 리스트를 순회하며 각 요소를 출력할 때, 반복문 대신 `forEach`와 람다 활용
- 두 숫자의 합 연산을 함수처럼 변수에 담아 전달 가능
- 이벤트 처리, 콜백, 정렬 기준 지정 등에 자주 사용됨

### 🧑‍💻 예제 코드 - [LambdaExample.java](../../src/chapter03/modern_java_syntax_02/LambdaExample.java)

---

## 2. 스트림 API (Stream API)

### ✅ 개념
- **데이터 처리(순차/병렬)**에 특화된 API
- 컬렉션을 **선언형 방식**으로 가공 가능
- 중간 연산(`filter`, `map`, `distinct`)과 최종 연산(`collect`, `forEach`)으로 구분

### 💡 예시
- 사용자 이름 목록에서 중복 제거 후 대문자로 변환해 출력
- 조건(`길이 > 3`)에 맞는 데이터만 걸러내기
- 결과를 `List`, `Set` 등 컬렉션으로 수집

### 🧑‍💻 예제 코드 - [StreamExample.java](../../src/chapter03/modern_java_syntax_02/StreamExample.java)

---

## 3. Optional

### ✅ 개념
- **null을 안전하게 다루기 위한 컨테이너 클래스**
- 값이 있을 수도, 없을 수도 있는 상황을 명확히 표현
- `NullPointerException`을 줄이고, 의도를 코드에 드러냄

### 💡 예시
- 사용자 조회 시 값이 없으면 `Optional.empty()` 반환
- 값이 있으면 처리, 없으면 기본값 제공
- `HashMap.get()` 같은 경우 `null` 대신 `Optional`을 반환하도록 설계 가능

### 🚨 주의할 점
- **필드 타입**으로 사용하지 말 것 (JPA 등 호환성 문제)
- **메서드 파라미터**로 받는 것도 안티패턴 (불필요하게 감싸기만 함)
- 주로 **메서드 반환 타입**에서 사용

### 🧑‍💻 예제 코드 - [OptionalExample.java](../../src/chapter03/modern_java_syntax_02/OptionalExample.java)

---

## 📌 정리
- **람다 표현식** → 함수형 스타일 문법, 가독성 향상
- **스트림 API** → 선언형 데이터 처리, 반복문/조건문을 대체
- **Optional** → null-safe 코드 작성, 반환 타입에서 특히 유용

👉 이 3가지는 모던 자바 실무 코드에서 거의 필수적으로 쓰이는 기능!!
