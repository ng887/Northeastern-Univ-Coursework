package Heaps;

import java.util.NoSuchElementException;

/**
 * Created by neha on 3/14/2017.
 */


public class MinHeap {

    private int[] heap;
    private int heapSize;
    private int[] result;

    public MinHeap(int size){
        heapSize = 0;
        heap = new int[size];
    }


    private int getLeftChildIndex(int index){
        return 2*index +1;
    }

    private int getRightChildIndex(int index){
        return 2*index +2;
    }

    private int getParentIndex(int index){
        return (index -1)/2;
    }

    public int getMin(){
        if(heapSize == 0)
            throw new NoSuchElementException("Heap is empty");
        else
            return heap[0];
    }

    public void insert(int value){
        if(heapSize == heap.length)
            throw new NoSuchElementException("Heap is full");
        heap[heapSize++]= value;
        siftUp(heapSize-1);
    }

    private void siftUp(int childIndex) {
        int parentindex, temp;
        if(childIndex != 0){
            parentindex = getParentIndex(childIndex);
            if(heap[parentindex] > heap[childIndex]){
                temp = heap[parentindex] ;
                heap[parentindex]  = heap[childIndex];
                heap[childIndex] = temp;
                siftUp(parentindex);
            }

        }
    }

    public int deleteMin(){
        int min = heap[0];
        delete(0);
        return min;
    }

    public int delete(int index){
        if(heapSize == 0)
            throw new NoSuchElementException("Heap is empty");
        int min = heap[index];
        heap[index] = heap[heapSize -1];
        heapSize --;
        if(heapSize > 0){
            siftDown(index);
        }
        return index;
    }

    private void siftDown(int index) {
        int leftChildIndex, rightChildIndex, minIndex, temp;
        leftChildIndex = getLeftChildIndex(index);
        rightChildIndex = getRightChildIndex(index);

        if(rightChildIndex >= heapSize){
            if(leftChildIndex >= heapSize)
                return;
            else
                minIndex = leftChildIndex;
        }
        else{

            if(heap[leftChildIndex]<= heap[rightChildIndex])
                minIndex = leftChildIndex;
            else
                minIndex = rightChildIndex;
        }

        if(heap[index] > heap[minIndex]){
            temp = heap[minIndex] ;
            heap[minIndex]  = heap[index];
            heap[index] = temp;
            siftDown(minIndex);
        }

    }
}
