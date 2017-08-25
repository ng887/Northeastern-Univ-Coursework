package Assignments.Quiz;

import java.util.Arrays;

/**
 * Created by neha on 3/22/2017.
 */
public class WaveForm {



    public void formWaveArray01(int[] array){

        Arrays.sort(array);
        for (int i=0 ; i < array.length-1 ;  i=i+2){
                swap(array,i,i+1);
        }
    }

    public void formWaveArray(int[] array){

        for (int i=0 ; i < array.length ;  i=i+2){

            if(i>0 && array[i] > array[i-1]){
                swap(array,i,i-1);
            }
            if(i < array.length-1 && array[i] > array[i+1]){
                swap(array,i,i+1);
            }
        }


    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }



    public static void main(String[] args) {
        WaveForm wf = new WaveForm();
        int[] array = new int[]{1,2,3,4,5,6,7};
        int[] array1 = new int[]{5,3,1,0,7,4,8};
        wf.formWaveArray01(array);
        wf.formWaveArray(array1);

        System.out.println("Waveform- Sorted LC_01");
        for (int i=0 ; i < array.length  ; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println("Waveform- Unsorted LC_01");
        for (int i=0 ; i < array1.length  ; i++){
            System.out.print(array1[i] + " ");
        }
    }
}
