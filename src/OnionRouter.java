import java.util.ArrayList;
import java.util.List;

public class OnionRouter {
    private List<Boolean> boolArray = new ArrayList<Boolean>();
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

    public List<Boolean> intToBoolToInt(List<Integer> intList) {
        for (int in: intList) {
            if (in == 1){
                boolArray.add(true);
            }else if(in == 0){
                boolArray.add(false);
            }
        }
        return boolArray;
    }

    public List<Boolean> flip(List<Boolean> boolList){
        List<Boolean> flipBoolean = new ArrayList<>();
        int i = 0;
        for (Boolean b: boolList) {
            i++;
        }
        return null;
    }

}
