package generics;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Car {

  private String company;
  // AllArgsConstructor로 대체
  //   public Car(String company){
  //     this.company = company;
  //   }
}
