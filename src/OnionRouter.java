/*
 * CS208 P2
 * Naomi Coakley & Victor Serra
 */
import java.util.*;
import java.util.stream.Collectors;
/**
 * <p>
 *     Recursive class that reduces a binary number with an odd number of bits (in the form of a {@code List}) to its
 *     middle bit, flips it, and replaces the outer bits two at a time until the original number is returned with all of
 *     its bits flipped. The constructor prints the number before and after the {@link #onionLayer} method is called to
 *     change it, such that each step of the process can be seen on the console in the correct order.
 *     </p>
 * @author Naomi Coakley
 * @author Victor Serra
 */
public class OnionRouter {
    private List<Integer> bits;
    /**
     * <p>
     *     Default zero args constructor.
     * </p><p>
     * Passes a default {@code List} of values (representing the binary number {@code 1101011}) to the main constructor.
     * </p>
     */
    public OnionRouter() throws InputMismatchException {
        this(Arrays.asList(1, 1, 0, 1, 0, 1, 1));
    }
    /**
     * <p>
     *     Main constructor requiring one parameter.
     * </p><p>
     * If no exception is thrown, {@link #bits} is initialized with the {@code input} passed in and the starting value
     * prints to console. {@link #bits} is then set equal to the return value of {@link #onionLayer}, and this updated
     * value also prints to console.
     * </p>
     * @param input a list that must contain an odd number of binary digits
     * @throws InputMismatchException if {@code input} has an even number of elements
     * */
    public OnionRouter(List<Integer> input) throws InputMismatchException {
        if(input.size()%2==0) throw new InputMismatchException();
        this.bits = input;
        System.out.println(this);
        this.bits = this.onionLayer(this.bits);
        System.out.println(this);
    }
    /**
     * <p>
     *     Recursive method requiring one parameter.
     * </p><p>
     *     For any {@code input} with more than one element, the {@code else} statement is executed, initializing a
     * new {@code OnionRouter} with the same {@code List} as a parameter, but without the first and last elements. The
     * last two lines in the {@code else} statement do not execute until all lines in the constructor of the new
     * {@code OnionRouter} object have been executed.
     * </p><p>
     *     The base case condition is satisfied only once during the recursive process, at the halfway point when the
     * {@code input} has been reduced to one element. The single "bit" is flipped and the method is allowed to return.
     * At this point in the recursive sequence, no more {@code OnionRouter} objects will be initialized and the current
     * instance will be the first one in its sequence to break out of this {@code if-else} block and return.
     * </p><p>
     *     After this, the other instances execute the remainder of their methods and constructors in reverse order,
     *     flipping the first and last bits similarly to the middle bit(s) and returning a fully flipped {@code input}.
     * </p>
     * @param input a list that containing an odd number of binary digits
     * @throws InputMismatchException if input has an even number of elements when passed to a new {@code OnionRouter}
     * */
    private List<Integer> onionLayer(List<Integer> input) throws InputMismatchException {
        if(input.size() == 1){//base case:
            input.set(0, (input.get(0) == 1? 0 : 1));
        }else{//all other cases:
            new OnionRouter(input.subList(1, input.size() - 1));
            input.set(0, (input.get(0) == 1? 0 : 1));
            input.set(input.size() - 1, (input.get(input.size() - 1) == 1? 0 : 1));
        }
        return input;
    }
    @Override
    public String toString() {
        return (this.bits.stream().map(Object::toString).collect(Collectors.joining("")));
    }
    @Override
    public boolean equals(Object o) {
        OnionRouter other = (OnionRouter) o;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(bits, other.bits);
    }
}