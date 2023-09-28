import java.util.ArrayList;
import java.util.List;

public class OnionRouter {
    private List<Boolean> boolList = new ArrayList<Boolean>();
    private List<Integer> intList = new ArrayList<Integer>();
    private List<Integer> trimmedIntList = new ArrayList<Integer>();
    private int input;
    public OnionRouter(){
        this.input = 0123456;
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

    public List<Integer> addTrim(List<Integer> intList){
        trimmedIntList.add(intList.get(0));
        trimmedIntList.add(intList.get(intList.size()-1));
        return trimmedIntList;
    }

}
