package org.example;
import java.util.*;
import java.util.stream.IntStream;

public class lotManager {
    //  Variables needed for the Runtime class to work. The integers for initial lot size calculation, and then hashmaps,
//  to store the lot number, and it's availability.
    private int smallLot;
    private int largeLot;
    private int oversizeLot;
    private final Map<Integer, String> smallLotHash = new HashMap<>();
    private final Map<Integer, String> largeLotHash = new HashMap<>();
    private final Map<Integer, String> oversizeLotHash = new HashMap<>();

    public void createLot(int lotSize){
//      This method decides how to split the user's given input, then sets up the hashmaps appropriately.
        if(lotSize%3==0){
            smallLot = lotSize/3;
            largeLot = lotSize/3;
            oversizeLot = lotSize/3;}
        else if (lotSize%3==1){
            smallLot = lotSize/3;
            largeLot = ((lotSize/3)+1);
            oversizeLot = lotSize/3;
        }
        else if (lotSize%3==2){
            smallLot = ((lotSize/3)+1);
            largeLot = ((lotSize/3)+1);
            oversizeLot = lotSize/3;
        }
        IntStream.range(1, (smallLot+1)).forEach(i -> smallLotHash.put(i,"Available"));
        IntStream.range(1, (largeLot+1)).forEach(i -> largeLotHash.put(i,"Available"));
        IntStream.range(1, (oversizeLot+1)).forEach(i -> oversizeLotHash.put(i,"Available"));
    }

    //  These sets of methods prints out the lot numbers and their availability.
    public void printSmallHash(){
        System.out.println("Small Lot: ");
        smallLotHash.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public void printLargeHash(){
        System.out.println("Large Lot: ");
        largeLotHash.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public void printOversizeHash(){
        System.out.println("Oversize Lot: ");
        oversizeLotHash.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    //  These methods first checks if the specified lot number exists and if there are available spots in the lot, then
//  marks the specified lot number as "Taken".
    public void setSmallHash(int n){
        if(!smallLotHash.containsKey(n)|| !Objects.equals(smallLotHash.get(n), "Available")) {
            System.out.println("Out of bounds or unavailable");
        }
        smallLotHash.replace(n,"Available","Taken");
    }

    public void setLargeHash(int n){
        if(!largeLotHash.containsKey(n)|| !Objects.equals(largeLotHash.get(n), "Available")){
            System.out.println("Out of bounds or unavailable");
        }
        largeLotHash.replace(n,"Available","Taken");
    }

    public void setOversizeLot(int n){
        if(!oversizeLotHash.containsKey(n)|| !Objects.equals(oversizeLotHash.get(n), "Available")){
            System.out.println("Out of bounds or unavailable");
        }
        oversizeLotHash.replace(n,"Available","Taken");
    }

    //  These methods are similar to setLotHash, but in reverse. Checks if the lot number exists, and if there are taken
//  spots. Then replaces the old value with the new.
    public void removeSmallHash(int n){
        if(!smallLotHash.containsKey(n)|| !Objects.equals(smallLotHash.get(n), "Taken")){
            System.out.println("Out of bounds or available");
        }
        smallLotHash.replace(n,"Taken","Available");
    }

    public void removeLargeHash(int n){
        if(!largeLotHash.containsKey(n)|| !Objects.equals(largeLotHash.get(n), "Taken")){
            System.out.println("Out of bounds or available");
        }
        largeLotHash.replace(n,"Taken","Available");
    }

    public void removeOversizeHash(int n){
        if(!oversizeLotHash.containsKey(n)|| !Objects.equals(oversizeLotHash.get(n), "Taken")){
            System.out.println("Out of bounds or available");
        }
        oversizeLotHash.replace(n,"Taken","Available");
    }
}
