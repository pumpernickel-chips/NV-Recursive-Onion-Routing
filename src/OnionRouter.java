import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnionRouter {
    private List<Integer> intList = new ArrayList<Integer>();
    private List<Integer> trimmedIntList = new ArrayList<Integer>();
    private List<Integer> input;
    public OnionRouter(){
        this(new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,1,1)));
    }
    public OnionRouter(List<Integer> input){
        this.input = input;
        flip(input);
    }

    public List<Integer> flip(List<Integer> intList){
        List<Integer> flippedInts = new ArrayList<>();
        for (Integer i: intList) {
            if (i == 1){
                flippedInts.add(0);
            }else if (i == 0){
                flippedInts.add(1);
            }
        }
        return flippedInts;
    }

    public List<Integer> trim(List<Integer> intList){
        intList.remove(intList.size()-1);
        intList.remove(0);
        return intList;
    }

    public List<Integer> addTrim(List<Integer> intList){
        trimmedIntList.add(intList.get(0));
        trimmedIntList.add(intList.get(intList.size()-1));
        return trimmedIntList;
    }

}
