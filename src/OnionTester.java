import java.io.IOException;
import java.util.*;

/*
In this assignment, you will write a program that has the same idea, but after peeling all
layers to get to the core, it puts the layers back with a different value; example: turning
a white onion into a red onion.

    * Write a recursive class that its constructor takes an odd number of binary digits as
    its field.

    * The constructor of this class calls the recursive method. This recursive method
    creates an object of the same class with smaller binary number by taking the two
    outer digits and passing the binary number that is left.

    * Once no more object can be created  (the base case) the binary digit is flipped.
    Remember in the example white turned into red? With this, I am sure you know what
    flip does.

    * When the process is done, the flipped version of the original binary number is
    returned.

The tester should allow the user to repeatedly (but not forever) enter a binary number
with odd number of digits and print out the returned number.

You may NOT use String for the binary number.

Be sure to fully test your code for incorrect input, etc.
 */
public class OnionTester {
    public OnionTester(){
    }
    public static void main(String[] args) throws IOException {
        OnionTester test = new OnionTester();
        Scanner scnr = new Scanner(System.in);
        List<Integer> intList = new ArrayList<Integer>();
        boolean waitingForInput = true;
        while(waitingForInput) {
            try {
                System.out.print("Enter Value: ");
                intList = test.oddBinaryList(scnr);/*new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,1,1))*/ //Creates original Integer Binary List
                waitingForInput = false;
                OnionRouter testOnion = new OnionRouter(intList);
            } catch (IOException e) {
                System.out.println("Input must be an odd number of binary digits.");
                waitingForInput = true;
            }

        }

        /*System.out.println(intList);

        intList = testOnion.flip(intList);
        System.out.println(intList);*/


    }

    public List<Integer> oddBinaryList(Scanner s) throws IOException {
        List<Integer> list = new ArrayList<Integer>();
            char[] testInput = ("" + s.nextLine()).toCharArray();
            for(char c : testInput){
                if(c=='0'){
                    list.add(0);
                }else if(c=='1'){
                    list.add(1);
                }else{
                    throw new IOException();
                }
            }
            if(list.size()%2==0) throw new IOException();
            //System.out.println(testInput);
        return list;
    }
}
