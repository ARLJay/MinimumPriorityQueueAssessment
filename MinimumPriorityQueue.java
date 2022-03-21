public interface MinimumPriorityQueue {
    public int min() throws IndexOutOfBoundsException;
    public int extractMin() throws IndexOutOfBoundsException;
    public int size();
    public void insert(int key);
}
