package MyPack;

import java.util.Scanner;

public class PopPush {

	public static void main(String[] args) {

		
		Scanner scanner = new Scanner(System.in);// Scanner input
		System.out.println("Enter the Size of the stack");
		int size = scanner.nextInt();
		
		FixedStack fixedStack = new FixedStack(size); // Creating new object
		VariableStack stack = new VariableStack(size);
		
		while (true) { // While Loop 
			System.out.println("Enter F to implement FixedStack and V to implement VariableStack");
			char ch = scanner.next().toCharArray()[0];
			switch (ch) {
			case 'F':
				while (true) {
					System.out.println("Enter 1 to push"); // Making choices 
					System.out.println("Enter 2 to pop");
					System.out.println("Enter 3 to close");
					System.out.println("Please Enter your choice");
					int choice = scanner.nextInt();

					switch (choice) { //Switch case 
					case 1:
						System.out.println("Enter an integer to push into stack");
						int push = scanner.nextInt();
						fixedStack.push(push); // Pushing element in the stack
						break;
					case 2:
						int item = fixedStack.pop();// Deleting element from the stack.
						System.out.println("Popped element is :" + item);
						break;

					case 3:
						scanner.close(); // Closing scanner input 

					}
				}
			case 'V':
				while (true) {
					System.out.println("Enter 1 to push");
					System.out.println("Enter 2 to pop");
					System.out.println("Please Enter your choice");
					int choice = scanner.nextInt();

					switch (choice) { //Switch case
					case 1:
						System.out.println("Enter an integer to push into stack");
						int push = scanner.nextInt();
						stack.push(push);

						break;
					case 2:
						int item = stack.pop();
						System.out.println("Popped elenment is :" + item);
						break;

					case 3:
						scanner.close();

					}
				}
			default:
				scanner.close();

			}
		}
	}

}

interface Stack {

	void push(int i);

	int pop();
}

class FixedStack implements Stack { // Creating Class fixedstack which implements stack

	int top = -1;
	static int size;

	int[] stackItems;

	public FixedStack(int size) { // Initializing size of the stack
		FixedStack.size = size;
		stackItems = new int[size];
	}

	@Override
	public void push(int i) { // Push method
		if (top < size) {

			top = top + 1; // Inseting element at the top . 
			stackItems[top] = i;
			System.out.println("Top :" +" "+ top);
			System.out.println("Size:"+ " " + size);
			System.out.println("Element saved:" + stackItems[top] + "\n");
		} else {
			System.out.println("Stack is full." + "\n");

		}

	}

	@Override
	public int pop() { //Pop Method
	    int item;
		if (top < 0) {
			System.out.println("There is no item to be popped out" + "\n");
			return 0;

		} else {

			item = stackItems[top];
			top = top - 1; //Deleting element from the top 
			return item;
		}

	}

}

class VariableStack implements Stack { //CReating class VariableStack which implements Stack.

	int top = -1; // Inserting element the stack 
	static int size;

	int[] stackItems;

	public VariableStack(int size) {  //Method
		this.size = size;
		stackItems = new int[size];
	}

	@Override
	public void push(int i) { // Push Method 

		if (top < size) {

			top = top + 1;
			stackItems[top] = i;
			System.out.println("Top:" + " "+ top);
			System.out.println("Size:" + " "+ size);
			System.out.println("Element saved:" + stackItems[top] + "\n");
		} else if (top >= size) {

			stackItems = new int[size * 2];
			top = top + 1;
			stackItems[top] = i;
			System.out.println("Top:" + " " + top);
			System.out.println("Size:" + " " + size);
			System.out.println("Element saved: " + stackItems[top] + "\n");

		}

	}

	@Override
	public int pop() { //Pop method
		// TODO Auto-generated method stub

		int item;
		if (top < 0) {
			System.out.println("Stack is empty." + "\n");
			return 0;

		} else {

			item = stackItems[top];
			top = top - 1;
			return item;
		}

	}
}