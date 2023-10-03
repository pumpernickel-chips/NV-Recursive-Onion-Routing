//Naomi Coakley & Victor Serra

import java.util.*;
public class OnionTester {
    public OnionTester(){
    }
    /**
     * <p>
     *     Creates an OnionTester Object, a Scanner Object, and a List. The OnionTester Object calls the oddBinaryList
     *     to method filter the users input.
     *     <p>
     *           Contains while loop that will iterate
     *           until the user inputs 'e', which will break out of the loop and stop the program.
     *           Within the while loop, is the try catch blocks, which if an InputMismatchException is thrown,
     *           a message will be displayed and you are able to try again.
     *      </p>
     *      <b>
     *      A OnionRouter Object is instantiated with the list List
     *      as its parameter.
     *      </b>
     * </p>
     */
    public static void main(String[] args) throws InputMismatchException {
        OnionTester test = new OnionTester();
        Scanner scnr = new Scanner(System.in);
        List<Integer> intList;
        System.out.println("Enter \"e\" to Exit");
        while(true) {
            try {
                System.out.print("Enter Value: ");
                intList = test.oddBinaryList(scnr);
                if(intList.contains(-1)) break;
                System.out.println();
                OnionRouter onion = new OnionRouter(intList);
                System.out.println("\nEnter 'e' to Exit");
            } catch (InputMismatchException e) {
                System.out.println("Input must be an odd number of binary digits.\nEnter \"e\" to Exit");
            }
        }
    }

    /**
     * <p>
     *      <b>
     *      Takes user input and converts input to an array in ArrayList that only allows
     *      binary values and an odd number of values.
     *      </b>
     * </p><p>
     *     Scans System.in for the user input and puts the values inputted
     *     into an array of Chars called testInput. Goes through each entry in testInput and checks to see if
     *     the value is equal to either 'e' or the values are in binary. If the values are in binary, add its
     *     value to the ArrayList, list, or if 'e' add -1 to quit the program, else throw an exception. Finally,
     *     checks the number of inputs and makes sure that it is an odd number of inputs, else throw
     *     InputMismatchException. return the ArrayList list.
     *
     * </p>
     * @param s the scanner which scans system.in
     * @return returns the list of binary inputs
     * @throws InputMismatchException when the number of inputs are odd or if the
     * values are not in binary.
     */
    public List<Integer> oddBinaryList(Scanner s) throws InputMismatchException {
        List<Integer> list = new ArrayList<Integer>();
            char[] testInput = (s.nextLine()).toCharArray();
            for(char c : testInput){
                if(c=='e'){
                    return Collections.singletonList(-1);
                }else if(c=='0'){
                    list.add(0);
                }else if(c=='1'){
                    list.add(1);
                }else{
                    throw new InputMismatchException();
                }
            }
        if(list.size()%2==0) throw new InputMismatchException();
        return list;
    }
}
