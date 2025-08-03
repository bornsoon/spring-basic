package hello.core.singleton;

public class StatefulService {

    private int price;  // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;  // 여기가 문제!
    }
 
    public int getPrice() {
        return price;
    }


    /* Spring은 무상태(Stateless)로 설계해야 한다!

     // private int price <- 공유하는 변수를 없애고,

        public int order(String name, int price) {
            System.out.println("name = " + name + " price = " + price);
            this.price = price;  // 여기가 문제!
        return price;

      // public int getPrice()  <- 없애기
     */
    }

}
