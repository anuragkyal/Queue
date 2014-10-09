/**
 * Created by anurag on 10/9/14.
 *
 * The Queue DS implemented with the help of arrays
 * Constant running time for enqueue, dequeue, size and capacity
 * Space requirement  = O(size) where size = size of queue
 *
 * 2 global indices are maintained: start and end.
 * De-queue is done at start and it returns null if queue is empty
 * Enqueue is done at end position and returns true if success and false otherwise
 * size stores the size of the queue
 * capacity stores the current capacity of the queue
 *
 * The constant runtime is achieved by the virtue that when en-queueing, the start need not be moved
 * and when de-queueing, the end shouldn't be either, ie. once an element is enqueued, it stays at the same
 * place in the array throughout its lifetime
 *
 * An entensive test suite is provided which covers the testing of nitty gritties of the algorithm
 * Its well documented too.
 */
public class Queue {
    Integer[] queue;
    int size = 0;

    //capacity stores the current space available in the queue
    int capacity = 0;

    //start is the index from which the integer in queue will be removed
    int start = 0;

    //end is the index which will take the new integer in the queue
    int end = 0;

    Queue(int size){
        queue = new Integer[size];
        this.size = size;
        this.capacity = size;
    }

    boolean enqueue(int n){
        //Checking for more space
        if(capacity == 0){
            System.out.println("Queue Full!");
            return false;
        }

        //Trying to save n at index end. if it fails, there is
        //something wrong with the index end
        try {
            queue[end] = n;
        }catch (Exception e){
            System.out.print("Something fishy is enqueue");
            return false;
        }

        //end may reach the end of the array, so it needs to be rotated to 0
        //0 will always be available if the capacity>=1
        end = (end + 1) % size;
        capacity--;

        return true;
    }

    Integer dequeue(){
        //Checking if any elements present at all in the queue
        if(capacity == size){
            System.out.println("Queue Empty!");
            return null;
        }

        //
        start = (start + 1) % size;
        capacity++;

        //Trying to remove element at index start. if it fails, there is
        //something wrong with the index start
        //size + start -1 is used instead of size - 1 because java wont handle negative mod :/
        try {
            return queue[(size + start - 1) % size];
        }catch (Exception e){
            System.out.print("Something fishy in dequeue");
            return null;
        }

    }

    int getSize(){
        return size;
    }

    int getCapacity(){
        return capacity;
    }
}
