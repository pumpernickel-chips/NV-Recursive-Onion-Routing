//Naomi Coakley & Victor Serra

import java.util.*;
public class OnionTester {
    public OnionTester(){
    }
    public static void main(String[] args) throws InputMismatchException {
        OnionTester test = new OnionTester();
        Scanner scnr = new Scanner(System.in);
        List<Integer> intList;
        System.out.println("Enter \"e\" to Exit");
        while(true) {
            try {
                System.out.print("Enter Value: ");
                intList = test.oddBinaryList(scnr);
                if(intList.contains(-1)) break;
                System.out.println();
                OnionRouter onion = new OnionRouter(intList);
                System.out.println("\nEnter 'e' to Exit");
            } catch (InputMismatchException e) {
                System.out.println("Input must be an odd number of binary digits.\nEnter \"e\" to Exit");
            }
        }
    }
    public List<Integer> oddBinaryList(Scanner s) throws InputMismatchException {
        List<Integer> list = new ArrayList<Integer>();
            char[] testInput = ("" + s.nextLine()).toCharArray();
            for(char c : testInput){
                if(c=='e'){
                    return Collections.singletonList(-1);
                }else if(c=='0'){
                    list.add(0);
                }else if(c=='1'){
                    list.add(1);
                }else{
                    throw new InputMismatchException();
                }
            }
        if(list.size()%2==0) throw new InputMismatchException();
        return list;
    }
}
