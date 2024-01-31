package ch1;

public class SpecialChar {
    public static void main(String[] args) {
        // Tab = \t
        // Enter = \n
        // \ + 특정 기호, 출력할 기호, ...
        System.out.println("성명    주소    전화번호");
        System.out.println("성명\t주소\t전화번호");
        System.out.println("'Hello'");    // 'Hello' 출력

        // * System.out.println(""Hello"");    // "" 사용 시 \ 이용

        System.out.println("\"Hello\"");    // "Hello" 출력
        System.out.println("\'Hello\'");    // 'Hello' 출력
        System.out.println("재미있는\\자바");    // 재미있는\자바 출력
        System.out.println("\n");
        System.out.println("escape 문자");
        System.out.print("테스트\n");
        System.out.print("테스트");

        // 화면 출력
        // System.out.print(); : Enter 제외
        // System.out.println(); : Enter 한 번 포함
        // System.out.printf(); Enter 제외
    }
}
