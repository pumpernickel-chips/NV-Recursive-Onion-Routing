import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OnionTester {
    public OnionTester(){
    }
    public static void main(String[] args){
        OnionRouter testOnion = new OnionRouter();
        /*
        System.out.println(testOnion.getInput());
        System.out.println(testOnion.lazyStringMethod(testOnion.getInput()));
        */
        //Scanner scnr = new Scanner(System.in);
        //int testInput = Integer.parseInt(scnr.nextLine());

        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,1,1));   //Creates original Integer Binary List
        /*List<List<Integer>> listLists = new ArrayList<List<Integer>>();

        System.out.println(intList);

        for(int i = 0; i<intList.size(); i++) {
            listLists.add(intList);
            intList = testOnion.trim(intList);
            System.out.println(intList);
        }

         */

        List<Boolean> boolList = new ArrayList<Boolean>((testOnion.intToBool(intList)));//Convert Integer list to Boolean

        System.out.println(intList);    //Prints Both
        System.out.println(boolList);

        boolList = testOnion.flip(boolList);    //Flips Boolean values
        System.out.println(boolList);

        intList = testOnion.boolToInt(boolList);    //Converts back to Integers
        System.out.println(intList);

    }
}
