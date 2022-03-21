import java.util.ArrayList;
import java.util.List;

public class MinimumConnection {
    public static void connect(MinimumPriorityQueue mpq){
        MinimumPriorityQueue mpqCopy = mpq;
        int size = mpqCopy.size();
        int[] connected = new int[size];
        int total = 0;
        int cost = 0;
        total += mpqCopy.extractMin();
        connected[0] = total;

        for(int i = 1; i < size; i++){
            int newRope = mpqCopy.extractMin();
            connected[i] = newRope;
            System.out.println("Connect the " + total + " length rope to the " + newRope + " length rope - cost of: " + (total + newRope));
            total += newRope;
            cost += total;
        }

        System.out.println("The minimum cost of connecting the ropes is:");
        for(int i = 0; i < size; i++){
            System.out.print(connected[i] + ", ");
        }
        System.out.println("is " + cost);
    }

    public static void main(String[] args) {
        int[] A = {4,8,3,1,6,9,12,7,2};
        MinimumPriorityQueue heap = new MinHeapImplementation(A);
        MinimumPriorityQueue bst = new BSTImplementation(A);
        MinimumPriorityQueue order1 = new BSTImplementationO1(A);

        MinimumPriorityQueue o1 = new BSTImplementationO1();
        o1.insert(4);
        o1.insert(8);
        o1.insert(3);
        o1.insert(1);
        o1.insert(6);
        o1.insert(9);
        o1.insert(12);
        o1.insert(7);
        o1.insert(2);


        connect(order1);
        
        order1.extractMin();
    }

}
