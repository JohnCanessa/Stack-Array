

public class Solution {

	/*
	 * 
	 */
	static class MyStack<T> {
		
		// **** constants ****
		private static	final int	MIN_STACK_SIZE		= 4;
		private static 	final int	GROW_SHRINK_FACTOR	= 2;
		
		// **** members ****
		public int	size	= MIN_STACK_SIZE;
		public T	arr[]	= null;
		public int	top		= -1;
		
		/*
		 * Constructor.
		 */
		@SuppressWarnings("unchecked")
		public MyStack() {
			this.arr = (T[])new Object[size];
		}
		
		/*
		 * Push value to the top of the stack.
		 */
		public void push(T val) {
			
			// **** check if stack is full ****
			if (isFull()) {
								
				// **** grow the stack ****
//				return;
				grow();
			}

			// **** push element into stack ****
			this.arr[++top] = val;
		}
				
		/*
		 * Pop top value from the stack.
		 */
		public T pop() {
			
			// **** check if stack is empty ****
			if (isEmpty()) {
				System.out.println("pop <<< stack is empty");
				return null;
			}
			
			// **** ****
			T val = arr[top--];
			
			// **** check and if needed shring the stack ****
			shrink();
			
			// **** ****
			return (T)val;
		}
		
		/*
		 * Peek the next value in the stack
		 */
		public T peek() {
			
			// **** check is stack is empty ****
			if (isEmpty())
				return null;
			
			// **** ****
			return (T)arr[top];
		}
		
		/*
		 * Check if the stack is empty.
		 */
		public Boolean isEmpty() {
			if (this.top < 0)
				return true;
			else
				return false;
		}
		
		/*
		 * Check if the stack is full.
		 */
		public Boolean isFull() {
			if (top >= (size - 1))
				return true;
			else
				return false;
		}
				
		/*
		 * Grow the stack by doubling the capacity.
		 * The stack should be full at this time.
		 */
		private void grow() {
			
			// ???? ????
			System.out.println("grow <<< growing the stack...");

			// **** compute the new array size ****
			int prevSize 	= size;
			int newSize 	= size * GROW_SHRINK_FACTOR;
			
			// **** allocate the new array ****
			@SuppressWarnings("unchecked")
			T newArr[] = (T[])new Object[newSize];			
			
			// **** copy the values from the previous to the new array ****
			for (int i = 0; i < prevSize; i++)
				newArr[i] = arr[i];
			
			// **** update the members of the stack ****
			this.arr 	= newArr;
			this.size	= newSize;
		}
		
		/*
		 * Shrink the stack in half (if needed).
		 */
		private void shrink() {

			// **** check if we do NOT need to shrink the stack ****
			if ((size == MIN_STACK_SIZE) || (top >= (size / GROW_SHRINK_FACTOR)))
				return;
			
			// ???? ????
			System.out.println("shrink <<< shrinking the stack...");
			
			// **** compute the new array size ****
			int newSize 	= size / GROW_SHRINK_FACTOR;

			// **** allocate the new array ****
			@SuppressWarnings("unchecked")
			T newArr[] = (T[])new Object[newSize];			

			// **** copy the values from the previous to the new array ****
			for (int i = 0; i < newSize; i++)
				newArr[i] = arr[i];
			
			// **** update the members of the stack ****
			this.arr 	= newArr;
			this.size 	= newSize;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			
			// **** check if the stack is empty ****
			if (isEmpty())
				return "[ ] size: " + size + " top: " + top;
			
			// **** ****
			StringBuilder sb = new StringBuilder();
			
			// **** to enclose elements ****
			sb.append("[ ");
			
			// **** build the string with elements in the stack ****
			for (int i = top; i >= 0; i--) {
				
				// **** ****
				sb.append(arr[i].toString());
				
				// **** ****
				if (i > 0)
					sb.append(" -> ");
				else
					sb.append(" ] size: " + size + " top: " + top);
			}
			
			// **** return a string with the values in the stack ****
			return sb.toString();
		}
	}
	
	/*
	 * Test scaffolding.
	 */
	public static void main(String[] args) {

		// **** instantiate our stack ****
		MyStack<Integer> stack = new MyStack<Integer>();

		// **** loop pushing some values into our stack ****
		for (int i = 0; i < 7; i++) {
			
			// **** push this value ****
			stack.push(i * 2);
			
			// **** peek the top element ****
			System.out.println("main <<< peek: " + stack.peek());
		}
		
		// **** display the stack ****
		System.out.println("main <<< stack: " + stack.toString());
		System.out.println();

		// **** loop poping values from the stack ****
		while (!stack.isEmpty()) {
			
			// **** peek the top element ****
			System.out.println("main <<< peek: " + stack.peek());
			
			// **** pop the top element ****
			Integer val = stack.pop();
			System.out.println("main <<< val: " + val);
		}
		
		// **** display the stack ****
		System.out.println("main <<< stack: " + stack.toString());
		System.out.println();
	}

}
