public class OnionRouter {
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
}
