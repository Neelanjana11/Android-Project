package com.neelanjana.benchmarkalgo;

/**
 * Created by Neelanjana on 14-Oct-16.
 */


public class Sort {
    public static int bubbleSort(int[] array){
        long start = System.currentTimeMillis();

        int n = array.length;
        int temp;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < (n - 1); j++ )
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
        }
        long stop = System.currentTimeMillis();
        long time_in_ms = stop - start;

        return (int)time_in_ms;
    }

    public static int selectionSort(int[] array){
        long start = System.currentTimeMillis();

        int n = array.length;

        for (int i = 0; i < n - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < n; j++)
                if (array[j] < array[index])
                    index = j;

            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
        long stop = System.currentTimeMillis();
        long time_in_ms = stop - start;
        return (int)time_in_ms;
    }

    public static int insertionSort(int[] array){
        long start = System.currentTimeMillis();

        int n = array.length;
        int temp;
        for (int i = 1; i < n; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        long stop = System.currentTimeMillis();
        long time_in_ms = stop - start;
        return (int)time_in_ms;
    }


    public static void benchmarkAll(int[] array){
        int time;
        time = Sort.bubbleSort(array);


        time = Sort.selectionSort(array);

        time = Sort.insertionSort(array);


    }
}










