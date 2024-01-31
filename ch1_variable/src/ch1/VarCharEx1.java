package ch1;

public class VarCharEx1 {
    public static void main(String[] args) {
        // 2. 문자형 - char(2byte)
        //            '' 사용
        //    문자(한 글자) vs 문자열(한 글자 이상)
        //    =    ''     vs     ""
        // 문자는 코드값(ASCII, UTF-8)이 정의 되어 있다
        //   ASCII : A = 65 , B = 66 , ... / a = 97 , b = 98 , ... 
        //  유니코드 : 가 = 44032
        //   UTF-8 : a = \u0041
        char name = 'J';
        String name2 = "Ja";
        char var1 = 65;
        char var2 = 44032;
        char var3 = '\u0041';
    
        System.out.println("나의 이름은 " + name);
        System.out.println("나의 이름은 " + name2);
        System.out.println("var1 = " + var1);
        System.out.println("var2 = " + var2);
        System.out.println("var3 = " + var3);
    }
    
}
