package org.example;
import java.util.*;

public class Main {
    //  Variables needed for the program to function, start boolean for initial setup. The during boolean and runtime
//  lotManager for data storage and management
    static boolean start = true;
    static boolean during = true;
    static lotManager runtime = new lotManager();

    public static void main(String[] args) {
//      This while statement asks user for the size of the lot, the input will then set up the runtime as needed
        while (start) {
            try{
                System.out.print("Enter size of lot: ");
                Scanner sizeInit = new Scanner(System.in);
                int lotSize = sizeInit.nextInt();
                runtime.createLot(lotSize);
                start = false;
            }
            catch (Exception e) {
                System.out.println("Sorry, there was an error.");
            }
        }

//     This while statement is the core of the program, asking the user which lot they want to interact with, and
//     then ask what they want to do with it, such as adding or removing a car, or viewing.
        while (during){
            String Input;
            int nInput;
            Scanner input = new Scanner(System.in);
            System.out.println("Which lot would you like to see, or exit application? Small, Large, or Oversize?:");
            Input = input.next();
            if (Objects.equals(Input.toLowerCase(),"exit")){
                during = false;
            }
            try{
//          This try block is where the user would select which lot they would like to interact with, and then deciding
//          if they want to add or remove to the lot, or view it.
                if (Objects.equals(Input.toLowerCase(), "small")){
                    System.out.println("Would you like to add, remove, or check status?:");
                    Input = input.next();
                    if (Objects.equals(Input.toLowerCase(),"add")){
                        System.out.println("Add to which lot number?:");
                        nInput = input.nextInt();
                        runtime.setSmallHash(nInput);
                    }
                    if (Objects.equals(Input.toLowerCase(),"remove")){
                        System.out.println("Remove from which lot number?:");
                        nInput = input.nextInt();
                        runtime.removeSmallHash(nInput);
                    }
                    if (Objects.equals(Input.toLowerCase(),"check")){
                        runtime.printSmallHash();
                    }
                }
                if (Objects.equals(Input.toLowerCase(), "large")){
                    System.out.println("Add? Remove? Check Status?:");
                    Input = input.next();
                    if (Objects.equals(Input.toLowerCase(),"add")){
                        System.out.println("Add to which lot number?:");
                        nInput = input.nextInt();
                        runtime.setLargeHash(nInput);
                    }
                    if (Objects.equals(Input.toLowerCase(),"remove")){
                        System.out.println("Remove from which lot number?:");
                        nInput = input.nextInt();
                        runtime.removeLargeHash(nInput);
                    }
                    if (Objects.equals(Input.toLowerCase(),"check")){
                        runtime.printLargeHash();
                    }
                }
                if (Objects.equals(Input.toLowerCase(), "oversize")){
                    System.out.println("Add? Remove? Check Status?:");
                    Input = input.next();
                    if (Objects.equals(Input.toLowerCase(),"add")){
                        System.out.println("Add to which lot number?:");
                        nInput = input.nextInt();
                        runtime.setOversizeLot(nInput);
                    }
                    if (Objects.equals(Input.toLowerCase(),"remove")){
                        System.out.println("Remove from which lot number?:");
                        nInput = input.nextInt();
                        runtime.removeOversizeHash(nInput);
                    }
                    if (Objects.equals(Input.toLowerCase(),"check")){
                        runtime.printOversizeHash();
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Sorry, there was an error.");
            }
        }
    }
}