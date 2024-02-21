package generics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product<T, M> {

  private T kind;
  private M model;
}
