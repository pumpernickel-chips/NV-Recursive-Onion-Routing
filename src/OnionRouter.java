//Naomi Coakley & Victor Serra

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OnionRouter {
    private static Integer step;
    private static Integer length;//the original length of the input
    private List<Integer> trimmedIntList = new ArrayList<Integer>();
    //private List<Integer> digits;
    private OnionRouter last;
    //default constructor with 7-digit input
    public OnionRouter(){
        this(new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,1,1)));
    }
    //complete constructor
    public OnionRouter(List<Integer> input){
        //this.digits = input;
        step = input.size();
        length = step;
        printDigits(input);
        this.onion(input);
    }
    private OnionRouter(List<Integer> input, OnionRouter last){
        //this.digits = input;
        this.last = last;
        this.onion(input);
    }
    public List<Integer> onion(List<Integer> ints) {
        if(step/length==-1){
            ints.add(0, (trimmedIntList.get(0)==1? 0 : 1));
            ints.add(trimmedIntList.get(1)==1? 0 : 1);
            printDigits(ints);
            System.out.println(toString()); //ToSTRING TEST
        }else if(ints.size()>1 && step>0){//subtractive process
            trimmedIntList.add(ints.get(0));
            ints.remove(0);
            step--;
            trimmedIntList.add(ints.get(ints.size()-1));
            ints.remove(ints.size()-1);
            step--;
            printDigits(ints);
            new OnionRouter(ints, this);
            System.out.println(toString()); //ToSTRING TEST
        }else if(ints.size()>=1 && step<0){//additive process
            ints.add(0, (trimmedIntList.get(0)==1? 0 : 1));
            step--;
            ints.add(trimmedIntList.get(1)==1? 0 : 1);
            step--;
            printDigits(ints);
            this.last.onion(ints);
            System.out.println(toString()); //ToSTRING TEST
        }else if(ints.size()==1 && step>0){//bit flip
            ints = new ArrayList<Integer>(Arrays.asList(ints.get(0)==1? 0 : 1));
            printDigits(ints);
            step = -3;
            this.last.onion(ints);
            System.out.println(toString()); //ToSTRING TEST
        }
        return ints;
    }
    public void printDigits(List<Integer> list) {
        String digits = "";
        for(int i = 0; i<((length-list.size())/2); i++) digits += " ";
        for(Integer n : list) digits += n;
        System.out.println(digits);
    }

    @Override
    public String toString() {
        return ("trimmedIntList: " + trimmedIntList + ", step: " + step + ", length: " + length + ", last: " + last);
    }

    @Override
    public boolean equals(Object o) {
        OnionRouter other = (OnionRouter) o;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!Objects.equals(trimmedIntList, other.trimmedIntList))
            return false;
        return Objects.equals(last, other.last);
    }
}
