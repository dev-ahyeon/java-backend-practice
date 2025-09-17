# Java 기본 문법 점검하기

자바 기본기를 점검하면서 핵심 개념을 짚고 넘어가자... 특히 **다형성(상속과 인터페이스)**, **컬렉션(List)**, **동일성과 동등성**을 중심으로 다뤄보자.

---

## 1. 다형성: 상속과 인터페이스

### ✅ 개념
- **상속(Inheritance)** : 부모 클래스의 기능을 자식이 물려받아 확장/재정의
- **인터페이스(Interface)** : 규격/계약만 정의, 다중 구현 가능
- **다형성(Polymorphism)** : 부모 타입 참조에 자식 객체를 담아 다양한 동작 실행

### 💡 예시
- 결제 시스템에서 `Payment` 인터페이스를 정의하고, `KakaoPay`, `CreditCardPay`, `PaypalPay` 클래스가 이를 구현
- 클라이언트는 `Payment` 타입만 알고 있어도 다양한 결제 수단 처리 가능
- 새로운 결제 방식이 추가되더라도 기존 코드 변경은 최소화

### 🧑‍💻 예제 코드 - [PolymorphismExample.java](../src/java_basics_01/PolymorphismExample.java)

---

## 2. 컬렉션: List

### ✅ 개념
- **List**는 순서(index) 유지, 중복 허용
- 대표 구현체 : **ArrayList**(조회 빠름), **LinkedList**(삽입/삭제 빠름)
- **Generics**를 통해 타입 안정성 확보

### 💡 예시
- 사용자 목록을 저장할 때 `ArrayList` 사용 → 인덱스로 빠르게 접근 가능
- 채팅 메시지를 순서대로 보관할 때 `List` 사용 → 입력 순서가 유지됨
- 삽입/삭제가 잦은 큐 같은 구조에는 `LinkedList`가 유리

### 🧑‍💻 예제 코드 - [ListExample.java](../src/java_basics_01/ListExample.java)

---

## 3. 동일성과 동등성

### ✅ 개념
- **동일성(Identity)** : `==` → 같은 객체 인스턴스인지 비교
- **동등성(Equality)** : `.equals()` → 값이 같은지 비교
- **hashCode()** : equals()와 함께 오버라이딩 필요 (HashMap, HashSet 등에서 중요)

### 💡 예시
- 두 개의 `User` 객체가 있을 때, `==`는 false지만 `equals()`는 true일 수 있음 (내용은 같지만 다른 객체)
- `HashSet`에 `User` 객체를 넣을 때 `equals()`와 `hashCode()`를 올바르게 구현하지 않으면 중복된 데이터가 걸러지지 않을 수 있음

### 🧑‍💻 예제 코드
- [EqualityExample.java](../src/java_basics_01/EqualityExample.java)
