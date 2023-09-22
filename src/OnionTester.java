public class OnionTester {
    public static void main(String[] args){
        OnionRouter testOnion = new OnionRouter();
        System.out.println(testOnion.getInput());
        System.out.println(testOnion.lazyStringMethod(testOnion.getInput()));
    }
}
