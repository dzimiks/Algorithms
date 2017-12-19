package dataStructures;

import dataStructures.stacks.LinkedStack;
import dataStructures.stacks.StackArray;

public class MainStack {

	public static void main(String[] args) {

		StackArray<Integer> stack = new StackArray<>(5);
		LinkedStack<String> linkedStack = new LinkedStack<>();
		
		stack.push(23);
		stack.push(53);
		stack.push(12);
		stack.push(22);
		stack.push(15);

		System.out.println(stack);
		stack.pop();
		System.out.println(stack.pop());
		
//		linkedStack.push("one");
//		linkedStack.push("two");
//		linkedStack.push("three");
//		
//		System.out.println(linkedStack);
//		System.out.println(linkedStack.peek());
	}
}