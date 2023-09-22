import java.util.ArrayList;
import java.util.Arrays;

public class OnionTester {
    public static void main(String[] args){
        OnionRouter testOnion = new OnionRouter();
        System.out.println(testOnion.getInput());
        System.out.println(testOnion.lazyStringMethod(testOnion.getInput()));

        ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList(1,0,1,0,1));

        System.out.println(testOnion.intToBoolToInt(intList));

    }
}
