# Chapter 03 Review

---

## 1. IDE와 소스코드 편집기의 차이

### ✅ IDE (Integrated Development Environment)
- 통합 개발 환경
- 코드 작성, 빌드, 실행, 디버깅, 테스트까지 지원
- 자동 완성, 리팩토링, 디버거, 플러그인 등 풍부한 기능 제공
- 예: IntelliJ IDEA, Eclipse, NetBeans

### ✅ 소스코드 편집기 (Source Code Editor)
- 코드 작성 기능 중심
- 가벼우며, 빌드/실행은 외부 도구나 터미널에 의존
- 플러그인을 통해 IDE 수준 기능 확장 가능
- 예: VS Code, Sublime Text, Atom

---

## 2. 동일성과 동등성

### ✅ 동일성 (Identity)
- `==` 연산자로 비교
- 두 참조 변수가 **같은 객체 인스턴스**를 가리키는지 확인

### ✅ 동등성 (Equality)
- `.equals()` 메서드로 비교
- 두 객체가 **내용상으로 같은지**를 확인
- `equals()`를 재정의하면 값 비교를 원하는 방식으로 구현 가능

### ✅ hashCode()
- `equals()`와 함께 반드시 재정의 필요
- HashMap, HashSet 등에서 동등성 비교 시 중요

---

## 3. 객체지향 (Object-Oriented Programming)

### ✅ 핵심 특징 (4대 요소)
1. **추상화 (Abstraction)**
    - 공통된 속성과 동작을 추려내어 모델링
2. **캡슐화 (Encapsulation)**
    - 데이터와 메서드를 하나로 묶고, 외부에는 필요한 인터페이스만 노출
3. **상속 (Inheritance)**
    - 부모 클래스의 속성과 기능을 자식이 물려받아 확장 가능
4. **다형성 (Polymorphism)**
    - 부모 타입 참조로 자식 객체를 다룰 수 있어, 같은 코드로 다양한 동작 실행

---

## 4. ArrayList의 크기(size) 동작 원리

- **size**: 현재 저장된 요소 개수
- **capacity**: 내부 배열의 실제 크기
- 요소 추가 시:
    - capacity가 남아 있으면 size만 증가
    - capacity가 가득 차면, 새로운 더 큰 배열을 생성하여 기존 데이터를 복사 → capacity 확장
- 일반적으로 `기존 용량 * 1.5` 배로 늘어남
- `size()`는 요소 수, `capacity`는 내부 관리 크기임을 구분해야 함

---

## 5. 오버라이딩(Overriding) vs 오버로딩(Overloading)

### ✅ 오버라이딩
- 상속 관계에서 발생
- 부모 클래스의 메서드를 자식 클래스가 **재정의**하는 것
- 메서드 시그니처(이름, 파라미터)가 동일해야 함
- 런타임 다형성 구현

```java
class Parent {
    void hello() { System.out.println("Hello from Parent"); }
}

class Child extends Parent {
    @Override
    void hello() { System.out.println("Hello from Child"); }
}
```

### ✅ 오버로딩
- 같은 클래스 안에서 발생
- 메서드 이름은 같지만, 파라미터의 개수나 타입이 달라야 함
- 반환 타입만 다른 것은 불가능
- 컴파일 타임에 어떤 메서드가 호출될지 결정됨

```java
class Printer {
void print(String msg) { System.out.println(msg); }
void print(int num) { System.out.println(num); }
}
```

### 📌 정리
- IDE는 개발 전체 사이클을 지원, 편집기는 가벼운 코드 작성에 특화
- 동일성은 객체 참조 비교, 동등성은 값 비교
- 객체지향은 추상화·캡슐화·상속·다형성 4대 요소
- ArrayList의 size와 capacity는 다르며, capacity는 자동 확장됨
- 오버라이딩은 상속/재정의, 오버로딩은 같은 이름 메서드 다형성