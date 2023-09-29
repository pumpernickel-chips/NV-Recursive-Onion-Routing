//Naomi Coakley & Victor Serra

import java.io.IOException;
import java.util.*;
public class OnionTester {
    public OnionTester(){
    }
    public static void main(String[] args) throws IOException {
        OnionTester test = new OnionTester();
        Scanner scnr = new Scanner(System.in);
        List<Integer> intList = new ArrayList<Integer>();
        boolean waitingForInput = true;
        while(waitingForInput) {
            try {
                System.out.print("Enter Value: ");
                intList = test.oddBinaryList(scnr);/*new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,1,1))*/ //Creates original Integer Binary List
                waitingForInput = false;
                OnionRouter testOnion = new OnionRouter(intList);
            } catch (IOException e) {
                System.out.println("Input must be an odd number of binary digits.");
                waitingForInput = true;
            }
        }
    }
    public List<Integer> oddBinaryList(Scanner s) throws IOException {
        List<Integer> list = new ArrayList<Integer>();
            char[] testInput = ("" + s.nextLine()).toCharArray();
            for(char c : testInput){
                if(c=='0'){
                    list.add(0);
                }else if(c=='1'){
                    list.add(1);
                }else{
                    throw new IOException();
                }
            }
            if(list.size()%2==0) throw new IOException();
            //System.out.println(testInput);
        return list;
    }
}
