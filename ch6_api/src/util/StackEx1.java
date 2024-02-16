package util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*  java.util.List
 *  1. ArrayList
 *  2. LinkedList
 *  3. stack : LIFO(Last In First Out) - 수식계산, 수식괄호검사, undo/redo, 웹 브라우저 뒤로/앞으로
 *  4. Queue : FIFO(First In First Out) - 최근사용문서, 인쇄작업 대기목록, 버퍼
 */

public class StackEx1 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    Queue<String> queue = new LinkedList<>();

    // stack : push() / pop()
    stack.push("0");
    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.push("4");

    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }

    // offer(), poll()
    queue.offer("사과");
    queue.offer("딸기");
    queue.offer("배");
    queue.offer("바나나");
    queue.offer("수박");

    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
    }
  }
}
