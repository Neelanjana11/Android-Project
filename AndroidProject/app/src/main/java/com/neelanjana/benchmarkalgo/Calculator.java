package com.neelanjana.benchmarkalgo;

/**
 * Created by Neelanjana on 14-Oct-16.
 */


public class Calculator {

    public static int[] generateNaturalNumbers(int howMany){
        int[] array = new int[howMany];

        for(int i = 0; i < howMany; i++){
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] generateRandomNumbers(int size){
        int[] array = new int[size];

        for(int i = 0; i < array.length; i++)
            array[i] = (int)(Math.random() * 100);

        return array;
    }

    public static int[] generateReverseNaturalNumbers(int howMany){
        int[] reverseArray = new int[howMany];

        for(int i = howMany - 1; i < 0; i--){
            reverseArray[i] = i;
        }
        return reverseArray;
    }

}

