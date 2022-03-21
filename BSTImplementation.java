public class BSTImplementation extends  BinarySearchTree implements  MinimumPriorityQueue{
    public BSTImplementation(int[] a) {
        for(int i = 0; i < a.length; i++){
            insert(a[i]);
        }
    }

    public BSTImplementation() {}

    @Override
    public int min() throws IndexOutOfBoundsException{
        if(this.root != null) {
            Node x = this.root;
            while (x.left != null) {
                x = x.left;
            }
            return x.key;
        }
        throw new IndexOutOfBoundsException("Minimum element does not exist");
    }

    @Override
    public int extractMin() throws IndexOutOfBoundsException{
        if(this.root != null) {
            Node min = min(this.root);
            delete(min);

            return (min.key);
        }
        throw new IndexOutOfBoundsException("Minimum element does not exist");
    }

    @Override
    public Node extractMinNode() throws IndexOutOfBoundsException{
        if(this.root != null){
            Node min = min(this.root);
            delete(min);

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
    }
}
