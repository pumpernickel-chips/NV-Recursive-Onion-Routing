/*
 * CS208 P2
 * Naomi Coakley & Victor Serra
 */
import java.util.*;
/**
 * <p>
 *     Tester class with two methods ({@link #main} and {@link #oddBinaryList}) for testing the functionality of {@link OnionRouter}.
 *     </p>
 * @author Naomi Coakley
 * @author Victor Serra
 */
public class OnionTester {
    /**
     * Default zero args constructor
     */
    public OnionTester(){}
    /**
     * <p>
     *     Creates an {@code OnionTester}, a {@code Scanner}, and a {@code List}. The {@code OnionTester} calls
     *     {@link #oddBinaryList} to methodically filter the user's input.
     * <p>
     *     Contains a {@code while} loop that will iterate until the user enters 'e', which will break out of the loop
     *     and stop the program. Within the {@code while} loop is a {@code try-catch} statement. If an
     *     {@link InputMismatchException} is thrown, a message will be displayed and the user can try again.
     * <p>
     *     If no exception is thrown, an {@link OnionRouter} is instantiated with the {@code List} as its parameter.
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
     *      Converts user input to a {@code List} that only allows an odd number of binary digits.
     * </p><p>
     *     Converts the input stored in the given {@code Scanner} to a {@code charArray}. A {@code for} loop checks that
     *     each value is equal to either 'e' or a binary digit. If the value is a binary digit, it wil be added to a
     *     {@code List}, if 'e' it will return a {@code List} containing only '-1' to quit the program, or else throw an
     *     {@link InputMismatchException}. Finally, it checks the number of inputs to verify that it is an odd
     *     number of values before the method returns the {@code List}, or else throw an {@link InputMismatchException}.
     *
     * </p>
     * @param s {@code Scanner} which will have its input converted
     * @return {@code List} of binary digits
     * @throws InputMismatchException if the number of elements are odd or if the values are not in binary.
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
