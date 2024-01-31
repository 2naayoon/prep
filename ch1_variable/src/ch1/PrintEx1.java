package ch1;

public class PrintEx1 {
    public static void main(String[] args) {
        // 화면 출력
        int var1 = 35, var2 = 25;
        boolean flag = true;
        System.out.println("var1 = " + var1 + ", " + var2 + ", " + flag);    // 35, 25, true
        
        // printf 지시자
        // %d : 10진 정수 형태로 출력
        // %b : boolean 형태로 출력
        // %c : char 로 출력
        // %s : 문자열(String) 출력
        // %f : 부동소수점(float, double) 출력
        // 숫자 : 총 자릿수

        System.out.printf("var1 = %5d, var2 = %05d, flag = %b\n", var1, var2, flag);
        System.out.println("Hello");

        float f1 = 3.141592f;
        double d1 = 31.41592d;
        System.out.printf("f1 = %.5f\n", f1);    // .5 : 소수점 다섯번째까지
        System.out.printf("d1 = %5.3f\n", d1);   // 5.3 : 총 다섯자리, 소수점은 셋째까지
    }
}
