package ch1;

/*  인터페이스
 *  완전 추상화
 *  추상 메소드 - public (default)
 *      interface - implements : 강제 Override (템플릿 만들어서 내리는 것)
 *                               반드시 interface 리턴타입, 메소드 써라, ...
 *  객체 생성 불가
 * 
 */

public interface Tv {
    void powerOn();

    void PowerOff();

    void volumeUp();

    void volumeDown();
}
