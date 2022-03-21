public abstract class BinarySearchTree {
    protected Node root;

    protected class Node{
        protected int key;
        protected Node left, right, parent, next;

        public Node(int key){
            this.key = key;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.next = null;
        }

    }

    public Node search(Node x, int key){
        if(x == null || key == x.key){
            return x;
        }
        if(key < x.key){
            return search(x.left, key);
        }
        return search(x.right, key);
    }

    public Node searchIterative(Node x, int key){
        while(x != null && key != x.key){
            if(key < x.key){
                x = x.left;
            }
            else{
                x = x.right;
            }
        }
        return x;
    }

    public abstract int min();
    public abstract int extractMin();
    public abstract Node extractMinNode();

    public Node min(Node x){
        while (x.left != null){
            x = x.left;
        }
        return x;
    }

    public Node max(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    public Node successor(Node x){
        if(x.right != null){
            return min(x.right);
        }
        Node y = x.parent;
        while(y != null && x == y.right){
            x = y;
            y = y.parent;
        }
        return y;
    }

    public Node predecessor(Node x){
        if(x.left!= null){
            return max(x.left);
        }
        Node y = x.parent;
        while(y != null && x == y.left){
            x = y;
            y = y.parent;
        }
        return y;
    }

    public int size(){
        Node x = this.root;
        if(x == null){
            return 0;
        }
        return sizeNode(x.left) + sizeNode(x.right) + 1;
    }

    public int sizeNode(Node x){
        if(x == null){
            return 0;
        }
        return sizeNode(x.left) + sizeNode(x.right) + 1;
    }

    public int height(Node x){
        if(x == null){
            return 0;
        }
        if(x.left == null && x.right == null){
            return 0;
        }
        int leftHeight = height(x.left);
        int rightHeight = height(x.right);
        if(leftHeight > rightHeight){
            return leftHeight + 1;
        }
        return rightHeight + 1;
    }

    public abstract void insert(int key);

    public void transplant(Node u, Node v){
        if(u.parent == null){
            this.root = v;
        } else if(u == u.parent.left){
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }

        if(v != null){
            v.parent = u.parent;
        }
    }

    public void delete(Node z){
        if(z.left  == null){
            transplant(z, z.right);
        } else if(z.right == null){
            transplant(z, z.left);
        } else {
            Node y = min(z.right);
            if(y.parent != z){
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }
}
