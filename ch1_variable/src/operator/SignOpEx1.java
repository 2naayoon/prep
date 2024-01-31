package operator;

/*  연산자
 *  단항 연산자 : 부호 - 양수, 음수, 증감연산자(++, --)
 *  관계 연산자 : 
 *  논리 연산자 :
 *  산술 연산자 : 
*/

public class SignOpEx1 {
    public static void main(String[] args) {
        int x = -100;

        int result1 = +x;
        int result2 = -x;
        System.out.printf("result1 = %d, result2 = %d", result1, result2);
}    
}
