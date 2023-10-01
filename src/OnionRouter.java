//Naomi Coakley & Victor Serra

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OnionRouter {
    private static Integer step;
    /**
     * <p>The length of the original input given by the user.</p>
     * <p>This field is static for access by all instances of {@code OnionRouter} within a single recursive process.</p>
     * <p>This value is set to {@code null} when the base case of {@link #onionLayer} is invoked during the final step
     * of recursion, indicating that no recursive process is currently running, thus avoiding parallel {@code OnionRouter}
     * instance conflicts.</p>
     */
    private static Integer size;;
    private List<Integer> outerBits = new ArrayList<Integer>();
    private List<Integer> bits;
    private OnionRouter last;
    /**<p>
     * Public zero args constructor.
     * </p>
     * Passes in an {@code ArrayList<Integer>} as a default test input value representing the binary figure {@code 1101011} to the main public constructor.
     */
    public OnionRouter(){
        this(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0, 1, 1)));
    }
    /**
     * <p>Main public constructor requiring one parameter.</p>
     * Initializes {@code OnionRouter.bits} with the {@code input} passed in, sets static fields {@link #step}
     * and {@link #size} equal to the number of elements in {@code OnionRouter.bits}.
     * @param input a list that must contain an odd number of binary digits
     * */
    public OnionRouter(List<Integer> input){
        this.bits = input;
        step = bits.size();
        size = step;
        this.printBits(bits);
        bits = this.onionLayer(bits);
        System.out.print("*");
        this.printBits(bits);
    }
    /**
     * <p>Private complete constructor requiring two parameters, called only by {@link #onionLayer} during the recursive process.</p>
     * The intention of this private constructor is to overload the main constructor starting on the second step of recursion to avoid overwriting the static fields {@code OnionRouter.step} and {@code OnionRouter.inputSize} like the main constructor would.;
     * @param input a list that must contain an odd number of binary digits
     * @param last reference to the {@code OnionRouter} instance that invoked this constructor
     */
    private OnionRouter(List<Integer> input, OnionRouter last){
        this.bits = input;
        this.last = last;
        this.bits = this.onionLayer(this.bits);
        this.printBits(bits);
    }
    /**
     * <p>Recursive method requiring one parameter.</p>
     * <p>Divided into {@code if} blocks representing the following distinct cases during the recursive process:</p>
     * <p><i>base case</i>, when {@link #step} is negative with an absolute value equal to {@link #size}, which always
     * indicates that all but the final step of the recursive process have been executed</p>
     * <p></p>
     * <p></p>
     * <p></p>
     * */
    public List<Integer> onionLayer(List<Integer> ints) {
        //System.out.println("bits @ step " + step + ": " + bits);
        //base case
        if(step / size == -1){
            //System.out.println("ints before add: " + ints);
            //System.out.println("bits before add: " + bits);
            ints.add(0, (outerBits.get(0) == 1? 0 : 1));
            ints.add(outerBits.get(1) == 1? 0 : 1);
            //step = null;
            //size = null;
            //System.out.println("ints before return: " + ints);
            //System.out.println("bits before return: " + bits);

            return ints;
        //pre-flip case
        }else if(ints.size() > 1 && step > 0){
            outerBits.add(ints.get(0));
            ints.remove(0);
            step--;
            outerBits.add(ints.get(ints.size() - 1));
            ints.remove(ints.size() - 1);
            step--;
            printBits(ints);
            new OnionRouter(ints, this);
            System.out.print("*");
            printBits(ints);
            //System.out.println("pre-flip case breaks at step " + step);
        //bit-flip case
        }else if(ints.size() == 1 && step > 0){
            step--;
            printBits(ints);
            ints = new ArrayList<Integer>(Arrays.asList(ints.get(0) == 1? 0 : 1));
            printBits(ints);
            step--;
            return this.last.onionLayer(ints);
        //post-flip case
        }else if(ints.size() >= 1 && step < 0){
            ints.add(0, (outerBits.get(0) == 1? 0 : 1));
            step--;
            ints.add(outerBits.get(1) == 1? 0 : 1);
            step--;
            printBits(ints);
            return this.last.onionLayer(ints);
        }
        //System.out.println("entire method returns at step " + step);
        return ints;
    }
    public void printBits(List<Integer> list) {
        String out = "";
        if(size != null){
            for(int i = 0; i < ((size - list.size()) / 2); i++) out += " ";
        }
        for(Integer n : list) out += n;
        System.out.println(out);
    }
    public static boolean isBusy(){
        return step == null && size == null;
    }

    @Override
    public String toString() {
        return ("trimmedIntList: " + outerBits + ", step: " + step + ", length: " + size + ", last: " + last);
    }

    @Override
    public boolean equals(Object o) {
        OnionRouter other = (OnionRouter) o;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!Objects.equals(outerBits, other.outerBits))
            return false;
        return Objects.equals(last, other.last);
    }
}