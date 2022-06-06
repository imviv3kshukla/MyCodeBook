import java.io.*;
import java.util.*;
import java.util.stream.*;

class NextGreaterElement {

    public static int[] nextGreaterElement(Integer [] nums) {
	    int [] output = new int[nums.length];
	    Stack<Integer> stack = new Stack<Integer>();
	    for (int i = 0 ; i < nums.length; i++) {
            while(!stack.empty() && nums[i] > nums[stack.peek()]) {
                int pos = stack.pop();
                output[pos] = nums[i];
            }
	        stack.push(i);
        }
        while(!stack.empty()) output[stack.pop()] = -1;
        return output;
    }

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();                
        int n = Integer.parseInt(input);
        input = br.readLine();
        Integer[] nums = Stream.of(input.split(" ")).map(Integer::parseInt)
                                                .toArray(Integer[]::new);
 
        int output[] = nextGreaterElement(nums);
        for(int i : output) {
            System.out.print(i + " ");
        }

    }
}



// Stack class

// boolean	empty()   -     Tests if this stack is empty.

// E	peek()        -     Looks at the object at the top of this stack without removing it from the stack.

// E	pop()         -     Removes the object at the top of this stack and returns that object as the value of this function.

// E	push(E item)  -     Pushes an item onto the top of this stack.

// int	search(Object o) -  Returns the 1-based position where an object is on this stack.