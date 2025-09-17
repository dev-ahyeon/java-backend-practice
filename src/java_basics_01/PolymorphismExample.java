// 다형성 예제: 상속 + 인터페이스 활용

package java_basics_01;

// 추상 클래스
abstract class Payment {
    abstract void pay(int amount);
}

// 구체 클래스들
class KakaoPay extends Payment {
    @Override
    void pay(int amount) {
        System.out.println("카카오페이로 " + amount + "원 결제 완료");
    }
}

class CreditCardPay extends Payment {
    @Override
    void pay(int amount) {
        System.out.println("신용카드로 " + amount + "원 결제 완료");
    }
}

class PaypalPay extends Payment {
    @Override
    void pay(int amount) {
        System.out.println("PayPal로 " + amount + "원 결제 완료");
    }
}

// 인터페이스
interface Refundable {
    void refund(int amount);
}

// 다중 구현
class RefundableKakao extends KakaoPay implements Refundable {
    @Override
    public void refund(int amount) {
        System.out.println("카카오페이로 " + amount + "원 환불 완료");
    }
}

class RefundableCreditCard extends CreditCardPay implements Refundable {
    @Override
    public void refund(int amount) {
        System.out.println("신용카드로 " + amount + "원 환불 완료");
    }
}

class RefundablePaypal extends CreditCardPay implements Refundable {
    @Override
    public void refund(int amount) {
        System.out.println("Paypal로 " + amount + "원 환불 완료");
    }
}

public class PolymorphismExample {

    public static void main(String[] args) {
        // 부모 타입으로 다양한 결제 방식 다루기
        Payment p1 = new KakaoPay();
        Payment p2 = new CreditCardPay();
        Payment p3 = new PaypalPay();

        p1.pay(10000);
        p2.pay(20000);
        p3.pay(30000);

        System.out.println();

        // 인터페이스 타입 활용
        Refundable r1 = new RefundableKakao();
        Refundable r2 = new RefundableCreditCard();
        Refundable r3 = new RefundablePaypal();

        r1.refund(5000);
        r2.refund(10000);
        r3.refund(15000);
    }
}