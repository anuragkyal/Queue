import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by anurag on 10/9/14.
 */
public class QueueTest {
    Queue queue;
    int size = 10;

    @Before
    public void init(){
        queue = new Queue(size);
    }

    @Test
    public void testSize(){
        assertEquals(queue.getSize(), 10);
    }

    @Test
    public void testEnqueue(){
        queue = new Queue(size);
        Random random = new Random();

        //Peacefully inserting size elements
        for(int i=0; i<size; i++){
            assertTrue(queue.enqueue(random.nextInt()));
        }

        //Since the queue is now full, it should return false
        for(int i=0; i<size; i++){
            assertFalse(queue.enqueue(random.nextInt()));
        }
    }

    @Test
    public void testDequeue(){
        queue = new Queue(size);
        Integer[] initialisedElements = new Integer[size];

        Random random = new Random();

        //Initialising with size elements
        for(int i=0; i<size; i++){
            initialisedElements[i] = random.nextInt();
            assertTrue(queue.enqueue(initialisedElements[i]));
        }

        //Dequeuing size/2 elements peacefully
        for(int i=0; i<size/2; i++){
            assertEquals(queue.dequeue(), initialisedElements[i]);
        }

        //Capacity should now be size - size/2 (this needs to be done to avoid flooring issues for int division)
        assertEquals(queue.getCapacity(), size - size/2);

        //Again enqueing to full capacity to check if the indices are working properly
        for(int i=0; i<size/2; i++){
            assertNotNull(queue.enqueue(random.nextInt()));
        }

        //Now the capacity is 0
        assertEquals(queue.getCapacity(), 0);

        //Dequeuing all size elements this time peacefully
        for(int i=0; i<size; i++){
            assertNotNull(queue.dequeue());
        }

        //Further dequeuing will return null
        for(int i=0; i<10; i++){
            assertNull(queue.dequeue());
        }
    }
}
