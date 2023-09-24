import java.util.ArrayList;
import java.util.List;

public class OnionRouter {
    private List<Object> binaryList = new ArrayList<>();
    private List<Boolean> boolList = new ArrayList<Boolean>();
    private List<Integer> intList = new ArrayList<Integer>();
    private int input;
    public OnionRouter(){
        this.input = 0123456;
    }

    public int lazyStringMethod(int in){
        return Integer.parseInt((String.valueOf(in)).substring(1,(String.valueOf(in).length()-1)));
    }

    public int getInput(){
        return this.input;
    }

    public List<Boolean> intToBool(List<Integer> intList) {
        for (int in: intList) {
            if (in == 1){
                boolList.add(true);
            }else if(in == 0){
                boolList.add(false);
            }else{
                System.out.println("Not Binary unit");
            }
        }
        return boolList;
    }
    public List<Integer> boolToInt(List<Boolean> boolList) {
        for (Boolean bo: boolList) {
            if (bo){
                intList.add(1);
            }else{
                intList.add(0);
            }
        }
        return intList;
    }

    public List<Boolean> flip(List<Boolean> boolList){
        List<Boolean> flippedBooleans = new ArrayList<>();
        for (Boolean b: boolList) {
            if (b){
                flippedBooleans.add(false);
            }else {
                flippedBooleans.add(true);
            }
        }
        return flippedBooleans;
    }
    public List<Integer> trim(List<Integer> intList){
        intList.remove(intList.size()-1);
        intList.remove(0);
        return intList;
    }
}
