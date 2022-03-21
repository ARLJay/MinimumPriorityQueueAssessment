public class MinHeapImplementation implements MinimumPriorityQueue{
    private int[] heap;

    public MinHeapImplementation(int[] heap){
        buildMinHeap(heap);
    }
    public MinHeapImplementation(){
    }

    public int size(){
        return heap.length;
    }

    public void printHeap(){
        for(int i = 0; i < heap.length; i++){
            System.out.println(heap[i]);
        }
    }

    public void insert(int key) {
        int size = heap.length;
        int[] newHeap = new int[size+1];
        for(int i = 0; i < size; i++){
            newHeap[i] = heap[i];
        }
        newHeap[size] = key;
        buildMinHeap(newHeap);
    }

    public int min() throws IndexOutOfBoundsException{
        if (heap.length != 0) {
            return heap[0];
        }
        throw new IndexOutOfBoundsException("Minimum element does not exist");
    }

    public int extractMin() throws IndexOutOfBoundsException{
        if(heap.length !=0) {

            int min = heap[0];

            int[] newHeap = new int[heap.length - 1];
            for (int i = 1; i < heap.length; i++) {
                newHeap[i - 1] = heap[i];
            }
            buildMinHeap(newHeap);
            return min;
        }
        throw new IndexOutOfBoundsException("Minimum element does not exist");
    }

    public void swap(int[] A, int id1, int id2){
        int temp = A[id1];
        A[id1] = A[id2];
        A[id2] = temp;
    }

    public void buildMinHeap(int[] array){
        int n = array.length;
        for(int i = (n / 2) - 1; i>=0; i--){
            minHeapify(array, i, n);
        }
        this.heap = array;
    }

    private void minHeapify(int[] A, int i, int n) {
        int left = left(i);
        int right = right(i);
        int smallest;

        if(left < n && A[left] < A[i]){ //If left is in bounds and value in left is smaller than value in middle
            smallest = left;
        } else {
            smallest = i; //If left isn't smallest make middle smallest
        }

        if(right < n && A[right] < A[smallest]){ //If right is in bounds and value in right is smaller than value in smallest
            smallest = right;
        }

        if(smallest != i){
            swap(A, i, smallest);
            minHeapify(A, smallest, n);
        }
    }

    public int left(int i){
        return (2*i)+1;
    }

    public int right(int i){
        return (2*i)+2;
    }
}
