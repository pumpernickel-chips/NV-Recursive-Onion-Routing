//Naomi Coakley & Victor Serra

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnionRouter {
    private static Integer step;
    private static Integer length;
    private List<Integer> intList = new ArrayList<Integer>();
    private List<Integer> trimmedIntList = new ArrayList<Integer>();
    private List<Integer> input;
    private OnionRouter last;
    //default constructor with 7-digit input
    public OnionRouter(){
        this(new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,1,1)));
    }
    //complete constructor
    public OnionRouter(List<Integer> input){
        this.input = input;
        step = input.size();
        length = step;
        flip(input);
    }
    private OnionRouter(List<Integer> input, OnionRouter last){
        this.input = input;
        this.last = last;
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
        new OnionRouter(input, this);
        return flippedInts;
    }
    public List<Integer> onion(List<Integer> ints) {
        if(step>=length-(2*length)){//update with proper negative syntax!!!!!

        }else if(ints.size()>1 && step>0){
            trimmedIntList.add(ints.get(0));
            ints.remove(0);
            step--;
            trimmedIntList.add(ints.get(ints.size()-1));
            ints.remove(ints.size()-1);
            step--;
            new OnionRouter(ints, this);
        }else if(ints.size()>1 && step<0){
            ints.add(0, (trimmedIntList.get(0)==1? 0 : 1));
            step--;
            ints.add((trimmedIntList.get(1)==1? 0 : 1));
            step--;
            this.last.onion(ints);
        }else if(ints.size()==1 && step>0){
            ints = new ArrayList<Integer>(Arrays.asList(ints.get(0)==1? 0 : 1));
            step = -3;
        }
        return ints;
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
