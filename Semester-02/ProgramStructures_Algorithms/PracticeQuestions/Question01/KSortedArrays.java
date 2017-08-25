package PracticeQuestions.Question01;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by neha on 3/14/2017.
 */

class HeapNode {
    int data;
    int arrayId;

    public HeapNode(int data, int arrayId) {
        this.data = data;
        this.arrayId = arrayId;
    }
}

/*Given k sorted arrays, merge them and print the sorted output. Please analyze the time complexity at the same time.
Example
k = 3;
[1,3,4,5],
[2,6,9],
[0,7,13,20]
return [0,1,2,3,4,5,6,7,13,20]
*/
public class KSortedArrays {

    private HeapNode[] heap;
    private int heapSize;
    private int[] result;


    public KSortedArrays(int size){
        heapSize = 0;
        heap = new HeapNode[size];
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

    public HeapNode getMin(){
        if(heapSize == 0)
            throw new NoSuchElementException("Heap is empty");
        else
            return heap[0];
    }

    public void insert(HeapNode heapNode){
        if(heapSize == heap.length)
            throw new NoSuchElementException("Heap is full");
        heap[heapSize++]= heapNode;
        siftUp(heapSize-1);
    }

    private void siftUp(int childIndex) {
        int parentindex;
        HeapNode temp;
        if(childIndex != 0){
            parentindex = getParentIndex(childIndex);
            if(heap[parentindex].data > heap[childIndex].data){
                temp = heap[parentindex] ;
                heap[parentindex]  = heap[childIndex];
                heap[childIndex] = temp;
                siftUp(parentindex);
            }

        }
    }

    public HeapNode removeMin(){
        HeapNode min = heap[0];
        delete(0);
        return min;
    }

    public int delete(int index){
        if(heapSize == 0)
            throw new NoSuchElementException("Heap is empty");
        int min = heap[index].data;
        heap[index] = heap[heapSize -1];
        heapSize --;
        if(heapSize > 0){
            siftDown(index);
        }
        return index;
    }

    private void siftDown(int index) {
        int leftChildIndex, rightChildIndex, minIndex;
        HeapNode temp;
        leftChildIndex = getLeftChildIndex(index);
        rightChildIndex = getRightChildIndex(index);

        if(rightChildIndex >= heapSize){
            if(leftChildIndex >= heapSize)
                return;
            else
                minIndex = leftChildIndex;
        }
        else{

            if(heap[leftChildIndex].data<= heap[rightChildIndex].data)
                minIndex = leftChildIndex;
            else
                minIndex = rightChildIndex;
        }

        if(heap[index].data > heap[minIndex].data){
            temp = heap[minIndex] ;
            heap[minIndex]  = heap[index];
            heap[index] = temp;
            siftDown(minIndex);
        }

    }

    /*  Time Complexity:O(nk*Logk)  using Min Heap.
STEPS:
1. Create an result array of size n*k.
2. Create a min heap of size k and insert 1st element ie. a heap node into a the heap
3. Get minimum element from heap (minimum is always at root) and store it in result array.
4. The extracted node contains the array list id it belongs to, insert the next element from that list into min-Heap.
5. If any list gets over, insert infinite number into min-Heap.
6. Keep repeating till all the K list gets over.
 */

    public int[] merge(int[][] A, int k, int n) {
        int nk = n * k;
        result = new int[nk];
        int count = 0;
        int[] ptrs = new int[k];
        // create index pointer for every array list.
        for (int i = 0; i < ptrs.length; i++) {
            ptrs[i] = 0;
        }

        for (int i = 0; i < k; i++) {
            if (ptrs[i] < n) {
                insert(new HeapNode(A[i][ptrs[i]],i)); // insert the element into heap
            } else {
                insert(new HeapNode(Integer.MAX_VALUE,i)); // If the array doesn’t have any more elements, insert infinity
            }

        }
        while (count < nk) {
            HeapNode heapMin = removeMin(); // get the min node from the heap.
            result[count] = heapMin.data; // store node data into result array
            ptrs[heapMin.arrayId]++; // increase the particular list pointer
            if (ptrs[heapMin.arrayId] < n) { // check if any of the lists items are not finished
                insert(new HeapNode(A[heapMin.arrayId][ptrs[heapMin.arrayId]], heapMin.arrayId)); // insert the next element from the list
            } else {
                insert(new HeapNode(Integer.MAX_VALUE, heapMin.arrayId)); // if any of this list items are over, insert infinity
            }
            count++;
        }
        return result;
    }

    public void printHeap(){
        for(int i=0 ; i < heapSize; i++ ){
            System.out.print(heap[i].data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        KSortedArrays minHeap = new KSortedArrays(7);
        minHeap.insert(new HeapNode(1,0));
        minHeap.insert(new HeapNode(7,1));
        minHeap.insert(new HeapNode(4,2));
        minHeap.insert(new HeapNode(5,3));
        minHeap.insert(new HeapNode(3,4));
        minHeap.insert(new HeapNode(8,5));
        minHeap.insert(new HeapNode(6,6));

        System.out.println("Heap after insert:");
        minHeap.printHeap();
        System.out.println("Get and delete min from Heap: " + minHeap.removeMin().data);
        System.out.println("Heap after min deleted:");
        minHeap.printHeap();


        System.out.println("Merge K Sorted arrays:");
        int[][] arr = new int[5][];
        arr[0] = new int[] { 1, 17, 20, 25 };
        arr[1] = new int[] { 2, 5, 10, 28 };
        arr[2] = new int[] { 4, 6, 9, 15 };
        arr[3] = new int[] { 9, 14, 17, 19 };
        arr[4] = new int[] { 12, 14, 16, 29 };
        KSortedArrays m = new KSortedArrays(arr.length);
        int[] mergedArr  = m.merge(arr, arr.length, arr[0].length);
        System.out.println(Arrays.toString(mergedArr));
    }
}

