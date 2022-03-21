public class BSTImplementationO1 extends BinarySearchTree implements MinimumPriorityQueue{
    private Node minimum = null;

    public BSTImplementationO1(int[] a) {
        for(int i = 0; i < a.length; i++){
            insert(a[i]);
        }
    }

    public BSTImplementationO1(){}

    @Override
    public int min() throws IndexOutOfBoundsException{
        if(this.root != null) {
            Node x = this.minimum;
            return x.key;
        }
        throw new IndexOutOfBoundsException("Minimum element does not exist");
    }

    @Override
    public int extractMin() throws IndexOutOfBoundsException{
        if(this.root != null) {
            Node min = this.minimum;
            delete(min);
            this.minimum = min.next;

            return (min.key);
        }
        throw new IndexOutOfBoundsException("Minimum element does not exist");

    }

    @Override
    public Node extractMinNode() throws IndexOutOfBoundsException{
        if(this.root != null) {
            Node min = this.minimum;
            delete(min);
            this.minimum = min.next;

            return min;
        }
        throw new IndexOutOfBoundsException("Minimum element does not exist");
    }

    @Override
    public void insert(int key) {
        Node z = new Node(key);
        Node y = null;
        Node x = this.root;

        while(x != null){
            y = x;
            if(z.key < x.key){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;

        if(y == null){
            this.root = z;
        } else if (z.key < y.key){
            y.left = z;
        } else {
            y.right = z;
        }

        z.next = successor(z);

        if(predecessor(z) != null){
            predecessor(z).next = z;
        } else {
            this.minimum = z;
        }
    }

    @Override
    public void delete(Node z){
        Node previous = null;
        if(this.minimum != z){
            previous = predecessor(z);
        }
        super.delete(z);
        if(this.minimum != z){
            previous.next = successor(previous);
        }
    }
}
