package ch1;

/*  변수 : 하나의 값을 저장하기 위한 공간
 *         타입지정 - 정수형, 문자형, 논리형, 실수형 
 *         값은 변할 수 있다
 *         1 byte = 8 bit = 256개 (0~255 표현) = -128 ~ 127 (음수 ~ 양수)
 *        
 *  상수 : 값을 한 번만 저장하는 공간
 *         final int WIDTH = 20;
 */

public class VarFloatEx1 {
    public static void main(String[] args) {
        // 4. 실수형 - float(4byte), double(8byte)
        float scorel = 90.17F;   // F, f 붙임
        double score2 = 98.5D;   // D, d 붙임

        System.out.println("score1 = " + scorel);
        System.out.println("score2 = " + score2);

        float var3 = 0.1234567890123456789f;
        double var4 = 0.1234567890123456789d;
        System.out.println("var3 = " + var3);
        System.out.println("var4 = " + var4);
    }
}
